package com.example.demo.restcontrollers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EvenementRequest;
import com.example.demo.dto.EvenementResponse;
import com.example.demo.service.EmailService;
import com.example.demo.service.EvenementService;

@RestController
@RequestMapping("/api")
public class EvenementRestController {

	private final EvenementService service;
	private final EmailService mailservice;
	
	public EvenementRestController(EvenementService service, EmailService mailservice) {
		this.service = service;
		this.mailservice = mailservice;
	}
	
	@RequestMapping("/send-test-email")
	public String sendTestEmail() {
		mailservice.sendEmail("testmail", "this is a test email message!");
		return "mail is sent";
	}
	
	
	@GetMapping("/evenement")
	@ResponseStatus(HttpStatus.OK)
	public List<EvenementResponse> getAllEvenements(){
		return service.getAllEvenements();
	}
	
	//het gebruik maken van PathVariables voor de ID in de url voor zowel GET, PUT als DELETE:
	//https://spring.io/guides/tutorials/rest
	
	@GetMapping("/evenement/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EvenementResponse getEvenementDetails(@PathVariable Long id){
		return service.getEvenementDetails(id);
	}
	
	@PutMapping("/evenement/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EvenementResponse updateEvenement(@PathVariable Long id, @RequestBody EvenementRequest request) {
		return service.updateEvenement(id, request);
	}
	
	@PostMapping("/evenement")
	@ResponseStatus(HttpStatus.CREATED)
	public EvenementResponse registerEvenement(@RequestBody EvenementRequest request) {
		return service.registerEvenement(request);
	}
	
	@DeleteMapping("/evenement/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteEvenement(@PathVariable Long id) {
		return service.deleteEvenement(id);
	}
}
