package travelReviewPkg;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.imageio.ImageIO;
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
			
			BufferedImage img = null;
			
			while(rs.next()) {
					try {
						
						if(rs.getBinaryStream("immagineprofilo") != null)
							img = ImageIO.read(rs.getBinaryStream("immagineprofilo"));
						else
							img = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					utente = new Utente(rs.getString("nome"), rs.getString("cognome"), rs.getString("username"), img);
					
					user = true;
			}
			rs.close();
			ps.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
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
			return false;
		}
	}
	
	public void uploadImgProfile(Connection con, PreparedStatement ps, int fileLength, FileInputStream fis, String username) {
		
		try {
			
			String query = "UPDATE public.\"utente\" SET immagineprofilo = (?) WHERE username = '"+username+"'";
			
			ps = con.prepareStatement(query);
			
			ps.setBinaryStream(1, fis, fileLength);
			
			ps.executeUpdate();
			
			ps.close();
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public BufferedImage loadImgProfile(Connection con, PreparedStatement ps, String username) {
		
		BufferedImage bufferedImgProfile = null;
		
		String query = "SELECT immagineprofilo FROM public.\"utente\" WHERE username = '"+username+"'";
		
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				bufferedImgProfile = ImageIO.read(rs.getBinaryStream("immagineprofilo"));
			}
			
		} catch (SQLException | IOException e) {
			
			((Throwable) e).printStackTrace();
		}
		
		return bufferedImgProfile;
		
	}
	
}
