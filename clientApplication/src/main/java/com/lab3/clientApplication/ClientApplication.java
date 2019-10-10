package com.lab3.clientApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ClientApplication {
	@GetMapping("/v1/student/")
	public Student getStudent() {
		Student student = new Student("nack", "Thitisupakul");
		System.out.println(student.getFirstname());
		return student;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
