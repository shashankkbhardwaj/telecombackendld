package com.telecom.broadbandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BroadbandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BroadbandServiceApplication.class, args);
	}

}
