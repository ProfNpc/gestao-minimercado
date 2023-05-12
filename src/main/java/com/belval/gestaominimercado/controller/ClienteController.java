package com.belval.gestaominimercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.service.CarrinhoService;
import com.belval.gestaominimercado.service.ClienteService;
import com.belval.gestaominimercado.web.dto.ClienteDto;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	private CarrinhoService carrinhoService;
	
	public ClienteController(ClienteService clienteService) {
		
		this.clienteService = clienteService;
	}
	
	@ModelAttribute("cliente")
	public ClienteDto userDto() {
		return new ClienteDto();
	}
	
	@GetMapping("/login")
	public String login() {
		return "cliente/Login";
	}
	/*
	@GetMapping("/cliente/detalhe/{id}")
	public String detalhe(@PathVariable("id") int id, Model model) {
		
		Cliente c = repository.findById(id);
		
		if(c == null) {
			return "nao-encontrado";
		}
		
		model.addAttribute("cliente",c);
		
		return "detalheC";
	}
	
	@GetMapping("/cliente/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		Cliente c = repository.findById(id);
		if (c == null) {
			return "nao-encontrado";
		}
		model.addAttribute("cliente", c);
		return "RegistroUser";
	}
	
	@GetMapping("/cliente/list")
	public String list(Model model){
		model.addAttribute("clientes", repository.findAll());
		return "ListaC";
	}
	*/
}
