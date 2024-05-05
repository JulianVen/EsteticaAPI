package com.java.api.services.implement;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.java.api.entities.Client;
import com.java.api.models.ClientModel;
import com.java.api.models.ResponseModel;
import com.java.api.repository.IClientRepository;
import com.java.api.services.interfaces.IClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseModel<List<ClientModel>> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return new ResponseModel<List<ClientModel>>(
            new Date(),
            200,
            "Successful action",
            clients.stream().map(client -> modelMapper.map(client, ClientModel.class)).toList()
        );
    }

}
