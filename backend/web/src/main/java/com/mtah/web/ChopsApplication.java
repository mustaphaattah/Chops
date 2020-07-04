package com.mtah.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.mtah"})
@EntityScan(basePackages = {"com.mtah"})
@EnableJpaRepositories(basePackages = {"com.mtah"})
public class ChopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChopsApplication.class, args);
    }
}
