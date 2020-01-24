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
		
		switch(month) {
		
			case 2: {
				checkBissextile(day, year);
				checkLastDay(day, month);
				break;
			}
			
			case 4: {
				checkLastDay(day, month);
				break;
			}
			
			case 6: {
				checkLastDay(day, month);
				break;
			}
			
			case 9: {
				checkLastDay(day, month);
				break;
			}
			
			case 11: {
				checkLastDay(day, month);
				break;
			}
			
			default: {
				frameLogin.hideDateError();
				break;
			}
		}
	}

	private void checkLastDay(int day, int month) {
		
		if( (day == 30 || day == 31) && month == 2)
			frameLogin.showDateError();
		else
			frameLogin.hideDateError();
		
		if(day == 31)
			frameLogin.showDateError();
		else
			frameLogin.hideDateError();
		
	}
	
	private void checkBissextile(int day, int year) {
	
		if( (day == 29) && ( (year%400 == 0) || ( (year%4 == 0) && (year%100 != 0) ) ) )
			frameLogin.hideDateError();
		else
			frameLogin.showDateError();
		
	}

	public void checkRegistration(String username, String password, String firstName, String lastName, boolean termsAccepted) {
		
		if(username.length() == 0)
			frameLogin.showUsernameError();
		else
			frameLogin.hideUsernameError();
		
		if(password.length() == 0)
			frameLogin.showPasswordError();
		else
			frameLogin.hidePasswordError();
		
		if(firstName.length() == 0)
			frameLogin.showFirstNameError();
		else
			frameLogin.hideFirstNameError();
		
		if(lastName.length() == 0)
			frameLogin.showSurnameError();
		else
			frameLogin.hideSurnameError();
		
		if(!termsAccepted)
			frameLogin.showTermsError();
		else
			frameLogin.hideTermsError();
	}
	
}
