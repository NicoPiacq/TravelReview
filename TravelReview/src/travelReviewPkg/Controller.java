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
				checkLastDay(day, 2, year);
				break;
			}
			
			case 4: {
				checkLastDay(day, month, year);
				break;
			}
			
			case 6: {
				checkLastDay(day, month, year);
				break;
			}
			
			case 9: {
				checkLastDay(day, month, year);
				break;
			}
			
			case 11: {
				checkLastDay(day, month, year);
				break;
			}
			
			default: {
				frameLogin.hideDateError();
				break;
			}
		}
	}

	private void checkLastDay(int day, int month, int year) {
		
		try {
			if (day == 30 && month == 2)
				throw new InvalidDateException();
			else if(day == 31)
					throw new InvalidDateException();
				else
					frameLogin.hideDateError();
		}catch(InvalidDateException e) {
			frameLogin.showDateError();
		}
		
		try {
			if( (day == 29) && ( (year%400 == 0) || ( (year%4 == 0) && (year%100 != 0) ) ) )
				frameLogin.hideDateError();
			else
				throw new InvalidDateException();
		}catch(InvalidDateException e) {
			frameLogin.showDateError();
		}
		
	}

	public void checkRegistration(String username, String password, String firstName, String lastName, boolean termsAccepted) {
		try {
			if(username.length() == 0)
				throw new EmptyFieldException();
			else
				frameLogin.hideUsernameError();
		} catch(EmptyFieldException e) {
			frameLogin.showUsernameError();
		}
		
		try {
			if(password.length() == 0)
				throw new EmptyFieldException();
			else
				frameLogin.hidePasswordError();
		} catch (EmptyFieldException e) {
			frameLogin.showPasswordError();
		}
		
		try {
			if(firstName.length() == 0)
				throw new EmptyFieldException();
			else
				frameLogin.hideFirstNameError();
		} catch (EmptyFieldException e) {
			frameLogin.showFirstNameError();
		}
		
		try {
			if(lastName.length() == 0)
				throw new EmptyFieldException();
			else
				frameLogin.hideSurnameError();
		} catch (EmptyFieldException e) {
			frameLogin.showSurnameError();
		}
		
		try {
			if(!termsAccepted)
				throw new UncheckedTermsException();
			else
				frameLogin.hideTermsError();
		} catch (Exception e) {
			frameLogin.showTermsError();
		}
	}
	
}
