package com.java.api.models;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddAppointmentModel {
    private LocalTime time;
    private LocalDate date;
    private int client;
    private int service;
}
