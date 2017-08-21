package com.morkovka.service;

import com.morkovka.entity.OrderLine;
import com.morkovka.repository.IOrderLineRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private IOrderLineRepository orderLineRepository;

    private static final Logger LOGGER = LogManager.getLogger(OrderLineServiceImpl.class.getName());

    public OrderLineServiceImpl() {}

    public OrderLineServiceImpl(IOrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }


    public OrderLine getOrderLineById(Long id) {
        OrderLine orderLine = null;
        try {
            orderLine = this.orderLineRepository.findById(id);
        } catch (Exception e) {
            LOGGER.fatal("failed getting order by id: " + e.getMessage());
        }
        return orderLine;
    }


/*
    @Override
    public void addOrder(IOrderRepository o) {
        this.orderRepository.addNote(note);
    }

    @Override
    public void updateOrder(IOrderRepository note) {
        this.orderRepository.updateNote(note);
    }

    @Override
    public void removeOrder(int id) {
        this.orderRepository.removeNote(id);
    }

    @Override
    public IOrderRepository getOrderById(int id) {
        return this.orderRepository.getBookById(id);
    }

    @Override
    public List<Order> listOrders() {
        return this.orderRepository.listOrders();
    }*/
}