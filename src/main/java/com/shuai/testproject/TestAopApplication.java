package com.shuai.testproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuai
 */
@SpringBootApplication
@MapperScan("com.shuai.testproject.dao")
public class TestAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAopApplication.class, args);
	}

}
