package com.java.api.services.interfaces;

import java.util.List;

import com.java.api.models.ClientModel;
import com.java.api.models.ResponseModel;

public interface IClientService {
    public ResponseModel<List<ClientModel>> getAllClients();
}