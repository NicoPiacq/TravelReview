package travelReviewPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RecensioneDAO {

	public RecensioneDAO() {
		
	}
	
	public ResultSet getReviews(Connection con, PreparedStatement ps, int code) {
		
		ResultSet rs = null;
		
		String query = "SELECT * FROM public.\"recensione\" WHERE codInserzione = '"+code+"';";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int countReviewsByCode(Connection con, PreparedStatement ps, int code) {
		
		int numberOfInsertions = 0;
		
		ResultSet rs;
		
		try {
			String query = "SELECT COUNT (codInserzione) FROM \"recensione\" WHERE codInserzione = '"+code+"';";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				numberOfInsertions = rs.getInt("count");
			}
			
			rs.close();
			ps.close();
			
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore sconosciuto");
		}
		
		return numberOfInsertions;
	}
	
	public int countReviewsByUsername(Connection con, PreparedStatement ps, String username) {
		
		int numberOfInsertions = 0;
		
		ResultSet rs;
		
		try {
			String query = "SELECT COUNT (*) FROM \"recensione\" WHERE username = '"+username+"';";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				numberOfInsertions = rs.getInt("count");
			}
			
			rs.close();
			ps.close();
			
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore sconosciuto");
		}
		
		return numberOfInsertions;
	}
	
	public boolean addReview(Connection con, PreparedStatement ps, String reviewTitle, String reviewMessage, String poster, int insertionCode) {
		
		try {
			String query = "INSERT INTO public.\"recensione\" VALUES ('"+reviewTitle+"', '"+reviewMessage+"', '"+poster+"', '"+insertionCode+"');";
			
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
			String query = "SELECT * FROM public.\"recensione\" WHERE username = '"+poster+"' AND codInserzione = '"+code+"'";
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next())
				return true;
		}		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
