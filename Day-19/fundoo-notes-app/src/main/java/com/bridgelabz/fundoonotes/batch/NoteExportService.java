package com.bridgelabz.fundoonotes.batch;

import com.bridgelabz.fundoonotes.entity.Note;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

// UC11: exports a user's notes to .xlsx - a direct Apache POI approach, no Batch machinery
// needed here since this is a bounded, single-user dataset (unlike the import side)
@Service
public class NoteExportService {

    private static final String[] HEADERS = {"Title", "Description", "Color", "Type", "Pinned", "Archived"};

    public byte[] exportNotesToExcel(List<Note> notes) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Notes");

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                headerRow.createCell(i).setCellValue(HEADERS[i]);
            }

            int rowIndex = 1;
            for (Note note : notes) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(note.getTitle());
                row.createCell(1).setCellValue(note.getDescription());
                row.createCell(2).setCellValue(note.getColor());
                row.createCell(3).setCellValue(note.getTypeOfNote());
                row.createCell(4).setCellValue(note.isPined());
                row.createCell(5).setCellValue(note.isArchived());
            }

            for (int i = 0; i < HEADERS.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
