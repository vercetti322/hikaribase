package com.app.hikaribase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class HikaribaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikaribaseApplication.class, args);
	}
}
