package com.margad.golomtbank;

import com.margad.model.Users;
import com.margad.repository.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
public class GolomtbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolomtbankApplication.class, args);
	}

}
