package com.shazam.sample.sofa.provider.provider;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.shazam.sample.sofa.interfaces.dto.Order;
import com.shazam.sample.sofa.interfaces.dto.OrderId;
import com.shazam.sample.sofa.interfaces.facade.OrderService;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@SofaService(interfaceType = OrderService.class,uniqueId = "com.shazam.sample.sofa.interfaces.facade.OrderService",bindings = { @SofaServiceBinding(bindingType = "bolt") })
@Component
public class OrderServiceImpl implements OrderService {

    private Map<OrderId,Order> orderMapping = new ConcurrentHashMap<>();

    @Override
    @SentinelResource(value = "OrderServiceImpl.createOrder",fallback = "fallbackCreateOrder",blockHandler = "fallbackCreateOrder")
    public OrderId createOrder(Order order) {
        Validate.notNull(order);
        OrderId orderId = new OrderId("test",System.currentTimeMillis());
        orderMapping.put(orderId,order);
        return orderId;
    }

    public OrderId fallbackCreateOrder(Order order, BlockException blockException){
        System.out.println("fallbackCreateOrder ");
        return new OrderId("test",System.currentTimeMillis());
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
