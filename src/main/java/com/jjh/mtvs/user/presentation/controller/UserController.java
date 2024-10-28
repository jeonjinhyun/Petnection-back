package com.jjh.mtvs.user.presentation.controller;

import com.jjh.mtvs.user.application.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final LoginService loginService;

    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userEmail) {
        return loginService.loginUser(userEmail);
    }
}