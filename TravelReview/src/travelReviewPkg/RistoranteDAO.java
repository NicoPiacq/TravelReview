package travelReviewPkg;

import java.sql.*;

public class RistoranteDAO {
	
	private Ristorante ristorante;
	
	public RistoranteDAO(Controller c) {
		
	}
	
	/* public boolean addInsertionInRestaurant(Connection con, PreparedStatement ps, String placeSpecialization, String placeName, String city, String address) {
		
		try {
			String query = "INSERT INTO public.\"ristorante\" VALUES ('""');";
			
			ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			ps.close();
			
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	} */
	
	public ResultSet getInsertions(Connection con, PreparedStatement ps) {
		
		ResultSet rs = null;
		
		String query = "SELECT * FROM public.\"ristorante\"";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			
		}
		
		return rs;
	}
	
}
	
