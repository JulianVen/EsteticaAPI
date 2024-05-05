package com.java.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.exceptions.GlobalExceptionHandler;
import com.java.api.services.implement.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientController extends GlobalExceptionHandler{
    private final ClientService clientService;

    @GetMapping
    public String getWelcome(){
        return "Welcome";
    }

}
