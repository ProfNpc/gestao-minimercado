package com.belval.gestaominimercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produto/cadastro")
	public String add(Model model) { 
		model.addAttribute("produto", new Produto());
		return "mercado/produto/RegistroP";
	}
	@PostMapping("/produto/cadastro")
	public String add(@ModelAttribute("produto") Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produto/list";
	}
	
	@GetMapping("/produto/list")
	public String listar(Model model) {
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		return "mercado/produto/ListaP";
	}
	
	@GetMapping("editar/{id}")
	public String att(@PathVariable("id") int id, Model model) {
		Produto produto = produtoRepository.findById(id);
		model.addAttribute("produto", produto);
		return "FD/EditP";
	}
	@PostMapping("atualizar")
	public String att(@ModelAttribute("produto") Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produto/list";
	}
	
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		Produto produto = produtoRepository.findById(id);
		produtoRepository.delete(produto);
		return "redirect:/produto/list";
	}
	
	@GetMapping("/detalhes/{id}")
	public String exibirDetalhes(@PathVariable("id") int id, Model model) {
	    Produto produto = produtoRepository.findById(id);
	    model.addAttribute("produto", produto);
	    return "FD/DetalheP";
	}
}
