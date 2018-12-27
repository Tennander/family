package se.tennander.family;

import com.google.inject.AbstractModule;
import se.tennander.family.config.ConfigModule;
import se.tennander.family.healthchecks.HealthCheckModule;
import se.tennander.family.member.MemberModule;

class ServerModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new ConfigModule());
    install(new HealthCheckModule());
    install(new MemberModule());
  }
}
