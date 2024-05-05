package com.java.api.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.java.api.enums.Role;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Client implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    @Column(nullable = false)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority((role)));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
