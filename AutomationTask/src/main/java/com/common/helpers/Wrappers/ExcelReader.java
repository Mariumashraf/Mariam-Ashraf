package com.common.helpers.Wrappers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    // Get Data from Excel Sheet
    static FileInputStream fis = null;

    public FileInputStream getFileInputStream(String filePath, int totalNumberOfCols) {
        File srcFile = new File(filePath);

        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. terminating Process !! : Check file path of TestData");
            System.exit(0);
        }
        return fis;
    }

    public Object[][] getExcelData(String filePath, int totalNumberOfCols) throws IOException {
        fis = getFileInputStream(filePath, totalNumberOfCols);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum() + 1);

        String[][] arrayExcelData = new String[TotalNumberOfRows][totalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows; i++) {
            for (int j = 0; j < totalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        return arrayExcelData;
    }
}
