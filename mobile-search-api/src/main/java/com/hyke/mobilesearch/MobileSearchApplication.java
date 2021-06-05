package com.hyke.mobilesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MobileSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileSearchApplication.class, args);
	}
}