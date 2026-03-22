package com.app.hikaribase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:secrets.properties")
public class HikaribaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikaribaseApplication.class, args);
	}
}
