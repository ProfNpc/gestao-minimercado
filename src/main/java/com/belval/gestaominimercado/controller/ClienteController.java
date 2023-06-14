package com.belval.gestaominimercado.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.belval.gestaominimercado.model.Cliente;
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
	
	@GetMapping("/perfil/{username}")
	public String showPerfilForm(@PathVariable("username") String username, ModelMap model) {
		ClienteDto userDto = new ClienteDto();
		userDto.setEmail(username);
		Cliente user = clienteService.findByEmail(userDto);
		model.addAttribute("cliente", user);
		return "cliente/Perfil";
	}
	@PostMapping("/perfil")
	public String updatePerfilAccount(@ModelAttribute("cliente")ClienteDto userDto) {
		Cliente user = clienteService.update(userDto);
		return "redirect:/perfil/" + user.getEmail();
	}
	
	@GetMapping("/home")
	public String home(Model model){
		String username = clienteService.getAuthenticatedUser().getEmail();
		   model.addAttribute("username", username);
		   return "essenciais/Menu";
	}
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		return "essenciais/Base";
	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse res) {
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
