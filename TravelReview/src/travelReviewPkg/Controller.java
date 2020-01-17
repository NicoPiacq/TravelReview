package travelReviewPkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controller {

	private LoginFrame frameLogin = new LoginFrame(this);
	private MainFrame frameMain = new MainFrame(this);
	private boolean connected = false;


	public boolean isConnected() {
		return connected;
	}

	// ELEMENTI PER IL DATABASE
	private Properties props = new Properties();
	private Connection con;
	private String url = "JDBC:postgressql://localhost/TravelReview";
	
	public Controller() {
		
		frameLogin.setVisible(true);
		frameMain.setVisible(true);
		
		// CREAZIONE CONNESSIONE AL DATABASE
		props.setProperty("username", "postgres");
		props.setProperty("password", "postgres");
		
		try {
			con = DriverManager.getConnection(url, props);
			
			connected = true;
		}
		catch(SQLException ex) {
			connected = false;
		}
		
	}
	
}
