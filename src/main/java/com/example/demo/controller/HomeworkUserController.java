package com.example.demo.controller;

import com.example.demo.dto.UserSearchCondition;
import com.example.demo.entity.User;
import com.example.demo.service.UserAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class HomeworkUserController {

    private final UserAppService userService;

    public HomeworkUserController(UserAppService userService) {
        this.userService = userService;
    }

    // Exercise 1: GET /users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // Exercise 2: GET /users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // Exercise 3: POST /users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    // Exercise 4: POST /users/search
    @PostMapping("/search")
    public List<User> searchUsers(@RequestBody UserSearchCondition condition) {
        return userService.search(condition);
    }
}
