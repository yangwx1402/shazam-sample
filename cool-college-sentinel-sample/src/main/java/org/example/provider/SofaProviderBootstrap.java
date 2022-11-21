package org.example.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * @author shazam
 * @date 2022/10/20 4:57 PM
 **/
@SpringBootApplication
@ComponentScan("org.example.provider")
public class SofaProviderBootstrap {


    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(SofaProviderBootstrap.class, args);
        System.in.read();
    }
}
