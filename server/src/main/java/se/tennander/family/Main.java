package se.tennander.family;

import java.util.Set;

import com.google.inject.Guice;
import com.google.inject.Inject;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.apibuilder.EndpointGroup;
import se.tennander.family.config.Port;

public class Main {

  private final Javalin javalin;
  private final Set<Service> services;
  private final int port;

  @Inject
  public Main(Javalin javalin, Set<Service> services, @Port int port) {
    this.javalin = javalin;
    this.services = services;
    this.port = port;
  }

  private void startServer() {
    services.forEach(s -> s.wire(generateRoutes("/api/", s.serviceName())));
    javalin.enableStaticFiles("/static");
    javalin.start(port);
  }

  private Service.Routes generateRoutes(String prefix, String serviceName) {
    return (String route, EndpointGroup endpointGroup) ->
        javalin.routes(() -> {
          String trimmed = route.replaceAll("^/", "");
          ApiBuilder.path(prefix + serviceName + "/" + trimmed, endpointGroup);
        });
  }

  public static void main(String[] args) {
    Main server = Guice.createInjector(new ServerModule()).getInstance(Main.class);
    server.startServer();
  }
}
