package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.EvenementRequest;
import com.example.demo.model.Evenement;
import com.example.demo.model.Locatie;
import com.example.demo.service.EvenementService;
import com.example.demo.service.LocatieService;

//https://www.youtube.com/watch?v=9VmmSOCA2F4&list=PL82C6-O4XrHejlASdecIsroNEbZFYo_X1&index=5
@Controller
public class EvenementController {

	private final EvenementService evenementService;
	private final LocatieService locatieService;
		
	public EvenementController(EvenementService evenementService, LocatieService locatieService) {
		this.evenementService = evenementService;
		this.locatieService = locatieService;
	}
	
	// gebruiken van mapping: https://spring.io/guides/gs/handling-form-submission
	
	@GetMapping("/Index")
	public String getIndex(Model model) {
		model.addAttribute("evenmentenList", evenementService.getAllEvenements());
		return "Index";
	}
	
	@GetMapping("/New")
	public String getNewForm(Model model) {
		model.addAttribute("locaties", locatieService.getAllLocaties());
		model.addAttribute("evenement", new Evenement());
		return "New";
	}
	
	@PostMapping("/New")
	public String postNewSubmit(@ModelAttribute EvenementRequest request) {
		evenementService.registerEvenement(request);
		return "ResultNew";
	}
	
	@GetMapping("/locatie/new")
	public String getNewLocatie(Model model) {
		model.addAttribute("locatie", new Locatie());		
		return "NewLocatie";
	}
	
	@GetMapping("/Details")
	public String getDetails(Model model) {
		
		return "Details";
	}
	
	@GetMapping("/About")
	public String getAbout(Model model) {
		
		return "About";
	}
	
	@GetMapping("/Contact")
	public String getContact(Model model) {
		
		return "Contact";
	}
}
