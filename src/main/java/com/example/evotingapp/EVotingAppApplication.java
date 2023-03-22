package com.example.evotingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EVotingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EVotingAppApplication.class, args);
    }

}
