package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlloggioDAO {
	
	private Alloggio alloggio = new Alloggio();
	private InserzioneDAO inserzioneDAO;
	
	public AlloggioDAO(Controller c) {
		inserzioneDAO = new InserzioneDAO(c);
	}
	
	public boolean addInsertionInHotel(Connection con, PreparedStatement ps, String placeSpecialization, String placeName, String city, String address) {
		
		try {
			String query = "INSERT INTO public.\"alloggio\" VALUES ('"+placeName+"', '"+address+"', '"+city+"', '"+inserzioneDAO.getInsertionCode(con, ps)+"', '"+placeSpecialization+"');";
			
			ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			ps.close();
			
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ResultSet getInsertions(Connection con, PreparedStatement ps) {
		
		ResultSet rs = null;
		
		String query = "SELECT * FROM public.\"alloggio\"";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			
		}
		
		return rs;
	}
	
}
