package travelReviewPkg;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class InserzioneDAO {
	
	private Inserzione inserzione;
	
	public InserzioneDAO(Controller ctrl) {
		
	}
	
	public boolean addInsertion(Connection con, PreparedStatement ps, String placeType, String poster, int fileLength, FileInputStream fis) {
		
		try {
			String query = "INSERT INTO public.\"inserzione\" VALUES ('"+placeType+"', (?), DEFAULT, '"+poster+"');";
			
			ps = con.prepareStatement(query);
			ps.setBinaryStream(1, fis, fileLength);
			ps.executeUpdate();
			
			ps.close();
			
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addInsertionNoImg(Connection con, PreparedStatement ps, String placeType, String poster) {
		
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
	
	public boolean uploadImgInsertion(Connection con, PreparedStatement ps, int fileLength, FileInputStream fis, int code) {
		
		try {
			
			String query = "UPDATE public.\"inserzione\" SET immagine = (?) WHERE codice = '"+code+"'";
			
			ps = con.prepareStatement(query);
			
			ps.setBinaryStream(1, fis, fileLength);
			
			ps.executeUpdate();
			
			ps.close();
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public BufferedImage loadImgInsertion(Connection con, PreparedStatement ps, int code) {
		
		BufferedImage bufferedImgInsertion = null;
		
		String query = "SELECT immagine FROM public.\"inserzione\" WHERE codice = '"+code+"'";
		
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				InputStream fileInput = rs.getBinaryStream("immagine");
				
				if(fileInput != null)
					bufferedImgInsertion = ImageIO.read(fileInput);
				else
					bufferedImgInsertion = null;
			}
			
		} catch (SQLException | IOException e) {
			return bufferedImgInsertion = null;
		}
		
		return bufferedImgInsertion;
		
	}
	
}
