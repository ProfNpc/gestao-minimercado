package com.alessandro.app1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alessandro.app1.model.Produto;

@Controller
public class ProdutoController {

	
	 private static List<Produto> listaProdutos = new ArrayList<Produto>();
	    
	    
	    @GetMapping("/produto/list")
	    public String list(Model model) {
	        
	        model.addAttribute("produtos", listaProdutos);
	        
	        return "lista-produtos";
	    }
	    
	    @GetMapping("/produto/novo")
	    public String novo() {
	        return "novo-produto";
	    }
	    
	    public String qqcoisa(
	            @RequestParam("a") int a,
	            int b, String texto, double sal) {
	        return "";
	    }
	    
	    @PostMapping("/produto/novo")
	    public String novo(
	            @RequestParam("id") int id,
	            @RequestParam("nome") String nome,
	            @RequestParam("descricao") String descricao,
	            @RequestParam("preco") double preco,
	            Model model) {
	        
	        model.addAttribute("id", id);
	        model.addAttribute("nome", nome);
	        model.addAttribute("descricao", descricao);
	        model.addAttribute("preco", preco);
	        
	        return "novo-produto-criado";
	    }
	    
	    @GetMapping("/produto/novo2")
	    public String novo2() {
	        return "novo-produto2";
	    }
	    
	    
	    
	    @PostMapping("/produto/novo2")
	    public ModelAndView novo(Produto prod) {
	        
	        ModelAndView mv =
	                new ModelAndView("novo-produto-criado2");
	        
	        listaProdutos.add(prod);
	        
	        //insert no banco de dados
	        mv.addObject("produto", prod);
	        //model.addAttribute("produto", prod);
	        
	        return mv;
	    }


	}
