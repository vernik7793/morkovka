package com.morkovka.service;

import com.morkovka.entity.Order;
import com.morkovka.repository.IOrderRepository;

import java.util.List;

public interface OrderService {

    Order getOrderById(Long id);
    List<Order> listOrders();
    void updateOrder(Order order);
    void removeOrder(Long id);
    /*void addOrder(IOrderRepository orderRepository);


    IOrderRepository getOrderById(int id);
    */
}