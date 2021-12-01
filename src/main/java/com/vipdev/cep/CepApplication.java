package com.vipdev.cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CepApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CepApplication.class, args);
	}

}
