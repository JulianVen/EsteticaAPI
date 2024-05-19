package com.java.api.services.interfaces;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

public interface IClientService {
    public void exportToExcel(HttpServletResponse response) throws IOException;
}