package com.java.api.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.exceptions.GlobalExceptionHandler;
import com.java.api.services.implement.ClientService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientController extends GlobalExceptionHandler {
    private final ClientService clientService;

    @GetMapping("/report")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        clientService.exportToExcel(response);
    }

}
