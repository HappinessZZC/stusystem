package com.lemonyangzw.stusystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class StusystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusystemApplication.class, args);
    }

}
