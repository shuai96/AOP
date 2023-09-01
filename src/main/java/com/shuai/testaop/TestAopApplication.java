package com.shuai.testaop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuai.testaop.dao")
public class TestAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAopApplication.class, args);
	}

}
