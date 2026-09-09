package com.bridgelabz.fundoonotes.batch;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;

import java.io.FileInputStream;
import java.io.IOException;

// UC11: reads one row at a time out of the uploaded .xlsx file
// Sheet columns expected, in order: title | description | color | typeOfNote
public class ExcelNoteItemReader implements ItemReader<NoteImportRow> {

    private final DataFormatter dataFormatter = new DataFormatter();

    private Sheet sheet;
    private int currentRow = 1; // row 0 is the header

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) throws IOException {
        String filePath = stepExecution.getJobParameters().getString("filePath");
        Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        this.sheet = workbook.getSheetAt(0);
    }

    @Override
    public NoteImportRow read() {
        if (currentRow > sheet.getLastRowNum()) {
            return null; // signals to Spring Batch that reading is done
        }

        Row row = sheet.getRow(currentRow++);
        if (row == null) {
            return read(); // skip a completely blank row
        }

        NoteImportRow importRow = new NoteImportRow();
        importRow.setTitle(getCellText(row, 0));
        importRow.setDescription(getCellText(row, 1));
        importRow.setColor(getCellText(row, 2));
        importRow.setTypeOfNote(getCellText(row, 3));

        return importRow;
    }

    private String getCellText(Row row, int cellIndex) {
        if (row.getCell(cellIndex) == null) {
            return null;
        }
        String value = dataFormatter.formatCellValue(row.getCell(cellIndex)).trim();
        return value.isEmpty() ? null : value;
    }
}
