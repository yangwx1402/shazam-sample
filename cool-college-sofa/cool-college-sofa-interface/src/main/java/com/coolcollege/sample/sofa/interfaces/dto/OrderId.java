package com.coolcollege.sample.sofa.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderId extends BaseDTO {

    private String tanantId;

    private Long id;
}
