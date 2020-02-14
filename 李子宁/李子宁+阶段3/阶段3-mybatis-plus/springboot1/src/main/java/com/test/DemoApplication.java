package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.mapper")
public class DemoApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		SpringApplication.run(DemoApplication.class, args);
	}

}
