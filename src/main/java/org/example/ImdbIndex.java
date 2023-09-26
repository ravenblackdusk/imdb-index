package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
class ImdbIndex {
    public static void main(String[] args) {
        SpringApplication.run(ImdbIndex.class, args);
    }
}
