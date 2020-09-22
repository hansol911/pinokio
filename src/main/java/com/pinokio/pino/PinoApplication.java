package com.pinokio.pino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PinoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinoApplication.class, args);
    }


}
