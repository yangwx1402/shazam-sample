package com.coolcollege.sample.dubbo.bootstrap;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  @author shazam
  @date 2022/10/20 4:57 PM
**/
@SpringBootApplication
@EnableDubbo(scanBasePackages = {"com.coolcollege.sample.dubbo.provider"})
public class ApplicationBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstrap.class, args);
    }
}
