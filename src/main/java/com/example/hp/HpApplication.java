package com.example.hp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hp.dao")
public class HpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpApplication.class, args);
    }

}
