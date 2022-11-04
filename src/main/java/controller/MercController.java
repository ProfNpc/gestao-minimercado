package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class MercController {
	
	@GetMapping("/cadastro")
	public String cadastro(Model model) {
		return "RegistroUser";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}
	
	@GetMapping("/cadastroM")
	public String cadastroM(Model model) {
		return "RegistroMercado";
	}
	
	@GetMapping("/tc")
	public String tc(Model model) {
		return "TipoDeCadastro";
	}
}
