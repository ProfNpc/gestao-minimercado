package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.belval.gestaominimercado.model.CadastroM;
import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.service.CarrinhoService;
import com.belval.gestaominimercado.service.ProdutoService;

@Controller 
public class MercController {
	
	private final ProdutoService produtoService;
    private final CarrinhoService carrinhoService;

    public MercadoController(ProdutoService produtoService, CarrinhoService carrinhoService) {
        this.produtoService = produtoService;
        this.carrinhoService = carrinhoService;
    }

    @GetMapping("/mercado")
    public String mostrarMercado(Model model) {
        List<Produto> produtos = produtoService.listar();
        List<ItemCarrinho> carrinho = carrinhoService.listarItensCarrinho();

        model.addAttribute("produtos", produtos);
        model.addAttribute("carrinho", carrinho);

        return "mercado";
    }
}
