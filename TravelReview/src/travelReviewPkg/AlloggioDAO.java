package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlloggioDAO {
	
	private Alloggio alloggio = new Alloggio();
	
	public AlloggioDAO(Controller c) {
		
	}
	
	/* public boolean addInsertionInHotel(Connection con, PreparedStatement ps, String placeSpecialization, String placeName, String city, String address) {
		
		try {
			String query = "INSERT INTO public.\"alloggio\" VALUES ('""');";
			
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
		
		String query = "SELECT * FROM public.\"alloggio\"";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			
		}
		
		return rs;
	}
	
}
