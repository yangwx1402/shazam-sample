package org.example.consumer;

import org.example.provider.SofaProviderBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.IntStream;

@SpringBootApplication
@ComponentScan("org.example.consumer")
public class SofaConsumerBootStrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SofaConsumerBootStrap.class, args);

        UserServiceClient userService = applicationContext.getBean(UserServiceClient.class);
        IntStream.range(0,20).forEach(index->{
            userService.addUser("name_"+index,index);
        });
    }
}
