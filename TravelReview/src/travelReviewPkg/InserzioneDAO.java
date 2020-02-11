package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class InserzioneDAO {
	
	private Inserzione inserzione;
	
	public InserzioneDAO(Controller ctrl) {
		
	}
	
	public boolean addInsertion(Connection con, PreparedStatement ps, String placeType, String poster) {
		
		try {
			String query = "INSERT INTO public.\"inserzione\" VALUES ('"+placeType+"', null, DEFAULT, '"+poster+"');";
			
			ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			ps.close();
			
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
