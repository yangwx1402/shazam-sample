package com.coolcollege.sample.dubbo.interfaces.facade;

import com.coolcollege.sample.dubbo.interfaces.dto.UserDTO;

import java.util.List;

/**
  @author shazam
  @date 2022/10/20 4:06 PM
**/
public interface UserServiceFacade {

    /**
     *
     * @return
     */
    public List<UserDTO> listUser();

    /**
     *
     * @param id
     * @return
     */
    public UserDTO findUserById(Long id);

    /**
     *
     * @param userDTO
     */
    public void addUser(UserDTO userDTO);
}

