package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {

        String path = "/Users/admin/IdeaProjects/TestNGProje/src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        Cell ulkeler = row.getCell(0);
        Cell baskentler = row.getCell(1);
        Cell meshurlar = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satir sayisi : " + satirSayisi);

        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu satir sayisi : " + doluSatirSayisi);

        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();
        for(int i = 0; i <= sonSatirinIndexi; i++ ){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        System.out.println("----------------");

        for(int i = 0; i <= sonSatirinIndexi; i++ ){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }

        int sutunSayisi = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son sutun sayisi : " + sutunSayisi);

        for(int i = 0; i < sutunSayisi; i++){
            System.out.print(workbook.getSheetAt(0).getRow(3).getCell(i) + " ");
        }


    }

}
