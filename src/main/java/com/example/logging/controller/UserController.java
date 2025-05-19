package com.example.logging.controller;

import com.example.logging.model.User;
import com.example.logging.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("GET /users called");
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("POST /users called with username: {}", user.getUsername());
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        logger.info("DELETE /users/{} called", id);
        userService.deleteUser(id);
    }
}

