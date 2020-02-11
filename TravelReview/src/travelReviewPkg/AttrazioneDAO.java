package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttrazioneDAO {

	private Attrazione attrazione = new Attrazione();
	
	public AttrazioneDAO(Controller c) {
		
	}
	
	/* public boolean addInsertionInAttraction(Connection con, PreparedStatement ps, String placeSpecialization, String placeName, String city, String address) {
		
		try {
			String query = "INSERT INTO public.\"attrazione\" VALUES ('""');";
			
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
	
}
