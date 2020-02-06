package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com"})
public class SpringBoot2TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2TestApplication.class, args);
	}

}
