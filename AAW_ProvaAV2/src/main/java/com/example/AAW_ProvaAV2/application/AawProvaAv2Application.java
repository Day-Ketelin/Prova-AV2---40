package com.example.AAW_ProvaAV2.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableReactiveMongoRepositories("com.example.AAW_ProvaAV2.repository")
public class AawProvaAv2Application {

	public static void main(String[] args) {
		SpringApplication.run(AawProvaAv2Application.class, args);
	}

}
