package com.coolcollege.sample.dubbo.consumer.client;

import com.coolcollege.sample.dubbo.interfaces.constants.Constants;
import com.coolcollege.sample.dubbo.interfaces.dto.UserDTO;
import com.coolcollege.sample.dubbo.interfaces.facade.UserServiceFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  @author shazam
  @date 2022/10/20 4:54 PM
**/
@Service
public class UserServiceClient {

    @DubboReference
    private UserServiceFacade userServiceFacade;

    public List<UserDTO> listAllUser(){
        return userServiceFacade.listUser();
    }

    public void addUser(Long id,String name){
        UserDTO userDTO = new UserDTO(id,name);
        userServiceFacade.addUser(userDTO);
    }

    public UserDTO findById(Long id){
        return userServiceFacade.findUserById(id);
    }

}
