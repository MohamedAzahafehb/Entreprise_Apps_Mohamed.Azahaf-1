package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.EvenementRequest;
import com.example.demo.dto.LocatieRequest;
import com.example.demo.dto.EvenementResponse;
import com.example.demo.dto.LocatieResponse;
import com.example.demo.model.Evenement;
import com.example.demo.model.Locatie;
import com.example.demo.service.EmailService;
import com.example.demo.service.EvenementService;
import com.example.demo.service.LocatieService;


@Controller
public class EvenementController {

	private final EvenementService evenementService;
	private final LocatieService locatieService;
	private final EmailService emailService;
		
	public EvenementController(EvenementService evenementService, LocatieService locatieService, EmailService emailService) {
		this.evenementService = evenementService;
		this.locatieService = locatieService;
		this.emailService = emailService;
	}
	
	@GetMapping({"/", "/Index"})
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
	public String postNewSubmit(@ModelAttribute EvenementRequest request, BindingResult bindingResult, Model model) {
		boolean hasErrors = false;
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("err_general", "Ongeldige invoergegevens ingevuld.");
			hasErrors = true;
		}
		
		if (request.titel() == null || request.titel().trim().isEmpty()) {
			model.addAttribute("err_titel", "Titel is verplicht");
			hasErrors = true;
		}
		if (request.tijdstip() == null) {
			model.addAttribute("err_tijdstip", "Tijdstip is verplicht");
			hasErrors = true;
		}
		if (request.omschrijving() == null || request.omschrijving().trim().isEmpty()) {
			model.addAttribute("err_omschrijving", "Omschrijving is verplicht");
			hasErrors = true;
		}
		if (request.organisatie() == null || request.organisatie().trim().isEmpty()) {
			model.addAttribute("err_organisatie", "Organisatie is verplicht");
			hasErrors = true;
		}
		if (request.mailadres() == null || request.mailadres().trim().isEmpty()) {
			model.addAttribute("err_mailadres", "E-mailadres is verplicht");
			hasErrors = true;
		} else if (!request.mailadres().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			model.addAttribute("err_mailadres", "Vul een geldig e-mailadres in");
			hasErrors = true;
		}
		if (request.locatieId() <= 0) {
			model.addAttribute("err_locatieId", "Locatie is verplicht");
			hasErrors = true;
		}

		if (hasErrors) {
			Evenement e = new Evenement();
			e.setTitel(request.titel());
			e.setTijdstip(request.tijdstip());
			e.setOmschrijving(request.omschrijving());
			e.setOrganisatie(request.organisatie());
			e.setMailadres(request.mailadres());
			if (request.locatieId() > 0) {
				try {
					LocatieResponse locResp = locatieService.getLocatieDetails(request.locatieId());
					Locatie loc = new Locatie();
					loc.setNaam(locResp.naam());
					loc.setAdres(locResp.adres());
					loc.setCapaciteit(locResp.capaciteit());
					e.setLocatie(loc);
				} catch (Exception ex) {
					// Ignore
				}
			}
			
			model.addAttribute("evenement", e);
			model.addAttribute("locaties", locatieService.getAllLocaties());
			return "New";
		}
		
		evenementService.registerEvenement(request);
		return "redirect:/Index";
	}
	
	@GetMapping("/locatie/new")
	public String getNewLocatie(Model model) {
		model.addAttribute("locatie", new Locatie());		
		return "NewLocatie";
	}
	
	@PostMapping("/locatie/new")
	public String postNewLocatie(@ModelAttribute Locatie locatie, Model model) {
		boolean hasErrors = false;
		if (locatie.getNaam() == null || locatie.getNaam().trim().isEmpty()) {
			model.addAttribute("err_naam", "Naam is verplicht");
			hasErrors = true;
		}
		if (locatie.getAdres() == null || locatie.getAdres().trim().isEmpty()) {
			model.addAttribute("err_adres", "Adres is verplicht");
			hasErrors = true;
		}
		if (locatie.getCapaciteit() <= 0) {
			model.addAttribute("err_capaciteit", "Capaciteit moet groter zijn dan 0");
			hasErrors = true;
		}
		
		if (hasErrors) {
			model.addAttribute("locatie", locatie);
			return "NewLocatie";
		}
		
		locatieService.registerLocatie(new LocatieRequest(
			locatie.getNaam(),
			locatie.getAdres(),
			locatie.getCapaciteit()
		));
		
		return "redirect:/New";
	}
	
	@GetMapping("/Details")
	public String getDetails(@RequestParam Long id, Model model) {
		try {
			EvenementResponse evenement = evenementService.getEvenementDetails(id);
			model.addAttribute("evenement", evenement);
			return "Details";
		} catch (Exception e) {
			return "redirect:/Index";
		}
	}
	
	@GetMapping("/About")
	public String getAbout(Model model) {
		return "About";
	}
	
	@GetMapping("/Contact")
	public String getContact(Model model) {
		return "Contact";
	}
	
	@PostMapping("/Contact")
	public String postContact(@RequestParam String subject,
							  @RequestParam String message,
							  Model model) {
		boolean hasErrors = false;
		if (subject == null || subject.trim().isEmpty()) {
			model.addAttribute("err_subject", "Onderwerp is verplicht");
			hasErrors = true;
		}
		if (message == null || message.trim().isEmpty()) {
			model.addAttribute("err_message", "Bericht is verplicht");
			hasErrors = true;
		}
		
		if (hasErrors) {
			model.addAttribute("subject", subject);
			model.addAttribute("message", message);
			return "Contact";
		}
		
		emailService.sendEmail(subject, message);
		return "Contact";
	}
}
