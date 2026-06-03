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
import com.example.demo.dto.LocatieRequest;
import com.example.demo.dto.LocatieResponse;
import com.example.demo.service.LocatieService;

@RestController
@RequestMapping("/api")
public class LocatieRestController {

	private final LocatieService service;
	
	public LocatieRestController(LocatieService service) {
		this.service = service;
	}
	
	@GetMapping("/locatie")
	@ResponseStatus(HttpStatus.OK)
	public List<LocatieResponse> getAllLocaties(){
		return service.getAllLocaties();
	}
	
	@GetMapping("/locatie/{id}")
	@ResponseStatus(HttpStatus.OK)
	public LocatieResponse getLocatieDetails(@PathVariable Long id){
		return service.getLocatieDetails(id);
	}
	
	@PutMapping("/locatie/{id}")
	@ResponseStatus(HttpStatus.OK)
	public LocatieResponse updateLocatie(@PathVariable Long id, @RequestBody LocatieRequest request) {
		return service.updateLocatie(id, request);
	}
	
	@PostMapping("/locatie")
	@ResponseStatus(HttpStatus.CREATED)
	public LocatieResponse registerLocatie(@RequestBody LocatieRequest request) {
		return service.registerLocatie(request);
	}
	
	@DeleteMapping("/locatie/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteLocatie(@PathVariable Long id) {
		return service.deleteLocatie(id);
	}
}
