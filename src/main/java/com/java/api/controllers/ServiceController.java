package com.java.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.exceptions.GlobalExceptionHandler;
import com.java.api.models.ResponseModel;
import com.java.api.models.ServiceModel;
import com.java.api.services.implement.ServiceService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServiceController extends GlobalExceptionHandler {
    private final ServiceService service;

    @GetMapping
    public ResponseEntity<ResponseModel<List<ServiceModel>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/report")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        service.exportToExcel(response);
    }

    @PostMapping
    public ResponseEntity<ResponseModel<ServiceModel>> addService(@RequestBody ServiceModel serviceModel) {
        return ResponseEntity.ok(service.addService(serviceModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel<ServiceModel>> updateService(@PathVariable int id,
            @RequestBody ServiceModel serviceModel) {
        return ResponseEntity.ok(service.updateService(id, serviceModel));
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<ResponseModel<ServiceModel>> deleteService(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteService(id));
    }
}
