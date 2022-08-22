package Tuehv_jv6.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;

import Tuehv_jv6.entity.Order;
import Tuehv_jv6.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/rest/orders")
    public Order getOne(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
}
