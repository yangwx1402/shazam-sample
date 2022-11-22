package com.shazam.sample.sofa.interfaces.dto;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseDTO implements Serializable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
