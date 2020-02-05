package com.example.Cricket;

import com.example.CricketController.CricketController;
import com.example.Match.MatchService;
import com.example.Match.MatchServiceImpl;
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
