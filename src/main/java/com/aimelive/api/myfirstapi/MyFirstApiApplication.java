package com.aimelive.api.myfirstapi;

import com.aimelive.api.myfirstapi.dto.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Tag(
		name = "Welcome",
		description = "Welcome message to this API backend system"

)
public class MyFirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstApiApplication.class, args);
	}

	@GetMapping
	@Operation(
			summary = "Welcome message",
			description = "Welcome message and the version of this API",
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200"
					)
			}
	)
	public ResponseData<String> hello(){
		return new ResponseData<String>("Welcome to our very first API.","Version 1.0.0");
	}

}
