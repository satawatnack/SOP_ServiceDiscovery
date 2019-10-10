package com.sop.lab3.soplab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Soplab3Application {
//	DiscoveryServerApplication
	public static void main(String[] args) {
		SpringApplication.run(Soplab3Application.class, args);
	}

}
