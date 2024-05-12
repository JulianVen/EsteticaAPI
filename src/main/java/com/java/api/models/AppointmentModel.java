package com.java.api.models;

import java.time.LocalDate;
import java.time.LocalTime;

import com.java.api.entities.ServiceEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentModel {
    private int id;
    private LocalTime time;
    private LocalDate date;
    private ClientModel client;
    private ServiceEntity service;
    private boolean isCanceled;
    private boolean isAccepted;
}
