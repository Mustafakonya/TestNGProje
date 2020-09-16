package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {
        String path = "/Users/admin/IdeaProjects/TestNGProje/src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(path);


        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80 000 000");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10 000 000");

        Cell sil = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(sil);

        Row satirSil = workbook.getSheetAt(0).getRow(2);
        workbook.getSheetAt(0).removeRow(satirSil);

        workbook.write(fileOutputStream);





        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }


}
