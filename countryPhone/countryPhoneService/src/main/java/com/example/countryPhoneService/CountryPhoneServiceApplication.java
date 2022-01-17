package com.example.countryPhoneService;

import com.example.countryPhoneService.data.CountryNameMapperSingleton;
import com.example.countryPhoneService.data.CountryNumberMapperSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryPhoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryPhoneServiceApplication.class, args);
		initializeSingletons();

	}

	private static void initializeSingletons() {
		CountryNameMapperSingleton countryNameMapperSingleton = CountryNameMapperSingleton.getInstance();
		CountryNumberMapperSingleton countryNumberMapperSingleton = CountryNumberMapperSingleton.getInstance();
	}

}
