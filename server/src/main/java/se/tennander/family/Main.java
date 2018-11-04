package se.tennander.family;

import java.util.Set;

import com.google.inject.Guice;
import com.google.inject.Inject;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.apibuilder.EndpointGroup;

public class Main {

  private final Javalin javalin;
  private final Set<Service> services;

  @Inject
  public Main(Javalin javalin, Set<Service> services) {
    this.javalin = javalin;
    this.services = services;
  }

  private void startServer() {
    services.forEach(s -> s.wire(generateRoutes(s.serviceName())));
    javalin.start(8080);
  }

  private Service.Routes generateRoutes(String serviceName) {
    return (String route, EndpointGroup endpointGroup) ->
        javalin.routes(() -> {
          String trimmed = route.replaceAll("^/", "");
          ApiBuilder.path("/api/" + serviceName + "/" + trimmed, endpointGroup);
        });
  }

  public static void main(String[] args) {
    Main server = Guice.createInjector(new ServerModule()).getInstance(Main.class);
    server.startServer();
  }
}
