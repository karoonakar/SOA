package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManufacturerFeignClient;
import com.example.model.Manufacturer;

@RestController
public class ManufacturerFeignMSController {

	@Autowired
	private ManufacturerFeignClient  feignClient;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getData() {		
		return feignClient.findAll();
	}
	
	
	@RequestMapping(value = "/findByStartDateBefore", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> findByStartDateBefore() {
		return feignClient.findByStartDateBefore("2016-11-01");
	}
}
