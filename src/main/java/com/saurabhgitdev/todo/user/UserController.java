package com.saurabhgitdev.todo.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("signup")
    public String signup(@RequestBody String entity) {
        //TODO: process POST request

        return entity;
    }

    @PostMapping("login")
    public String login(@RequestBody String entity) {
        //TODO: process POST request

        return entity;
    }

    @GetMapping("current-user")
    public String currentUser() {
        return "Spring Boot REST API is running 🚀";
    }
}
