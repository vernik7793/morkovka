package com.morkovka.controller;

import com.morkovka.entity.OrderLine;
import com.morkovka.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/OrderLines")
public class OrderLineController {
    @Autowired
    OrderLineService orderLineService;
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/get/{idOrderLine}", method = RequestMethod.GET)
    @ResponseBody
    public OrderLine OrderLineById(@PathVariable Long idOrderLine, Model model) {
        return orderLineService.getOrderLineById(idOrderLine);

    }
}