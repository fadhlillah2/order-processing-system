package com.kipas.miniprojectrestapi.controllers;

import com.kipas.miniprojectrestapi.entities.Order;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

}
