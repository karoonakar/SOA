package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;

@RestController
public class OrderMSController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/mrfPost", method = RequestMethod.GET)
	public ResponseEntity<String> getData() {
		List<ServiceInstance> list = client.getInstances("manufacturer-microservices");

		List<Manufacturer> manufacturerList;

		if (list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();

			if (uri != null) {

				Manufacturer manufacturer1 = new Manufacturer(22, new Date(), "MS22");
				Manufacturer manufacturer2 = new Manufacturer(30, new Date(), "MS2");

				manufacturerList = new LinkedList<Manufacturer>();
				manufacturerList.add(manufacturer1);
				manufacturerList.add(manufacturer2);

				try {
					return new RestTemplate().postForEntity(new URI(uri.toString().concat("/datarest")),
							manufacturerList.get(0), String.class);
					
				} catch (RestClientException | URISyntaxException e) {
					e.printStackTrace();
				}
			}

		}

		return null;
	}
}
