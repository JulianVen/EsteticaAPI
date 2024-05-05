package com.java.api.models;

import javax.management.relation.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientModel {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private Role role;
}
