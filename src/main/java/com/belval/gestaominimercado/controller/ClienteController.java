package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.repository.ClienteRepository;
import com.belval.gestaominimercado.service.ClienteService;
import com.belval.gestaominimercado.web.dto.ClienteDto;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		
		this.clienteService = clienteService;
	}
	
	@ModelAttribute("cliente")
	public ClienteDto userDto() {
		return new ClienteDto();
	}
	
	
	@GetMapping("/cliente/cadastro")
	public String cadastro() {
		return "RegistroUser";
	}
	@PostMapping("/cliente/cadastro")
	public String cadastro(@ModelAttribute("user") ClienteDto clienteDto) {
		clienteService.save(clienteDto);
		return "redirect:/cliente/login";
	}
	
	@GetMapping("/cliente/login")
	public String login() {
		return "Login";
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
