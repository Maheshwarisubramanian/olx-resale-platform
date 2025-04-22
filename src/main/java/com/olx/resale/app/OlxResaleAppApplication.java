package com.olx.resale.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OlxResaleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxResaleAppApplication.class, args);
	}

}
