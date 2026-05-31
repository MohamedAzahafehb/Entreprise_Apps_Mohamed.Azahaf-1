package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.EvenementResponse;
import com.example.demo.service.EvenementService;

//https://www.youtube.com/watch?v=9VmmSOCA2F4&list=PL82C6-O4XrHejlASdecIsroNEbZFYo_X1&index=5
@Controller
public class EvenementController {

	private final EvenementService service;
		
	public EvenementController(EvenementService service) {
		this.service = service;
	}
	
	@GetMapping("/Index")
	public String getIndex(Model model) {
		model.addAttribute("evenmentenList", service.getAllEvenements());
		return "index";
	}
}
