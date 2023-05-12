package com.belval.gestaominimercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.service.ClienteService;
import com.belval.gestaominimercado.web.dto.ClienteDto;

@Controller
public class AuthController {
	
	
	private ClienteService clienteService;
	
	public AuthController(ClienteService clienteService) {
		
		this.clienteService = clienteService;
	}
	
	
	@ModelAttribute("cliente")
	public ClienteDto clienteDto() {
		return new ClienteDto();
	}
	
	@GetMapping("/cliente/cadastro")
	public String cadastro() {
		return "cliente/RegistroUser";
	}
	@PostMapping("/cliente/cadastro")
	public String cadastro(@ModelAttribute("cliente") ClienteDto clienteDto) {
		clienteService.save(clienteDto);
		return "redirect:/cliente/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/registration/ajax/getEmail/{campo}/{valor}")
	public String getSearchResultViaAjaxRegister(@PathVariable("campo") String campo,
			                                     @PathVariable("valor") String valor) {
		
		String msg= "";
		ClienteDto userDto = new ClienteDto();
		userDto.setEmail(valor);
		Cliente user = clienteService.findByEmail(userDto);
		if(user != null) {
			msg = "Email já existe, escolha um email válido!";
		}
		return msg;
	}

}