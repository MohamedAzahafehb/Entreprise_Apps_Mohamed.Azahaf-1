package model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evenement {

	//TODO: leg annotations uit in eigen woorden! gekopieerd van repo docent
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime tijdstip;
	private String titel;
	private String omschrijving;
	private String Organisatie;
	public Evenement(LocalDateTime tijdstip, String titel, String omschrijving, String organisatie, String mailadres) {
		setMailadres(mailadres);
		setOmschrijving(omschrijving);
		setOrganisatie(organisatie);
		setTijdstip(tijdstip);
		setTitel(titel);
	}
	private String mailadres;
	
	public LocalDateTime getTijdstip() {
		return tijdstip;
	}
	private void setTijdstip(LocalDateTime tijdstip) {
		this.tijdstip = tijdstip;
	}
	public String getTitel() {
		return titel;
	}
	private void setTitel(String titel) {
		this.titel = titel;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	private void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public String getOrganisatie() {
		return Organisatie;
	}
	private void setOrganisatie(String organisatie) {
		Organisatie = organisatie;
	}
	public String getMailadres() {
		return mailadres;
	}
	private void setMailadres(String mailadres) {
		this.mailadres = mailadres;
	}
	public long getId() {
		return id;
	}
}
