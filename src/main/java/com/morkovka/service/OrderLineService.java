package com.morkovka.service;

import com.morkovka.entity.OrderLine;

public interface OrderLineService {

    OrderLine getOrderLineById(Long id);
    /*void addOrder(IOrderRepository orderRepository);
    void updateOrder(IOrderRepository orderRepository);
    void removeOrder(int id);
    IOrderRepository getOrderById(int id);
    List<Order> listOrders();*/
}