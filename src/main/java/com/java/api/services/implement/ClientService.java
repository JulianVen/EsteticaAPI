package com.java.api.services.implement;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.api.entities.Client;
import com.java.api.entities.ClientReport;
import com.java.api.repository.IClientReportRepository;
import com.java.api.repository.IClientRepository;
import com.java.api.services.interfaces.IClientService;
import com.java.api.utils.UserExport;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;
    private final IClientReportRepository clientReportRepository;
    private final UserExport userExport;

    @Override
    public void exportToExcel(HttpServletResponse reponse) throws IOException {
        List<ClientReport> clients = clientReportRepository.findAll();
        userExport.exportToExcel(reponse, clients);
    }

}
