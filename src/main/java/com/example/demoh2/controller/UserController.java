package com.example.demoh2.controller;

import com.example.demoh2.domain.dto.UserRequest;
import com.example.demoh2.domain.dto.UserResponse;
import com.example.demoh2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest request) {
        return userService.addUser(request);
    }
}
