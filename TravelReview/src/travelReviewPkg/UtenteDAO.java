package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {

	private Utente utente = new Utente();
	
	public UtenteDAO(Controller c) {
		
	}
	
	public void login(Connection con, PreparedStatement ps, String username, String password) {
		
		String query = "SELECT username, psw FROM utente WHERE username='"+username+"' AND psw='"+password+"'";
		
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("CIAO");
		}
		
	}
	
}
