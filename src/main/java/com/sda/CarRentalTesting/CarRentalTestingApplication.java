package com.sda.CarRentalTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class CarRentalTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalTestingApplication.class, args);
	}

}

