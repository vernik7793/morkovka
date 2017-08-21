package com.morkovka.controller;

import com.morkovka.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morkovka.service.OrderService;

import java.util.List;

@Controller
@RequestMapping(value = "/Orders")

public class MyController {
    @Autowired
    OrderService orderService;
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/get/{idOrder}", method = RequestMethod.GET)
    @ResponseBody
    public Order showOrderById(@PathVariable Long idOrder, Model model) {
        Order order = orderService.getOrderById(idOrder);

        return orderService.getOrderById(idOrder);

    }

    @RequestMapping(value = "/OrderList", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> showOrderList(Model model) {
        return orderService.listOrders();

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void showUpdateOrder(@RequestParam("id") Long id,
                         @RequestParam("client") String client
                         ) throws Exception {
            Order order = orderService.getOrderById(id);
            order.setClient(client);
           orderService.updateOrder(order);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void showDeleteOrder(@RequestParam("id") Long id) throws Exception {
        orderService.removeOrder(id);

    }
}