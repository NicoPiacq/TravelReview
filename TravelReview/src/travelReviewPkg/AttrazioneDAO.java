package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttrazioneDAO {

	private Attrazione attrazione = new Attrazione();
	private InserzioneDAO inserzioneDAO;
	
	public AttrazioneDAO(Controller c) {
		inserzioneDAO = new InserzioneDAO(c);
	}
	
	public boolean addInsertionInAttraction(Connection con, PreparedStatement ps, String placeSpecialization, String placeName, String city, String address) {
		
		try {
			String query = "INSERT INTO public.\"attrazione\" VALUES ('"+placeName+"', '"+address+"', '"+city+"', '"+inserzioneDAO.getInsertionCode(con, ps)+"', '"+placeSpecialization+"');";
			System.out.println(inserzioneDAO.getInsertionCode(con, ps));
			
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
		
		String query = "SELECT * FROM public.\"attrazione\"";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			
		}
		
		return rs;
	}
	
}
