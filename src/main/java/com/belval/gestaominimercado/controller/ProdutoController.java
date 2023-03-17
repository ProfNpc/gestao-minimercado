package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.belval.gestaominimercado.model.Produto;

@Controller
public class ProdutoController {
	
	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	
	@GetMapping("/produto/add")
	public String novo(Model model) {
		model.addAttribute("produto", new Produto());
		return "RegistroP";
	}
	@PostMapping("/produto/add")
	public void add(@RequestBody Produto produto) {
		listaProdutos.add(produto);
	}
}
