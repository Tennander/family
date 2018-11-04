package se.tennander.family.hello;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import se.tennander.family.Service;

public class HelloModule extends AbstractModule {
  @Override
  protected void configure() {
    Multibinder<Service> servicesBinder = Multibinder.newSetBinder(binder(), Service.class);
    servicesBinder.addBinding().to(World.class);
  }
}
