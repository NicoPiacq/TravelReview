package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UtenteDAO {

	private Utente utente = new Utente();
	
	public UtenteDAO(Controller c) {
		
	}
	
	public Utente login(Connection con, PreparedStatement ps, ResultSet rs, String username, String password) {
		
		boolean user = false;
		
		try {
			String query = "SELECT * FROM public.\"utente\" WHERE username='"+username+"' AND psw='"+password+"'";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					utente.setUsername(rs.getString("username"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					System.out.println("DISNEY");
					user = true;
			}
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore sconosciuto");
		}
		
		if(user)
			return utente;
		else
			return utente = null;
	}
	
}
