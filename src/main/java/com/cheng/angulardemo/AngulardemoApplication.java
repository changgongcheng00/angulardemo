package com.cheng.angulardemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cheng.angulardemo.dao")
public class AngulardemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngulardemoApplication.class, args);
	}

}
