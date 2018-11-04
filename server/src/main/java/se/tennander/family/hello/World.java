package se.tennander.family.hello;

import static io.javalin.apibuilder.ApiBuilder.get;

import io.javalin.Context;
import se.tennander.family.Service;

class World implements Service {
  @Override
  public String serviceName() {
    return "hello";
  }

  @Override
  public void wire(Routes route) {
    route.addRoute("world", () -> get(this::helloWorld));
  }

  private void helloWorld(Context context) {
    context.json("Hello world!!");
  }
}
