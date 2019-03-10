package com.datatrendspotter.datatrendspotter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

public class ExcelReader {
    String path = System.getProperty("user.home");

    public ExcelReader() {
        path += "\\Desktop\\Projects\\HackRU2019\\datatrendspotter\\datatrendspotter\\src" +
                "\\main\\resources\\datasets\\FoodEnvironmentAtlas.xls";
    }

    // Get the names of the sheets in the xls file.
    public ArrayList<String> getSheets() {
        ArrayList<String> sheets = new ArrayList<String>();
        try{
            Workbook workbook = WorkbookFactory.create(new File(path));
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                Sheet sheet = sheetIterator.next();
                sheets.add(sheet.getSheetName());
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }

        return sheets;
    }

    // Get the names of the attributes for each sheet.
    // Attributes will be referred to as sheetname.attribute
    // Use attributes elements as indices for data columns.
   public ArrayList<ArrayList<String>> getAttributes(ArrayList<String> sheets) {
        ArrayList<ArrayList<String>> attributes = new ArrayList<ArrayList<String>>();

        try{
            Workbook workbook = WorkbookFactory.create(new File(path));
            for(int j=0; j<sheets.size(); j++){
                attributes.add(new ArrayList<String>());
                for(int i=0; i<workbook.getSheetAt(j).getRow(0).getLastCellNum(); i++){
                    attributes.get(j).add(sheets.get(j) + "." + workbook.getSheetAt(j).getRow(0).getCell(i)
                    .getRichStringCellValue().toString());
                    //System.out.println(attributes.get(j).get(i));
                }
            }

            // Delete non-numeric data. We're only interested in numbers.
            for(int i=0; i<sheets.size(); i++){
                if(workbook.getSheetAt(i).getRow(0).getCell(0).getCellType() != CellType.NUMERIC){
                    attributes.remove(i);
                    i--;
                }
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
        return attributes;
    }

    // Populate the data entries for each attribute of each sheet.
    // Data is organized under by matching up directly with the attributes
    // ArrayList. Entry data.get(0).get(0) would be the first data point of
    // Read_Me.Food Environment Atlas data download. data.get(0).get(1) would
    // be the second data entry, etc.
    /*
    ArrayList<ArrayList<Double>> getData(ArrayList<ArrayList<String>> attributes) {
        ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();

        try {
            Workbook workbook = WorkbookFactory.create(new File(path));
            for(int i=0; i<workbook.getNumberOfSheets(); i++){
                data.add(new ArrayList<Double>());
                for(int j=0; j<workbook.getSheetAt(i).getRow(0).getLastCellNum(); j++){
                    for(int k=0; k<workbook.getSheetAt(i).getPhysicalNumberOfRows(); k++){
                        data.get(j + (i*10)).add(workbook.getSheetAt(i).getRow(j).getCell(k).getNumericCellValue());
                        System.out.println(data.get(j + (i*10)).get(k));
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }

        return data;
    }
    */


}
