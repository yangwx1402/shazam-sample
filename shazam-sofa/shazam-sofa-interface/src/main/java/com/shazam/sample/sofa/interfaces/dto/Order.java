package com.shazam.sample.sofa.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseDTO {

    private OrderId orderId;

    private String creator;

    private Date createTime;

    private Double amount;
}
