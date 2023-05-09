package com.belval.gestaominimercado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.belval.gestaominimercado.service.ClienteService;

@SpringBootApplication
public class GestaominimercadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaominimercadoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(ClienteService clienteService) {
		return args -> {
			//userService.saveRole(new Role("ROLE_USER"));
			//userService.saveRole(new Role("ROLE_ADMIN"));
			//userService.saveRole(new Role("ROLE_INSTRUCTOR"));
			//userService.saveRole(new Role("ROLE_STUDANT"));	
		};
}
}