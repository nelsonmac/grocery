package com.ir.grocery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroceryApplication {
	
	private static final Logger log = LoggerFactory.getLogger(GroceryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GroceryApplication.class, args);
	}

}
