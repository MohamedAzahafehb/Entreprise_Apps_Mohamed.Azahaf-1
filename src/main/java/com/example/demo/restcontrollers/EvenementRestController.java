package com.example.demo.restcontrollers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EvenementRequest;
import com.example.demo.dto.EvenementResponse;
import com.example.demo.service.EvenementService;

@RestController
@RequestMapping("/api")
public class EvenementRestController {

	private final EvenementService service;
	
	public EvenementRestController(EvenementService service) {
		this.service = service;
	}
	

	//kan hier evt interface van maken en zowel controller als service laten implement -> zelfde methode
	@PostMapping("/evt")
	@ResponseStatus(HttpStatus.CREATED)
	public EvenementResponse registerEvenement(@RequestBody EvenementRequest request) {
		return service.registerEvenement(request);
	}
	
	@GetMapping("/evt")
	public List<EvenementResponse> getAllEvenements(){
		return service.getAllEvenements();
	}
}
