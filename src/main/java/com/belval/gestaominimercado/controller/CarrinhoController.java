package com.belval.gestaominimercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.repository.ProdutoRepository;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
    private ProdutoRepository produtoRepository;
	
	private Carrinho carrinho = new Carrinho();
	
	@GetMapping("/mercado")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);
        return "Mercado";
    }
	@PostMapping("/")
    public String adicionarProduto(Model model, @RequestParam int id) {
        Produto produto = produtoRepository.findById(id);
        carrinho.adicionarProduto(produto);
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);
        return "listarProdutos";
    }
	
	@PostMapping("/remover")
    public String removerProduto(Model model, @RequestParam int id) {
        Produto produto = produtoRepository.findById(id);
        carrinho.removerProduto(produto);
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);
        return "listarProdutos";
    }
}
