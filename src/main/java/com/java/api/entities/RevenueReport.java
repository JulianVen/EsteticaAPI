package com.java.api.entities;

import java.util.Date;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Entity;
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
@Table(name = "revenue_report")
public class RevenueReport {
    @Id
    private Date date;
    private Double sum;
}
