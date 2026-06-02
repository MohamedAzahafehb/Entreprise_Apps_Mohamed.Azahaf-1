package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Evenement {

	//TODO: leg annotations uit in eigen woorden! gekopieerd van repo docent
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime tijdstip;
	private String titel;
	private String omschrijving;
	private String organisatie;
	private String mailadres;
	
	//https://jakarta.ee/specifications/persistence/4.0/apidocs/jakarta.persistence/jakarta/persistence/manytoone
	//https://jakarta.ee/specifications/persistence/4.0/apidocs/jakarta.persistence/jakarta/persistence/joincolumn
	@ManyToOne
	@JoinColumn(name = "locatieId")
	private Locatie locatie;
	
	public Evenement() {};
	
	public LocalDateTime getTijdstip() {
		return tijdstip;
	}
	public void setTijdstip(LocalDateTime tijdstip) {
		this.tijdstip = tijdstip;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public String getOrganisatie() {
		return organisatie;
	}
	public void setOrganisatie(String organisatie) {
		this.organisatie = organisatie;
	}
	public String getMailadres() {
		return mailadres;
	}
	public void setMailadres(String mailadres) {
		this.mailadres = mailadres;
	}
	public long getId() {
		return id;
	}
	
	public Locatie getLocatie() {
		return locatie;
	}
	
	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}
}
