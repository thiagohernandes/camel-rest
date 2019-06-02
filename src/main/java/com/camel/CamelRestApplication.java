package com.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages=("com.camel"))
public class CamelRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelRestApplication.class, args);
	}

}
