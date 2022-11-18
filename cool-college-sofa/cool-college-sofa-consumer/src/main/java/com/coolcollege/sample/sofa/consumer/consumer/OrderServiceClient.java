package com.coolcollege.sample.sofa.consumer.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.coolcollege.sample.sofa.interfaces.dto.Order;
import com.coolcollege.sample.sofa.interfaces.dto.OrderId;
import com.coolcollege.sample.sofa.interfaces.facade.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;

@Component
public class OrderServiceClient {

    @SofaReference(interfaceType = OrderService.class,uniqueId = "com.coolcollege.sample.sofa.interfaces.facade.OrderService",binding = @SofaReferenceBinding(bindingType = "bolt"))
    private OrderService orderService;

    public OrderId createOrder(String creator, Date createTime, Double amout){
        Order order = new Order(null,creator,createTime,amout);
        OrderId orderId = orderService.createOrder(order);
        Assert.notNull(orderId);
        System.out.println(orderId);
        return orderId;
    }
}
