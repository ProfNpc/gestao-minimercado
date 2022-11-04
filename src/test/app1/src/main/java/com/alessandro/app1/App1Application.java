package com.alessandro.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App1Application {

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}
	
	//Ctrl+SHIFT+O para importar a definição de GetMapping
	@GetMapping("/")
	public String index() {
		return "Olá Mundo!";
	}

}

