package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.model.Locatie;

public record EvenementResponse(
		long id,
		LocalDateTime tijdstip,
		String titel,
		String omschrijving,
		String organisatie,
		String mailadres,
		Locatie locatie
) {}
