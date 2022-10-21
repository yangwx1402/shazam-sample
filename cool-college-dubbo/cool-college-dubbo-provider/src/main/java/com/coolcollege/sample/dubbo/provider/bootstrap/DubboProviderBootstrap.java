package com.coolcollege.sample.dubbo.provider.bootstrap;

import com.coolcollege.sample.dubbo.interfaces.dto.UserDTO;
import com.coolcollege.sample.dubbo.provider.localconsumer.UserServiceLocalConsumer;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
  @author shazam
  @date 2022/10/20 4:57 PM
**/
@SpringBootApplication
@ComponentScan("com.coolcollege.sample.dubbo.provider")
@EnableDubbo(scanBasePackages = {"com.coolcollege.sample.dubbo.provider.service"})
public class DubboProviderBootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DubboProviderBootstrap.class, args);
        UserServiceLocalConsumer userServiceLocalConsumer = applicationContext.getBean(UserServiceLocalConsumer.class);
        userServiceLocalConsumer.addUser(1L,"shazam");
        List<UserDTO> users = userServiceLocalConsumer.listAllUser();
        System.out.println(users);
        UserDTO user = userServiceLocalConsumer.findById(1L);
        System.out.println(user);
    }
}
