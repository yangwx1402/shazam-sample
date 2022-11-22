package com.shazam.sample.dubbo.provider.localconsumer;

import com.shazam.sample.dubbo.interfaces.dto.UserDTO;
import com.shazam.sample.dubbo.interfaces.facade.UserServiceFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  @author shazam
  @date 2022/10/21 3:45 PM
**/
@Service
public class UserServiceLocalConsumer {

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
