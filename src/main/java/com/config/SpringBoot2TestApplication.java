package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com"})
public class SpringBoot2TestApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot2TestApplication.class, args);
  }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
  	return application.sources(SpringBoot2TestApplication.class);
	}
}
