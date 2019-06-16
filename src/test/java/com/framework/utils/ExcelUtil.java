package com.framework.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtil {

    XSSFWorkbook workbook;

    public ExcelUtil() {
        try {
            workbook = new XSSFWorkbook(this.getClass().getResourceAsStream("/testdata/data.xlsx"));
        } catch (IOException e) {
            System.out.println("Unable to read excel");
        }
    }

    public String getStringCellData(String sheetName,int row, int column){
        return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }


    public double getNumericCellData(String sheetName,int row, int column){
        return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
