package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.belval.gestaominimercado.model.CadastroM;

@Controller 
public class MercController {
	
	private static List<CadastroM> listCadM= new ArrayList<CadastroM>();
	
	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}
	
	@GetMapping("mercado/cadastro")
	public String cadastroM(Model model) {
		return "RegistroMercado";
	}
	@PostMapping("mercado/cadastro")
	public ModelAndView cadastrom(CadastroM cadm) {
		
		ModelAndView mv = new ModelAndView("");
		
		listCadM.add(cadm);
		
		mv.addObject("cadastro", cadm);
		
		return mv;
	}
	
	@GetMapping("/tc")
	public String tc(Model model) {
		return "TipoDeCadastro";
	}
}
