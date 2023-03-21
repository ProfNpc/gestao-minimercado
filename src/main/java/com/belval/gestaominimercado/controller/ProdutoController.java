package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	
	@GetMapping("/produto/add")
	public String add() {
		return "RegistroP";
	}
	@PostMapping("/produto/add")
	public String add(@RequestParam String nome, String descricao, double preco) {
		Produto produto= new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(preco);
		produtoService.cadastrar(produto);
		return "redirect:/produtos";
	}
	
	@GetMapping("/produto/add")
	public String listar(Model model) {
		List<Produto> produtos = produtoService.listar();
		model.addAttribute("produtos", produtos);
		return "ListaP";
	}
}
