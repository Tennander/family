package se.tennander.family.healthchecks;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import se.tennander.family.Service;

public class HealthCheckModule extends AbstractModule {
  @Override
  protected void configure() {
    Multibinder<Service> servicesBinder = Multibinder.newSetBinder(binder(), Service.class);
    servicesBinder.addBinding().to(HealthChecks.class);
  }
}
