package com.java.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.exceptions.GlobalExceptionHandler;
import com.java.api.models.AddClientModel;
import com.java.api.models.AuthModel;
import com.java.api.models.ResponseModel;
import com.java.api.models.TokenModel;
import com.java.api.services.implement.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController extends GlobalExceptionHandler{
    private final AuthService authService;

    @PostMapping("/login")
    private ResponseEntity<ResponseModel<TokenModel>> login(@RequestBody AuthModel credentials){
        return ResponseEntity.ok(authService.login(credentials));
    }

    @PostMapping("/register")
    private ResponseEntity<ResponseModel<TokenModel>>  register(@RequestBody AddClientModel user){
        return ResponseEntity.ok(authService.register(user));
    }
}
