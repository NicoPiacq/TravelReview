package travelReviewPkg;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Utente {
	private String nome;
	private String cognome;
	private String username;
	private Date dataDiNascita;
	private BufferedImage immagineProfilo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public BufferedImage getImmagineProfilo() {
		return immagineProfilo;
	}
	public void setImmagineProfilo(BufferedImage immagineProfilo) {
		this.immagineProfilo = immagineProfilo;
	}
}
