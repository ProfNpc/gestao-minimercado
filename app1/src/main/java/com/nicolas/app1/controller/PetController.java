package com.nicolas.app1.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nicolas.app1.model.Pet;

@Controller 
public class PetController {
	
	private static List<Pet> listaPets = new ArrayList<Pet>();

	@GetMapping("/pet")
	public String cadastro(Model model) {
		return "pet";
	}
	
	@PostMapping("/pet")
	public ModelAndView pet(Pet pet) {
		
		ModelAndView mv = new ModelAndView("redirect:/pet/list");
		
		listaPets.add(pet);
		
		//insert no banco de dados
		mv.addObject("pet", pet);
		//model.addAttribute("produto", pet);
		
		return mv;
	}
	
	@GetMapping("/pet/{id}")
	public String detalhe(@PathVariable("id") int id, Model model) {
		for(Pet p: listaPets) {
			
			if(p.getId() == id) {
				model.addAttribute("Pet", p);
				break;
			}
			
		}
		return "detalhePet";
	}
	
	@GetMapping("/pet/list")
	public String list(Model model) {
		
		model.addAttribute("Pets", listaPets);
		
		return "petList";
	}
}
