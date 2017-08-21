package com.morkovka.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morkovka.entity.Order;

public interface IOrderRepository extends Repository<Order, Long> {

    List<Order> listOrders();
    Order findById(Long id);
    Order save(Order order);
    void delete(Order order);
}