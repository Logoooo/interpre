package com.laywer.interprelaw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.laywer.interprelaw.mapper")
@SpringBootApplication
public class InterprelawApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterprelawApplication.class, args);
	}


}
