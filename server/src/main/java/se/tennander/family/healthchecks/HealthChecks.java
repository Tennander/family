package se.tennander.family.healthchecks;

import static io.javalin.apibuilder.ApiBuilder.get;

import io.javalin.Context;
import se.tennander.family.Service;

class HealthChecks implements Service {
  @Override
  public String serviceName() {
    return "health";
  }

  @Override
  public void wire(Wiring route) {
    route.addRoute("alive", () -> get(this::helloWorld));
  }

  private void helloWorld(Context context) {
    context.json("yes");
  }
}
