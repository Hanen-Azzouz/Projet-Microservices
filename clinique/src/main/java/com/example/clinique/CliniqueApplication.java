package com.example.clinique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CliniqueApplication {
	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}

}
