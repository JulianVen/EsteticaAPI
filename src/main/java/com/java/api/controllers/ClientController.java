package com.java.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.entities.ClientReport;
import com.java.api.exceptions.GlobalExceptionHandler;
import com.java.api.models.ResponseModel;
import com.java.api.services.implement.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientController extends GlobalExceptionHandler {
    private final ClientService clientService;

    @GetMapping("/report")
    public ResponseEntity<ResponseModel<List<ClientReport>>> getReport() {
        return ResponseEntity.ok(clientService.getReport());
    }

}
