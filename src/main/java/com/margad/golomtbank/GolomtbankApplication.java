package com.margad.golomtbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
public class GolomtbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolomtbankApplication.class, args);
	}

}
