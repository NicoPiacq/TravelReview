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
	
	public int countInsertionByCategory(Connection con, PreparedStatement ps, String placeType) {
		
		int numberOfInsertions = 0;
		
		ResultSet rs;
		
		try {
			String query = "SELECT COUNT (codice) FROM "+placeType+";";
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
	
	public ResultSet getInsertions(Connection con, PreparedStatement ps, String placeType) {
		
		ResultSet rs = null;
		
		String query = "SELECT * FROM public.\"inserzione\" WHERE tipo = '"+placeType+"';";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int getInsertionCode(Connection con, PreparedStatement ps) {
		
		ResultSet rs = null;
		int code = 0;
		
		String query = "SELECT MAX(codice) FROM public.\"inserzione\"";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			rs.next();
			code = rs.getInt("max");
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			
		}
		
		return code;
		
	}
	
}
