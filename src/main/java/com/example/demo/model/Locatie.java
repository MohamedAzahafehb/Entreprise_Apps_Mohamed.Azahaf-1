package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Locatie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String naam;
	private String adres;
	private int capaciteit;
	
	public Locatie() {};
	
	public Locatie(String naam, String adres, int capaciteit) {
		setNaam(naam);
		setAdres(adres);
		setCapaciteit(capaciteit);
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		this.naam = naam;
	}

	public String getAdres() {
		return adres;
	}

	private void setAdres(String adres) {
		this.adres = adres;
	}

	public int getCapaciteit() {
		return capaciteit;
	}

	private void setCapaciteit(int capaciteit) {
		this.capaciteit = capaciteit;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s - %d", getNaam(), getAdres(), getCapaciteit());
	}
}
