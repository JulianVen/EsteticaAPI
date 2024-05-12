package com.java.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceModel {
    private int id;
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private boolean isDeleted;
}
