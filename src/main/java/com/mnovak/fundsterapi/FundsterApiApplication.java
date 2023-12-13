package com.mnovak.fundsterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FundsterApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundsterApiApplication.class, args);
    }

}
