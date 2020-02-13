package travelReviewPkg;

import java.sql.*;

public class RistoranteDAO {
	
	private Ristorante ristorante;
	private InserzioneDAO inserzioneDAO;
	
	public RistoranteDAO(Controller c) {
		inserzioneDAO = new InserzioneDAO(c);
	}
	
	public boolean addInsertionInRestaurant(Connection con, PreparedStatement ps, String placeSpecialization, String placeName, String city, String address) {
		
		try {
			String query = "INSERT INTO public.\"ristorante\" VALUES ('"+placeName+"', '"+address+"', '"+city+"', '"+inserzioneDAO.getInsertionCode(con, ps)+"', '"+placeSpecialization+"');";
			
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
		
		String query = "SELECT * FROM public.\"ristorante\"";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
	
