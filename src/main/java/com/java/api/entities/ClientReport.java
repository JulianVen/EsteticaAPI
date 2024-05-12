package com.java.api.entities;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.LazyGroup;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Immutable
@Table(name = "client_report")
public class ClientReport {
    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private String email;
    private String phone;
    private long appointments;
}
