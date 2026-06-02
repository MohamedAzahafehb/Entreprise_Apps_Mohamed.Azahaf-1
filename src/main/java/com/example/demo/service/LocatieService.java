package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LocatieRequest;
import com.example.demo.dto.LocatieResponse;
import com.example.demo.model.Locatie;
import com.example.demo.repository.LocatieRepository;

@Service
public class LocatieService {


	private final LocatieRepository locatieRepo;
	
	public LocatieService(LocatieRepository locatieRepo) {
		this.locatieRepo = locatieRepo;
	}

	public List<LocatieResponse> getAllLocaties() {
		return locatieRepo.findAll().stream().map(l -> new LocatieResponse(
			l.getId(),
			l.getNaam(),
			l.getAdres(),
			l.getCapaciteit()
		)).toList();
	}

	public LocatieResponse getLocatieDetails(Long id) {
		return locatieRepo.findById(id).map(l -> new LocatieResponse(
			l.getId(),
			l.getNaam(),
			l.getAdres(),
			l.getCapaciteit()
		)).orElseThrow();
	}
	
	public LocatieResponse registerLocatie(LocatieRequest request) {
		return putEnPostHulp(new Locatie(), request);
	}

	public LocatieResponse updateLocatie(Long id, LocatieRequest request) {
		return putEnPostHulp(locatieRepo.findById(id).orElseThrow(), request);
	}

	public String deleteLocatie(Long id) {
		locatieRepo.deleteById(id);
		return String.format("Locatie %d is succesvol verwijderd", id);
	}
	
	private LocatieResponse putEnPostHulp(Locatie entity, LocatieRequest request) {
		entity.setAdres(request.adres());
		entity.setNaam(request.naam());
		entity.setCapaciteit(request.capaciteit());
		
		Locatie saved = locatieRepo.save(entity);
		return new LocatieResponse(
			saved.getId(),
			saved.getNaam(),
			saved.getAdres(),
			saved.getCapaciteit()
		);
	}
}
