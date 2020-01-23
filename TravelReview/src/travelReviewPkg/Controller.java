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

	// ELEMENTI PER IL DATABASE
	private Properties props = new Properties();
	private Connection con;
	private String url = "JDBC:postgressql://localhost/TravelReview";
	
	public Controller() {
		
		frameLogin.setVisible(true);
		//frameMain.setVisible(true);
		
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
	
	public boolean isConnected() {
		return connected;
	}
	
	public void verifyAccess() {
		
		String username = frameLogin.getTxtUsername();
		String password = frameLogin.getTxtPassword();
		
		if( username.equals("admin") && password.equals("admin")) {
			frameMain.setVisible(true);
			frameLogin.setVisible(false);
		} 
		else {
			frameLogin.setErrorMessage("Credenziali errate!");
			frameLogin.resetTxtPassword();
			frameLogin.resetTxtUsername();
		}
	}
	
	public void checkDate(int day, int month, int year) {
		
		System.out.println(day+" "+month+" "+year);
		
		switch(month) {
		
			case 2: {
				if( ! ( (day == 29) && ( (year%400 == 0) || ( (year%4 == 0) && (year%100 != 0) ) ) )
					frameLogin.hideDateError();
				else {
					System.out.println("NON BISESTILE");
					frameLogin.hideDateError();
					frameLogin.showDateError();
				}
				
				if(day == 30 || day == 31)
					frameLogin.showDateError();
				else
					frameLogin.hideDateError();
				
				break;
			}
			
			case 4: {
				if(day == 31)
					frameLogin.showDateError();
				else
					frameLogin.hideDateError();
				
				break;
			}
			
			case 6: {
				if(day == 31)
					frameLogin.showDateError();
				else
					frameLogin.hideDateError();
				
				break;
			}
			
			case 9: {
				if(day == 31)
					frameLogin.showDateError();
				else
					frameLogin.hideDateError();
				
				break;
			}
			
			case 11: {
				if(day == 31)
					frameLogin.showDateError();
				else
					frameLogin.hideDateError();
				
				break;
			}
			
			default: {
				frameLogin.hideDateError();
				break;
			}
			
		}
		
	}
	
}
