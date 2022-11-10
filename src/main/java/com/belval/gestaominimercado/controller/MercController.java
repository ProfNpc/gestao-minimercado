package com.belval.gestaominimercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.belval.gestaominimercado.model.Cadastro;
import com.belval.gestaominimercado.model.CadastroM;

@Controller 
public class MercController {
	
	private static List<Cadastro> listCad= new ArrayList<Cadastro>();
	private static List<CadastroM> listCadM= new ArrayList<CadastroM>();
	
	@GetMapping("/cadastro")
	public String cadastro(Model model) {
		return "RegistroUser";
	}
	@PostMapping("/cadastro")
	public ModelAndView cadastro(Cadastro cad) {
		
		ModelAndView mv = new ModelAndView("");
		
		listCad.add(cad);
		
		mv.addObject("cadastro", cad);
		
		return mv;
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}
	
	@GetMapping("/cadastrom")
	public String cadastroM(Model model) {
		return "RegistroMercado";
	}
	@PostMapping("/cadastrom")
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
