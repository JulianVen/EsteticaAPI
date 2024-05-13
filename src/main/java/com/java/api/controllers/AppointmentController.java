package com.java.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.exceptions.GlobalExceptionHandler;
import com.java.api.models.AddAppointmentModel;
import com.java.api.models.AppointmentModel;
import com.java.api.models.ResponseModel;
import com.java.api.models.RevenueModel;
import com.java.api.services.implement.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AppointmentController extends GlobalExceptionHandler {
    private final AppointmentService appointmentService;

    @GetMapping("/client")
    public ResponseEntity<ResponseModel<List<AppointmentModel>>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ResponseModel<List<AppointmentModel>>> getAppointments(
            @PathVariable int id) {

        return ResponseEntity.ok(appointmentService.getAppointmentsByClientId(id));
    }

    @GetMapping("/revenues")
    public ResponseEntity<ResponseModel<List<RevenueModel>>> getRevenueReport(
            @RequestParam(name = "start", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam(name = "end", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {

        return ResponseEntity.ok(appointmentService.getRevenueReport(start, end));
    }

    @PostMapping
    public ResponseEntity<ResponseModel<AppointmentModel>> addAppointment(
            @RequestBody AddAppointmentModel addAppointmentModel) {
        return ResponseEntity.ok(appointmentService.addAppointment(addAppointmentModel));
    }

    @PutMapping("/client/{clientId}/appointment/{appointmentId}/cancel")
    public ResponseEntity<ResponseModel<AppointmentModel>> cancelAppointment(
            @PathVariable int clientId,
            @PathVariable int appointmentId) {

        return ResponseEntity.ok(appointmentService.cancelAppointment(clientId, appointmentId));
    }

    @PutMapping("/client/{clientId}/appointment/{appointmentId}/accept")
    public ResponseEntity<ResponseModel<AppointmentModel>> acceptAppointment(
            @PathVariable int clientId,
            @PathVariable int appointmentId) {

        return ResponseEntity.ok(appointmentService.acceptAppointment(clientId, appointmentId));
    }
}
