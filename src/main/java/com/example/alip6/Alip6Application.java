package com.example.alip6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan("com.example.alip6.mapper.*")
public class Alip6Application {

    public static void main(String[] args) {
        SpringApplication.run(Alip6Application.class, args);
    }

}
