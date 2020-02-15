package travelReviewPkg;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Date;

public class Utente {
	
	private String name;
	private String surname;
	private String username;
	private String password;
	private Date birthdate;
	private BufferedImage profileImage;

	public Utente(String nome, String cognome, String username, BufferedImage img) {
		
		this.name = nome;
		this.surname = cognome;
		this.username = username;
		
		setProfileImage(img);
		
	}
	
	public String getNome() {
		return name;
	}
	
	public void setNome(String nome) {
		this.name = nome;
	}
	
	public String getCognome() {
		return surname;
	}
	
	public void setCognome(String cognome) {
		this.surname = cognome;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getDataDiNascita() {
		return birthdate;
	}
	
	public void setDataDiNascita(Date dataDiNascita) {
		this.birthdate = dataDiNascita;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public BufferedImage getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(BufferedImage profileImage) {
		this.profileImage = profileImage;
	}
	
}
