package se.tennander.family.config;

import java.util.Optional;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ConfigModule extends AbstractModule {

  @Provides
  @Port
  int providePort() {
    Optional<String> portString = Optional.ofNullable(System.getenv("PORT"));
    return portString
        .map(Integer::valueOf)
        .orElse(8080);
  }
}
