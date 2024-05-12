package com.java.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientModel {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
