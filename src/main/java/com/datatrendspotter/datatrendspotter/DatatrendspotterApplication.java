package com.datatrendspotter.datatrendspotter;
import com.datatrendspotter.datatrendspotter.ExcelReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatatrendspotterApplication {

	public static void main(String[] args) {
		//DEBUGGING
		ExcelReader reader = new ExcelReader();
		SpringApplication.run(DatatrendspotterApplication.class, args);
	}

}
