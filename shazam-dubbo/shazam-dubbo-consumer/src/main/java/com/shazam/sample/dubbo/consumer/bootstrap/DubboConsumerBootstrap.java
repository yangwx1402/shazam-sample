package com.shazam.sample.dubbo.consumer.bootstrap;

import com.shazam.sample.dubbo.consumer.client.UserServiceClient;
import com.shazam.sample.dubbo.interfaces.dto.UserDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
  @author shazam
  @date 2022/10/21 2:06 PM
**/
@SpringBootApplication
@ComponentScan("com.shazam.sample.dubbo.consumer.client")
@EnableAutoConfiguration
public class DubboConsumerBootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DubboConsumerBootstrap.class,args);
        UserServiceClient userServiceClient = applicationContext.getBean(UserServiceClient.class);
        userServiceClient.addUser(1L,"shazam");
        List<UserDTO> users = userServiceClient.listAllUser();
        System.out.println(users);
        UserDTO user = userServiceClient.findById(1L);
        System.out.println(user);
    }
}
