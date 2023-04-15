package com.belval.gestaominimercado.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.repository.CarrinhoRepository;
import com.belval.gestaominimercado.repository.ProdutoRepository;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	//@Resource(name="carrinhoSessao")
//	Carrinho carrinho2;
	
	@Autowired
    private ProdutoRepository produtoRepository;
	
	@Autowired
    private CarrinhoRepository carrinhoRepository;
	
	private Carrinho carrinho = new Carrinho();
	
	@GetMapping("/mercado")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);
        return "Mercado";
    }
	
	@GetMapping("/carrinho")
	public String Carrinho(Model model) {
        List<Carrinho> listaItensCarrinho = carrinhoRepository.findAll();
        model.addAttribute("itensCarrinho", listaItensCarrinho);
        return "Carrinho";
    }
	@PostMapping("/carrinho")
    public String adicionarProduto(Model model, @RequestParam int id) {
     //   Carrinho item = new Carrinho(id);
     //   carrinhoRepository.save(item);
        return "redirect:/Carrinho";
    }
	
	@PostMapping("/remover")
    public String removerProduto(Model model, @RequestParam int id) {
        Produto produto = produtoRepository.findById(id);
        carrinhoRepository.delete(carrinho);
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);
        return "listarProdutos";
    }
	
	
}
