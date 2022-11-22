package com.shazam.sample.dubbo.provider.config;

import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  @author shazam
  @date 2022/10/20 5:48 PM
**/
@Configuration
public class ProviderConfiguration {

    @Bean
    public ServiceConfig serviceConfig() {
        ServiceConfig service = new ServiceConfig();
        service.setRegistryIds("zk");
        return service;
    }
}
