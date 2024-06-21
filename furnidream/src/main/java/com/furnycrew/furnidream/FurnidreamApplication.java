package com.furnycrew.furnidream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class FurnidreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurnidreamApplication.class, args);
    }

}
