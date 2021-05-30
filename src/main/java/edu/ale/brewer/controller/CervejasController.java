package edu.ale.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ale.brewer.model.Cerveja;

@Controller
public class CervejasController {

	//GET
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja){
		//model.addAttribute(new Cerveja());
		return "cerveja/CadastroCerveja";
		
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			//model.addAttribute(cerveja);
			//model.addAttribute("mensagem", "Erro no formulario");
			//System.out.println(">>> ERRO !");
			//return "cerveja/CadastroCerveja";
			return novo(cerveja);
					
		}
		
		attributes.addFlashAttribute("mensagem", "Cerneja salvo Com sucesso");
		System.out.println(">>> REgsiter ! wiht beer: " + cerveja.getNome() + " [" + cerveja.getSku() + "]");
		//return "cerveja/CadastroCerveja";
		return "redirect:/cervejas/novo";
	}
	
}

