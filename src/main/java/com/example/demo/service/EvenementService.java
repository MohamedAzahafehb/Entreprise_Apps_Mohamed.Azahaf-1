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


	private final EvenementRepository evenementRepo;
	private final LocatieRepository locatieRepo;
	
	public EvenementService(EvenementRepository evenementRepo, LocatieRepository locatieRepo) {
		this.evenementRepo = evenementRepo;
		this.locatieRepo = locatieRepo;
	}
	
	public List<EvenementResponse> getAllEvenements(){
		
		return evenementRepo.findTop10().stream().map(e -> new EvenementResponse(
			e.getId(),
			e.getTijdstip(),
			e.getTitel(),
			e.getOmschrijving(),
			e.getOrganisatie(),
			e.getMailadres(),
			e.getLocatie()
		)).toList();		
	}

	public EvenementResponse getEvenementDetails(Long id) {
		return evenementRepo.findById(id).map(e -> new EvenementResponse(
			e.getId(),
			e.getTijdstip(),
			e.getTitel(),
			e.getOmschrijving(),
			e.getOrganisatie(),
			e.getMailadres(),
			e.getLocatie()
		))
		.orElseThrow(); // als niet gevonden: throw NoSuchElementException //chatgpt
	}
	
	public EvenementResponse registerEvenement(EvenementRequest request) {
		return putEnPostHulp(new Evenement(), request);
	}
	
	public EvenementResponse updateEvenement(Long id, EvenementRequest request) {
		return putEnPostHulp(evenementRepo.findById(id).orElseThrow(), request);
	}

	public String deleteEvenement(Long id) {
		evenementRepo.deleteById(id);
		return String.format("Evenement %d is succesvol verwijderd", id);
	}
	
	//hulpmethode omdat ik zeg dat Post en Put grotendeels hetzelfde is
	private EvenementResponse putEnPostHulp(Evenement entity, EvenementRequest request) {
		//TODO: validatie als locatie niet bestaat
		Locatie locatie = locatieRepo.findById(request.locatieId()).get();
		entity.setTijdstip(request.tijdstip());
		entity.setTitel(request.titel());
		entity.setOmschrijving(request.omschrijving());
		entity.setOrganisatie(request.organisatie());
		entity.setMailadres(request.mailadres());
		entity.setLocatie(locatie);
		
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
}
