package com.preetham.centime.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiService3Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiService3Application.class, args);
	}

}
