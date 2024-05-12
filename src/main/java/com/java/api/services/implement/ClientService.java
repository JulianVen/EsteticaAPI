package com.java.api.services.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.api.entities.ClientReport;
import com.java.api.models.ResponseModel;
import com.java.api.repository.IClientReportRepository;
import com.java.api.services.interfaces.IClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
    private final IClientReportRepository clientReportRepository;

    @Override
    public ResponseModel<List<ClientReport>> getReport() {
        List<ClientReport> clientReport = clientReportRepository.findAll();

        return new ResponseModel<List<ClientReport>>(
                new Date(),
                200,
                "Succesfull report",
                clientReport);
    }

}
