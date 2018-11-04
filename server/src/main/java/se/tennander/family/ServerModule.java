package se.tennander.family;

import com.google.inject.AbstractModule;
import se.tennander.family.hello.HelloModule;

class ServerModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new HelloModule());
  }
}
