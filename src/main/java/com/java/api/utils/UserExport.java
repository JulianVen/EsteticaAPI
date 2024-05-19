package com.java.api.utils;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.java.api.entities.Client;
import com.java.api.entities.ClientReport;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserExport extends AbstractReport {

    public void exportToExcel(HttpServletResponse response, List<ClientReport> list) throws IOException {
        newReportExcel();

        // response writer to excel
        response = initResponseForExportExcel(response, "UserExcel");
        ServletOutputStream outputStream = response.getOutputStream();

        // write sheet, title & header
        String[] headers = new String[] { "Identificador", "Nombre", "Email", "Teléfono", "Citas" };
        writeTableHeaderExcel("Clientes", "Reporte de Clientes", headers);

        // write content row
        writeTableData(list);

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public void writeTableData(List<ClientReport> list) {

        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        // write content
        for (ClientReport user : list) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, user.getId(), style);
            createCell(row, columnCount++, user.getName(), style);
            createCell(row, columnCount++, user.getEmail(), style);
            createCell(row, columnCount++, user.getPhone(), style);
            createCell(row, columnCount++, user.getAppointments(), style);
        }
    }
}