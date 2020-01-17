package travelReviewPkg;

import java.sql.ResultSet;

public class UtenteDAO {

	private Utente utente = new Utente();
	
	public UtenteDAO(Controller c) {
		
	}
	
	public boolean Login(Utente utente) {
		
		String username = utente.getUsername();
		String password = utente.getPassword();
		
		return true;
	}
	
}
