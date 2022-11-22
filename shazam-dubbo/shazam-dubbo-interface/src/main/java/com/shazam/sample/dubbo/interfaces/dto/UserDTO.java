package com.shazam.sample.dubbo.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
  @author shazam
  @date 2022/10/20 4:06 PM
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
