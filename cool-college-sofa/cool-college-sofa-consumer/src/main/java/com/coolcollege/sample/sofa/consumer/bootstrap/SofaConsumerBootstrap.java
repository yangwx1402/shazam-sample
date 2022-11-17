package com.coolcollege.sample.sofa.consumer.bootstrap;

import com.coolcollege.sample.sofa.consumer.consumer.OrderServiceClient;
import com.coolcollege.sample.sofa.interfaces.dto.OrderId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

/**
  @author shazam
  @date 2022/10/21 2:06 PM
**/
@SpringBootApplication
@ComponentScan("com.coolcollege.sample.sofa.consumer")
@EnableAutoConfiguration
public class SofaConsumerBootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SofaConsumerBootstrap.class,args);
        OrderServiceClient orderServiceClient = applicationContext.getBean(OrderServiceClient.class);
        OrderId orderId = orderServiceClient.createOrder("shazam",new Date(),1000.0);
        System.out.println(orderId);
    }
}
