package com.java.api.services.implement;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.api.entities.Client;
import com.java.api.models.AddClientModel;
import com.java.api.models.AuthModel;
import com.java.api.models.ResponseModel;
import com.java.api.models.TokenModel;
import com.java.api.repository.IClientRepository;
import com.java.api.security.JwtService;
import com.java.api.services.interfaces.IAuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
        private final IClientRepository clientRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public ResponseModel<TokenModel> login(AuthModel credentials) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(credentials.getUsername(),
                                                credentials.getPassword()));
                Client client = clientRepository.findByUsername(credentials.getUsername()).orElseThrow();

                return new ResponseModel<TokenModel>(
                                new Date(),
                                200,
                                "Succesfull login",
                                new TokenModel(client.getId(), client.getUsername(), client.getRole(),
                                                jwtService.getToken(client)));
        }

        @Override
        public ResponseModel<TokenModel> register(AddClientModel clientModel) {
                Client client = Client.builder()
                                .username(clientModel.getUsername())
                                .password(passwordEncoder.encode(clientModel.getPassword()))
                                .firstName(clientModel.getFirstName())
                                .lastName(clientModel.getLastName())
                                .email(clientModel.getEmail())
                                .phone(clientModel.getPhone())
                                .role(clientModel.getRole().toLowerCase().equals("admin") ? "admin" : "user")
                                .build();

                clientRepository.save(client);

                return new ResponseModel<TokenModel>(
                                new Date(),
                                204,
                                "Succesfull register",
                                new TokenModel(client.getId(), client.getUsername(), client.getRole(),
                                                jwtService.getToken(client)));
        }

}
