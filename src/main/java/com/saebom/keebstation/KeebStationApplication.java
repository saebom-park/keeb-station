package com.saebom.keebstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KeebStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeebStationApplication.class, args);
    }

}