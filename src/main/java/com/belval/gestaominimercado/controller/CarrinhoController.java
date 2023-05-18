package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	ArrayList<Carrinho> ListaDeCarrinhos = new ArrayList<>();
	ArrayList<ItemCarrinho> itens= new ArrayList<>();
	HttpSession session;
	int totalItens = 0;
	double valorTotalCarrinho = 0;
	
	Carrinho carrinho = new Carrinho();
	
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
	
	
	   @GetMapping("/mercado/m1")
	    public String mostrarMercado(Model model) {
	      List<Produto> produtos = produtoService.listar();

	       model.addAttribute("produtos", produtos);

	        return "mercado/Mercado";
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
        model.addAttribute("itens", itens);
        return "carrinho/Carrinho";
    }
	
	@PostMapping("/carrinho/remover")
    public String removerProduto(int id) {
		if(id==1) {
			itens.remove(0);
		}
		else
		itens.remove(id);
        return ("redirect:/carrinho");
    }
	@PostMapping("/carrinho/remover")
	public String deleteItem (HttpServletRequest req, HttpServletResponse res, int id) {
		
 
    	    String id = req.getParameter("idProduto");

			long idProduto = Long.parseLong(id);
		
		session = req.getSession();
		ArrayList<ItemCarrinho> listaDeI = (ArrayList<ItemCarrinho>) session.getAttribute("itens") == null
				? itens
				: (ArrayList<ItemCarrinho>) session.getAttribute("itens");
		
		// Procurar item na lista de itens
		boolean achei = false;
		
		for(int i=0; i < listaDeI.size(); i++) {
			if(itens.get(i).getProduto().getId() == idProduto ) {
					itens.remove(itens.get(i));
				achei = true;
				break;
			}
			
		}
		
		return "redirect:/comercio/cart";
	}
	
	@PostMapping("/carrinho/add")
	public String addItemSession(HttpServletRequest req, HttpServletResponse res, int id) {
		
		session = req.getSession();
		
		Produto produto = produtoService.findById(id);
		boolean achei = false;
		if(itens.size() > 0) {
		for(int i =0; i < itens.size(); i++) {
			if(itens.get(i).getProduto().getId() == produto.getId()) {
				itens.get(i).setQuantidade(itens.get(i).getQuantidade() + 1);
				achei = true;
				break;
			}else {
				achei = false;
			}
			
		}
		if(achei == false) {
		   ItemCarrinho itemCarrinho = new ItemCarrinho(produto, 1, produto.getPreco(), 0);
		   itens.add(itemCarrinho);
		}
		
		}else {
			ItemCarrinho itemCarrinho = new ItemCarrinho(produto, 1, produto.getPreco(), 0);
			itens.add(itemCarrinho);
		}
		session.setAttribute("itens", itens);
        
		
		return "redirect:/mercado/m1";
		}
	
}
