package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	private static List<Cliente> listCad= new ArrayList<Cliente>();
	private int next=1;
	
	@GetMapping("/cliente/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("Cliente", new Cliente());
		return "RegistroUser";
	}
	@PostMapping("/cliente/cadastro")
	public ModelAndView cadastro(Cliente cad) {
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/list");

		repository.save(cad);
		
		
		mv.addObject("cadastro", cad);
		
		return mv;
	}
	
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
}
