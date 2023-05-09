package com.belval.gestaominimercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.service.ClienteService;
import com.belval.gestaominimercado.web.dto.ClienteDto;

@Controller
public class AuthController {
	
	
	private ClienteService userService;
	
	public AuthController(ClienteService userService) {
		
		this.userService = userService;
	}
	
	
	@ModelAttribute("user")
	public ClienteDto userDto() {
		return new ClienteDto();
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "registration";
	}
	@PostMapping("/registration")
	public String registerClienteAccount(@ModelAttribute("user") ClienteDto userDto) {
		userService.save(userDto);
		return "redirect:/registration?success";
	}
	
	@ResponseBody
	@RequestMapping(value="/registration/ajax/getEmail/{campo}/{valor}")
	public String getSearchResultViaAjaxRegister(@PathVariable("campo") String campo,
			                                     @PathVariable("valor") String valor) {
		
		String msg= "";
		ClienteDto userDto = new ClienteDto();
		userDto.setEmail(valor);
		Cliente user = userService.findByEmail(userDto);
		if(user != null) {
			msg = "Email já existe, escolha um email válido!";
		}
		return msg;
	}

}