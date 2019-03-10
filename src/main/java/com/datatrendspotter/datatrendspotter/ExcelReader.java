package com.datatrendspotter.datatrendspotter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Iterator;


public class ExcelReader {
    String path = System.getProperty("user.home");

    ExcelReader() {
        path += "\\Desktop\\Projects\\HackRU2019\\datatrendspotter\\datatrendspotter\\src" +
                "\\main\\resources\\datasets\\FoodEnvironmentAtlas.xls";
        System.out.println(path);
    }

}
