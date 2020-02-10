package com.example.Cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class CricketApplication {
	public static void main(String[] args) {
		SpringApplication.run(CricketApplication.class, args);

	}

}
