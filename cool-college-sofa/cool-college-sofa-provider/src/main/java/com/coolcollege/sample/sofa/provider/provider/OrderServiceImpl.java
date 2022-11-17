package com.coolcollege.sample.sofa.provider.provider;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.coolcollege.sample.sofa.interfaces.dto.Order;
import com.coolcollege.sample.sofa.interfaces.dto.OrderId;
import com.coolcollege.sample.sofa.interfaces.facade.OrderService;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@SofaService(interfaceType = OrderService.class,uniqueId = "com.coolcollege.sample.sofa.interfaces.facade.OrderService" )
@Component
public class OrderServiceImpl implements OrderService {

    private Map<OrderId,Order> orderMapping = new ConcurrentHashMap<>();

    @Override
    public OrderId createOrder(Order order) {
        Validate.notNull(order);
        OrderId orderId = new OrderId("test",System.currentTimeMillis());
        orderMapping.put(orderId,order);
        return orderId;
    }

    @Override
    public void modifyOrder(Order order) {
        Validate.notNull(order);
        Validate.notNull(order.getOrderId());
        orderMapping.put(order.getOrderId(),order);
    }

    @Override
    public void cancelOrder(OrderId orderId) {
        Validate.notNull(orderId);
        orderMapping.remove(orderId);
    }

    @Override
    public Order findOrder(OrderId orderId) {
        Validate.notNull(orderId);
        return orderMapping.get(orderId);
    }
}
