package com.example.restapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com/example/restapis/Model"})

public class RestApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApisApplication.class, args);
    }

}
