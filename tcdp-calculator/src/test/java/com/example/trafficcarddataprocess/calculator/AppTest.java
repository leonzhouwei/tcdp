package com.example.trafficcarddataprocess.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class AppTest {
	
	public static void main(String[] args) {
		SpringApplication.run(AppTest.class, args);
	}

}