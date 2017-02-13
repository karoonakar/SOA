package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ManufacturerLBMSController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	//@ResponseBody
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getData() {

		Resources<Manufacturer> resources = null;
		RestTemplate restTemplate = new RestTemplate();
		ServiceInstance serviceInstance = loadBalancerClient.choose("manufacturer-microservices");
		System.out.println("service running on port" + serviceInstance.getPort());
		try {
			resources = (Resources<Manufacturer>) restTemplate
					.getForObject(new URI(serviceInstance.getUri().toString().concat("/datarest")), Resources.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}

		return resources;
	}*/
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getData() {

		RestTemplate restTemplate = new RestTemplate();
		ServiceInstance serviceInstance = loadBalancerClient.choose("manufacturer-microservices");
		System.out.println("service running on port" + serviceInstance.getPort());
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(String.valueOf(serviceInstance.getPort()),HttpStatus.OK); 
		try {
			restTemplate.getForObject(new URI(serviceInstance.getUri().toString().concat("/datarest")), Object.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}

		return responseEntity;
	}

}
