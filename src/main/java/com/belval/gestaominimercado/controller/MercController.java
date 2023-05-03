package com.belval.gestaominimercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.service.ProdutoService;

@Controller 
public class MercController {
	
	@Autowired
	private ProdutoService produtoService;

	/*
    @GetMapping("/mercado")
    public String mostrarMercado(Model model) {
        List<Produto> produtos = produtoService.listar();

        model.addAttribute("produtos", produtos);

        return "mercado";
    }
    */
    
    
}
