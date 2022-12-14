package com.shazam.sample.sofa.consumer.bootstrap;

import com.shazam.sample.sofa.consumer.consumer.OrderServiceClient;
import com.shazam.sample.sofa.interfaces.dto.OrderId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.stream.IntStream;

/**
  @author shazam
  @date 2022/10/21 2:06 PM
**/
@SpringBootApplication
@ComponentScan("com.shazam.sample.sofa.consumer")
@EnableAutoConfiguration
public class SofaConsumerBootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SofaConsumerBootstrap.class,args);
        OrderServiceClient orderServiceClient = applicationContext.getBean(OrderServiceClient.class);
        IntStream.range(0,100).forEach(index->{
            try {
                OrderId orderId = orderServiceClient.createOrder("shazam_"+index,new Date(),1000.0);
                System.out.println(orderId);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
