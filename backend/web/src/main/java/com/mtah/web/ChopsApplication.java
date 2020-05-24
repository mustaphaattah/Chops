package com.mtah.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.mtah" })
public class ChopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChopsApplication.class, args);
    }
}
