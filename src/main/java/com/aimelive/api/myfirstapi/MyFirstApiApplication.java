package com.aimelive.api.myfirstapi;

import com.aimelive.api.myfirstapi.dto.ResponseData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyFirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstApiApplication.class, args);
	}

	@GetMapping
	public ResponseData<String> hello(){
		return new ResponseData<String>("Welcome to our very first API.","Version 1.0.0");
	}

}
