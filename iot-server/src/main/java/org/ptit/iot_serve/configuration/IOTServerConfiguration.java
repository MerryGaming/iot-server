package org.ptit.iot_serve.configuration;

import org.ptit.iot_serve.repository.ControlModeRepository;
import org.ptit.iot_serve.repository.DHT11Repository;
import org.ptit.iot_serve.repository.LightRepository;
import org.ptit.iot_serve.service.ControlModeService;
import org.ptit.iot_serve.service.DHT11Service;
import org.ptit.iot_serve.service.LightService;
import org.ptit.iot_serve.service.impl.ControlModeServiceImpl;
import org.ptit.iot_serve.service.impl.DHT11ServiceImpl;
import org.ptit.iot_serve.service.impl.LightServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaAuditing
@EnableScheduling
public class IOTServerConfiguration {

  @Bean
  public ControlModeService controlModeService(ControlModeRepository repository) {
    return new ControlModeServiceImpl(repository);
  }

  @Bean
  public DHT11Service dht11Service(DHT11Repository repository) {
    return new DHT11ServiceImpl(repository);
  }

  @Bean
  public LightService lightService(LightRepository repository) {
    return new LightServiceImpl(repository);
  }
}
