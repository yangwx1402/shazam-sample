package com.coolcollege.sample.dubbo.dto;

import lombok.Data;

import java.io.Serializable;

/**
  @author shazam
  @date 2022/10/20 4:06 PM
**/
@Data
public class UserDTO implements Serializable {

    private Long id;

    private String name;
}
