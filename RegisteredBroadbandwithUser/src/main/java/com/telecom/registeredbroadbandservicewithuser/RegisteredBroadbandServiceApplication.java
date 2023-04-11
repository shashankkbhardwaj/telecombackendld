package com.telecom.registeredbroadbandservicewithuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisteredBroadbandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisteredBroadbandServiceApplication.class, args);
	}

}
