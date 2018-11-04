package se.tennander.family;

import io.javalin.apibuilder.EndpointGroup;

public interface Service {

  /**
   * Returns the service name
   * @return
   */
  public String serviceName();

  /**
   * Wire the service routes.
   * @param route
   */
  public void wire(Routes route);

  @FunctionalInterface
  public interface Routes {
    void addRoute(String route, EndpointGroup endpointGroup);
  }
}
