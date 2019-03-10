package com.datatrendspotter.datatrendspotter;
import com.datatrendspotter.datatrendspotter.ExcelReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class DatatrendspotterApplication {

	public static void main(String[] args) {
		//DEBUGGING down
		//ExcelReader reader = new ExcelReader();
		//ArrayList<String> sheets = reader.getSheets();
		//System.out.println(sheets.get(0).toString());
		//ArrayList<ArrayList<String>> attributes = reader.getAttributes(sheets);

		SpringApplication.run(DatatrendspotterApplication.class, args);
	}

}
