package com.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mp.mybatis.mapper")
public class MPApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPApplication.class);
    }
}
