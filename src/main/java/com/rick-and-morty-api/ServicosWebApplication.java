package com.romualdo.servicos_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServicosWebApplication {

	@GetMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public String getStatus() {
		return "The API is running!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ServicosWebApplication.class, args);
	}

}
