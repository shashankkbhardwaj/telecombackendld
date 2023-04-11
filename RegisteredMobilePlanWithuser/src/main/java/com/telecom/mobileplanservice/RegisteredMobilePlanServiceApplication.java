package com.telecom.mobileplanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisteredMobilePlanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisteredMobilePlanServiceApplication.class, args);
	}

}
