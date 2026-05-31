package com.example.demo.dto;

import java.time.LocalDateTime;

public record EvenementRequest(
		LocalDateTime tijdstip,
		String titel,
		String omschrijving,
		String organisatie,
		String mailadres,
		long locatieId
) {}