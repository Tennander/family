package se.tennander.family;

import io.javalin.apibuilder.EndpointGroup;

/**
 * A service public facing API.
 * <p>
 * It is one of the route URIs accessible from the api.
 */
public interface Service {

  /**
   * Returns the service name.
   *<p>
   * The name will be prefixed on the URI to the service.
   * @return The name of the service.
   */
  String serviceName();

  /**
   * Wire the service routes.
   * @param wiring Wiring object allowing services to wire end points.
   */
  void wire(Wiring wiring);

  @FunctionalInterface
  interface Wiring {
    void addRoute(String route, EndpointGroup endpointGroup);
  }
}
