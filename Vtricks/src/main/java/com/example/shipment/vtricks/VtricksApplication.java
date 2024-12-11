package com.example.shipment.vtricks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VtricksApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtricksApplication.class, args);
    }

}
