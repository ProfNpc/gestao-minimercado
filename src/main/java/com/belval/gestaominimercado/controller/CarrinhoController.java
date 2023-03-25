package com.belval.gestaominimercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.belval.gestaominimercado.service.CarrinhoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public String adicionarItemCarrinho(@RequestParam int id) {
        carrinhoService.adicionarItemCarrinho(id);

        return "redirect:/mercado";
    }
    
    
    @PostMapping("/remover")
    public String removerItem(@RequestParam("id") Long itemId) {
        itemCarrinhoRepository.deleteById(itemId);
        return "redirect:/carrinho";
    }
}
