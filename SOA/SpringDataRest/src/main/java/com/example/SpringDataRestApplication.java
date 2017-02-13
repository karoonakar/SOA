package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}
}


//http://localhost:8888/sg/swagger-resources
//http://localhost:8888/sg/swagger-ui.html

//https://github.com/krishnamurthypradeep/ConfigData1/blob/master/application.yml