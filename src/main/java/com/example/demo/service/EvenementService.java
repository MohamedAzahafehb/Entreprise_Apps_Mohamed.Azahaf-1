package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EvenementRequest;
import com.example.demo.dto.EvenementResponse;
import com.example.demo.model.Evenement;

import com.example.demo.model.Locatie;
import com.example.demo.repository.EvenementRepository;
import com.example.demo.repository.LocatieRepository;

@Service
public class EvenementService {

	//wrm final?
	private final EvenementRepository evenementRepo;
	private final LocatieRepository locatieRepo;
	
	public EvenementService(EvenementRepository evenementRepo, LocatieRepository locatieRepo) {
		this.evenementRepo = evenementRepo;
		this.locatieRepo = locatieRepo;
	}
	
	public EvenementResponse registerEvenement(EvenementRequest request) {
		
		//TODO: validatie wat als locatie niet bestaat
		Locatie locatie = locatieRepo.findById(request.locatieId()).get();
		
		Evenement entity = new Evenement(
			request.tijdstip(),
			request.titel(),
			request.omschrijving(),
			request.organisatie(),
			request.mailadres(),
			locatie
		);
		
		Evenement saved = evenementRepo.save(entity);
		
		return new EvenementResponse(
			saved.getId(),
			saved.getTijdstip(),
			saved.getTitel(),
			saved.getOmschrijving(),
			saved.getOrganisatie(),
			saved.getMailadres(),
			saved.getLocatie()
		);
	}
	
	public List<EvenementResponse> getAllEvenements(){
		return evenementRepo.findAll().stream().map(e -> new EvenementResponse(
			e.getId(),
			e.getTijdstip(),
			e.getTitel(),
			e.getOmschrijving(),
			e.getOrganisatie(),
			e.getMailadres(),
			e.getLocatie()
		)).toList();
	}
}
