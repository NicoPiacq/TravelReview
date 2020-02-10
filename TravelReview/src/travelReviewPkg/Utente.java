package travelReviewPkg;

import java.util.Date;

public class Utente {
	
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataDiNascita;
	
	
	public Utente(String nome, String cognome, String username) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		
	}
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
