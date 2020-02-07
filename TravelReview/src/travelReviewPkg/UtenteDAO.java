package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

public class UtenteDAO {

	private Utente utente;
	
	public UtenteDAO(Controller c) {
		
	}
	
	public Utente login(Connection con, PreparedStatement ps, String username, String password) {
		
		boolean user = false;
		ResultSet rs;
		
		try {
			String query = "SELECT * FROM public.\"utente\" WHERE username='"+username+"' AND psw='"+password+"'";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					utente = new Utente(rs.getString("nome"), rs.getString("cognome"), rs.getString("username"));
					user = true;
			}
			rs.close();
			ps.close();
			
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore sconosciuto");
		}
		
		if(user)
			return utente;
		else
			return utente = null;
	}
	
	public boolean register(Connection con, PreparedStatement ps, String username, String password, String nome, String cognome, Date dataDiNascita) {
		
		try {
			
			String query = "INSERT INTO public.\"utente\" VALUES ('"+nome+"', '"+cognome+"', '"+username+"', '"+password+"', '"+dataDiNascita+"', NULL);";
			
			ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
