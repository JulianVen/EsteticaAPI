package com.java.api.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIME")
    private LocalTime time;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne()
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
    @Column()
    @Builder.Default()
    private boolean isCanceled = false;
    @Column()
    @Builder.Default()
    private boolean isAccepted = false;
}
