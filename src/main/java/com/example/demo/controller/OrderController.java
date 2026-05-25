package com.example.demo.controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderService orderService;

    @GetMapping("/view")
    public User top() {
        return userMapper.findById(1L);
    }
}