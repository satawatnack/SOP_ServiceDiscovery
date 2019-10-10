package com.lab3.serviceDiscoveryClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Component
@RestController
public class ServiceDiscoveryClient {
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/v1/student")
	public String getStudent() {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> instances = discoveryClient.getInstances("studentservice");
		String serviceUri = String.format("%s/v1/student/", instances.get(0).getUri().toString());
		ResponseEntity<String> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {});

		return restExchange.getBody();
	}
}
