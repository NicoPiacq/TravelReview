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
	
	public boolean addReview(Connection con, PreparedStatement ps, String reviewTitle, String reviewMessage, String poster) {
		
		try {
			// QUERY INCOMPLETA
			String query = "INSERT INTO public.\"recensione\" VALUES ('"+reviewTitle+"');";
			
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
	
	public boolean checkUserReview(Connection con, PreparedStatement ps, String poster, int code) {
		
		ResultSet rs = null;
		
		try {
			String query = "SELECT * FROM public.\"recensione\" WHERE poster = '"+poster+"' AND codice = '"+code+"'";
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.first())
				return true;
		}		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
