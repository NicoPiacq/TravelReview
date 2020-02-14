package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecensioneDAO {

	public RecensioneDAO() {
		
	}
	
	public ResultSet getReviews(Connection con, PreparedStatement ps, int code) {
		
		ResultSet rs = null;
		
		String query = "SELECT * FROM public.\"recensione\" WHERE codice = '"+code+"';";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
