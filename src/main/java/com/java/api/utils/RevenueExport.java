package com.java.api.utils;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.java.api.entities.RevenueReport;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class RevenueExport extends AbstractReport {

    public void exportToExcel(HttpServletResponse response, List<RevenueReport> list) throws IOException {
        newReportExcel();

        // response writer to excel
        response = initResponseForExportExcel(response, "UserExcel");
        ServletOutputStream outputStream = response.getOutputStream();

        // write sheet, title & header
        String[] headers = new String[] { "Fecha", "Ganancia" };
        writeTableHeaderExcel("Ganacias", "Reporte de Ganancias", headers);

        // write content row
        writeTableData(list);

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public void writeTableData(List<RevenueReport> list) {
        double total = 0.0d;
        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        // write content
        for (RevenueReport user : list) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, user.getDate().toString().split(" ")[0], style);
            createCell(row, columnCount++, user.getSum(), style);

            total += user.getSum();
        }

        Row totalRow = sheet.createRow(startRow++);
        createCell(totalRow, 0, "Total:", style);
        createCell(totalRow, 1, total, style);
    }
}