package com.lemonyangzw.stusystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.lemonyangzw.stusystem.project.**.mapper")
public class StusystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusystemApplication.class, args);
    }

}
