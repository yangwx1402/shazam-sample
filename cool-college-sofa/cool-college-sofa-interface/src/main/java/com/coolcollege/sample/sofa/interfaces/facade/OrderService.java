package com.coolcollege.sample.sofa.interfaces.facade;

import com.coolcollege.sample.sofa.interfaces.dto.Order;
import com.coolcollege.sample.sofa.interfaces.dto.OrderId;

public interface OrderService {

    public OrderId createOrder(Order order);

    public void modifyOrder(Order order);

    public void cancelOrder(OrderId orderId);

    public Order findOrder(OrderId orderId);
}
