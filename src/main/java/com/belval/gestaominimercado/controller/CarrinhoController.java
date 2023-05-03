package com.belval.gestaominimercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.repository.CarrinhoRepository;
import com.belval.gestaominimercado.repository.ItemCarrinhoRepository;
import com.belval.gestaominimercado.repository.ProdutoRepository;
import com.belval.gestaominimercado.service.CarrinhoService;
import com.belval.gestaominimercado.service.ClienteService;
import com.belval.gestaominimercado.service.ItemCarrinhoService;
import com.belval.gestaominimercado.service.ProdutoService;

@Controller

public class CarrinhoController {
	
	//@Resource(name="carrinhoSessao")
//	Carrinho carrinho2;
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	//@Autowired
	//private ItemCarrinhoService itemCarrinhoService;
	
	//@Autowired
	//private CarrinhoService carrinhoService;
	
	@Autowired
    private ProdutoRepository produtoRepository;
	
	@Autowired
    private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;
	
	private Carrinho carrinho = new Carrinho();
	
	
	   @GetMapping("/mercado/m1")
	    public String mostrarMercado(Model model) {
	      List<Produto> produtos = produtoService.listar();

	       model.addAttribute("produtos", produtos);

	        return "mercado";
	    }
	    
	
	
	/*
	@GetMapping("/mercado")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);
        return "Mercado";
    }*/
	
	@GetMapping("/carrinho")
	public String Carrinho(Model model) {
        List<Carrinho> listaItensCarrinho = carrinhoRepository.findAll();
        model.addAttribute("itensCarrinho", listaItensCarrinho);
        return "Carrinho";
    }
	@PostMapping("/carrinho/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") int id , Model model,Carrinho carrinho, ItemCarrinho itemCarrinho) {
		Cliente cliente = clienteService.findById(id);
		Produto produto = produtoService.findById(id);
		if (carrinhoRepository.findByCliente(cliente) == null) {
			carrinho.setCliente(cliente);
			carrinhoRepository.save(carrinho);
		} else {
			carrinho = carrinhoRepository.findByCliente(cliente);
		}
		
		itemCarrinho.setCarrinho(carrinho);
		itemCarrinho.setProduto(produto);
		itemCarrinhoRepository.save(itemCarrinho);
		ModelAndView mv = new ModelAndView("redirect:/carrinho");
		return mv;
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
