package com.telecom.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.telecom.userservice.entities.User;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {
	
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder byCryptPasswordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
		
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		
//		return new WebMvcConfigurer() {
//		
//		@Override
//		public void addCorsMappings(CorsRegistry registry) {
//			registry.addMapping("/user/**").allowedOrigins("*");
//		}
//	};
//		
//	}
	
	
	
	
	
	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//	
//		
//		User user = new User();
//		user.setUsername("8529491619");
//		user.setPassword(this.byCryptPasswordEncoder.encode("shubham"));
//		user.setEmail("shubham@gmail.com");
//		user.setName("Shubham Singh");
//		user.setAddress("nagavara");
//		
//		
//		this.userRepository.save(user);
		
		
		
//	}
	

}
