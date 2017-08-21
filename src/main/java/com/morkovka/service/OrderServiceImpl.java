package com.morkovka.service;

import com.morkovka.entity.Order;
import com.morkovka.repository.IOrderRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private IOrderRepository orderRepository;

    private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class.getName());

    public OrderServiceImpl() {}

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order getOrderById(Long id) {
        Order order = null;
        try {
            order = this.orderRepository.findById(id);
        } catch (Exception e) {
            LOGGER.fatal("failed getting order by id: " + e.getMessage());
        }
        return order;
    }

    public List<Order> listOrders() {
        List<Order> listOrders = null;
        try {
            listOrders = this.orderRepository.listOrders();
        } catch (Exception e) {
            LOGGER.fatal("failed getting order list: " + e.getMessage());
        }
        return listOrders;
    }


    public void updateOrder(Order order) {
        this.orderRepository.save(order);
    }

    public void removeOrder(Long id) {
        Order order = getOrderById(id);
        this.orderRepository.delete(order);

    }

/*
    @Override
    public void addOrder(IOrderRepository o) {
        this.orderRepository.addNote(note);
    }

    @Override


    @Override

    }

    @Override
    public IOrderRepository getOrderById(int id) {
        return this.orderRepository.getBookById(id);
    }

    */

}