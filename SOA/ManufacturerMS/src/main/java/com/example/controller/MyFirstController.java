package com.example.controller;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String greet(){
		Calendar cal = Calendar.getInstance();
		
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		
		return (hr < 12 ) ? "Good Morning" : " Good Afternoon"; 
	}
}
