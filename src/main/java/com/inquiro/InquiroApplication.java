package com.inquiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@EnableMongoAuditing
@SpringBootApplication
public class InquiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquiroApplication.class, args);
	}

}
