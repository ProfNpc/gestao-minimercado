package com.alessandro.app1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alessandro.app1.Pet;


@Controller
public class PetController {
	

	private static List<Pet> ListaPets = new ArrayList<Pet>();
	
	@GetMapping("/pet")
	public String form( ) {
		return "pet-form";
	}
	
	@PostMapping("/pet")
	public ModelAndView novo(Pet pet) {
		
		ModelAndView mv=
				new ModelAndView("redirect:/pet/list");
		
		ListaPets.add(pet);
		
		//insert no bando de dados 
		
		mv.addObject("pet", pet);
		
		//model.addAttribute("produto", prod);
		
		return mv;	
	}

	
	@GetMapping("/pet/list")
	public String list (Model model) {
		
		model.addAttribute(ListaPets);
		
		return "pet-list";
		
		
	}
	
	
	
	//Arrumar
	@GetMapping("/pet/list")
	public String list(
			@RequestParam("id") int id, 
			@RequestParam("nome") String nome,
			@RequestParam("raca") String raca, 
			@RequestParam("idade") int idade, Model model
			) {

		model.addAttribute("id", id);
		model.addAttribute("nome", nome);
		model.addAttribute("raca", raca);
		model.addAttribute("idade", idade);
		
		
		for (Pet p: ListaPets ) {
			if(p.getId() == id) {
				
				model.addAttribute("pet", p);
		break;
			}
		}
		return "pet-list";
		
	}
	
	
	@PostMapping("/pet")
	public String form(Model model) {
		
		
		model.addAttribute("pet", ListaPets);
		
		return "pet-criado";
		
	}
	
	@GetMapping("/pet/{id}")
	public String detalhe(
			
			@PathVariable("id") int id, Model model ) {
		
		Pet p= BuscarPetPeloId(id);
					
			if (p== null){
			return "pet-nao-encontrado";
		}
						
			model.addAttribute("Pet", p);					
		    
			return "detalhe-pet";		
	}

	private Pet BuscarPetPeloId (int id) {
		for (Pet p: ListaPets) {
			if (p.getId()== id) {
				
				return p;
		}	
	}
	return null;	
}

	

}	
	