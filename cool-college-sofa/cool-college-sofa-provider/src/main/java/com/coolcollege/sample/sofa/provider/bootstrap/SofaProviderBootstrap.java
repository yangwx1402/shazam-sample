package com.coolcollege.sample.sofa.provider.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * @author shazam
 * @date 2022/10/20 4:57 PM
 **/
@SpringBootApplication
@ComponentScan("com.coolcollege.sample.sofa.provider")
public class SofaProviderBootstrap {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(SofaProviderBootstrap.class, args);
        System.in.read();
    }
}
