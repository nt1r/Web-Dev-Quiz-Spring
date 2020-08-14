package com.example.demo.api;

import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    private final ObjectMapper objectMapper;

    public OrderController(OrderService orderService) {
        objectMapper = new ObjectMapper();
        this.orderService = orderService;
    }
}
