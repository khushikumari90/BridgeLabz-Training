package com.bridgelabz.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// UC1: basic Spring Boot skeleton, connected to MySQL via application.properties
@SpringBootApplication
public class FundooNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundooNotesApplication.class, args);
    }
}
