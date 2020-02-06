package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {

	private Utente utente = new Utente();
	
	public UtenteDAO(Controller c) {
		
	}
	
	public Utente login(Connection con, PreparedStatement ps, ResultSet rs, String username, String password) throws Exception {
		
		String query = "SELECT username, psw, nome, cognome FROM utente WHERE username='"+username+"' AND psw='"+password+"'";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				utente.setUsername(rs.getString("username"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
			}
			else {
				throw new Exception();
			}
			
		} catch (SQLException e) {
			
		}
		
		return utente;
	}
	
}
