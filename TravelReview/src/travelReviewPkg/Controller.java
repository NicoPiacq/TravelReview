package travelReviewPkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller {

	private LoginFrame frameLogin = new LoginFrame(this);
	private MainFrame frameMain;
	
	private JFileChooser chooser = new JFileChooser();
	private int chooserReturn;
	
	private boolean connected = true;
	
	private ListaInserzioni[] list;
	private int index = 0;

	// ELEMENTI PER IL DATABASE
	public Connection con;
	public ResultSet rs;
	public PreparedStatement ps;
	
	// CLASSI DAO
	private UtenteDAO utenteDAO = new UtenteDAO(this);
	private InserzioneDAO inserzioneDAO = new InserzioneDAO(this);
	private RistoranteDAO ristoranteDAO = new RistoranteDAO(this);
	private AlloggioDAO alloggioDAO = new AlloggioDAO(this);
	private AttrazioneDAO attrazioneDAO = new AttrazioneDAO(this);
	
	// CLASSI
	private Utente utente;
	private Inserzione inserzione = new Inserzione();
	private Ristorante ristorante = new Ristorante();
	private Alloggio alloggio  = new Alloggio();
	private Attrazione attrazione = new Attrazione();
	
	public Controller() {
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		// CREAZIONE CONNESSIONE AL DATABASE
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost/travelreview", "postgres", "postgres");
			connected = true;
		}
		catch(SQLException ex) {
			connected = false;
			frameLogin.setMessage("Connessione al Database assente! Riavvia il software.", false);
		}
		
		frameLogin.setVisible(true);
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public int getNumberOfInsertionsByType(String placeType) {
		int number = 0;
		
		number = inserzioneDAO.countInsertionByCategory(con, ps, placeType);
		
		return number;
	}
	
	public ListaInserzioni[] buildList(int numberOfInsertions, String placeType) {
		
		list = new ListaInserzioni[numberOfInsertions];
		int i = 0;
		
		for(int j = 0; j < numberOfInsertions; j++) {
			list[j] = new ListaInserzioni(this);
		}
		
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		switch(placeType) {
			case "ristorante": {
				rs = ristoranteDAO.getInsertions(con, ps);
				rs2 = inserzioneDAO.getInsertions(con, ps, "Ristorante");
				break;
			}
			case "alloggio": {
				rs = alloggioDAO.getInsertions(con, ps);
				rs2 = inserzioneDAO.getInsertions(con, ps, "Alloggio");
				break;
			}
			case "attrazione": {
				rs = attrazioneDAO.getInsertions(con, ps);
				rs2 = inserzioneDAO.getInsertions(con, ps, "Attrazione");
				break;
			}
		}
		
		
		i = 0;
		
		try {
			while(rs.next() && rs2.next()) {
				list[i].setPlaceTitle(rs.getString("nome"));
				list[i].setAddress(rs.getString("via"));
				list[i].setCity(rs.getString("citta"));
				list[i].setPlaceCategory(rs.getString("categoria"));
				list[i].setCode(i);
				list[i].setPoster(rs2.getString("poster"));
				list[i].setType(rs2.getString("tipo"));
				System.out.println("DAL DB HO ESTRATTO QUESTO: "+rs2.getString("tipo"));
				list[i].setAllTexts();
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			}	
		try {
			rs.close();
			rs2.close();
		} 
		catch (SQLException e) {
			
		}
		
		return list;
		
	}
	
	public void showInsertionPage(String type, int index) {
		
		switch(type) {
			case "Ristorante": {
				setRistorante(index);
				frameMain.showInsertionPage(type);
				break;
			}
			case "Alloggio": {
				setAlloggio(index);
				frameMain.showInsertionPage(type);
				break;
			}
			case "Attrazione": {
				setAttrazione(index);
				frameMain.showInsertionPage(type);
				break;
			}
		}
		
	}
	
	public void addInsertion() {
	
		String placeName = frameMain.getPlaceTitle();
		String city = frameMain.getCity();
		String address = frameMain.getAddress();
		String placeType = frameMain.getPlaceType();
		System.out.println(placeType);
		String placeTypeSpecialization = frameMain.getPlaceSpecialization();
		
		try {
			if(inserzioneDAO.addInsertion(con, ps, placeType, getUtente().getUsername())) {
				
				switch(placeType) {
					case "Ristorante": {
						try {
							if(ristoranteDAO.addInsertionInRestaurant(con, ps, placeTypeSpecialization, placeName, city, address)) {
								frameMain.setAddInsertionMessage("Inserzione creata con successo!", true);
							} 
							else {
								throw new Exception();
							}
						}
						catch (Exception ex) {
							frameMain.setAddInsertionMessage("Errore nell'inserimento dell'inserzione!", false);
						}
						break;
					}
					
					case "Alloggio": {
						try {
							if(alloggioDAO.addInsertionInHotel(con, ps, placeTypeSpecialization, placeName, city, address)) {
								frameMain.setAddInsertionMessage("Inserzione creata con successo!", true);
							} 
							else {
								throw new Exception();
							}
						}
						catch (Exception ex) {
							frameMain.setAddInsertionMessage("Errore nell'inserimento dell'inserzione!", false);
						}
						break;
					}
					
					case "Attrazione": {
						try {
							if(attrazioneDAO.addInsertionInAttraction(con, ps, placeTypeSpecialization, placeName, city, address)) {
								frameMain.setAddInsertionMessage("Inserzione creata con successo!", true);
							} 
							else {
								throw new Exception();
							}
						}
						catch (Exception ex) {
							frameMain.setAddInsertionMessage("Errore nell'inserimento dell'inserzione!", false);
						}
						break;
					}
				}
				
				frameMain.showAddInsertionMessage();
			}
			else {
				throw new Exception();	
			}
		}
		catch(Exception ex) {
			frameMain.setAddInsertionMessage("Errore nell'inserimento dell'inserzione!", false);
		}
	}
	
	public void verifyAccess() {
		
		String username = frameLogin.getTxtUsername();
		String password = frameLogin.getTxtPassword();
		
		try {
			utente = utenteDAO.login(con, ps, username, password);
			
			if(utente == null) {
				throw new Exception();
			}
			else {
				frameLogin.setVisible(false);
				
				frameMain = new MainFrame(this);
				
				frameMain.setVisible(true);
			}
		}	
		catch(Exception ex) {
			frameLogin.setMessage("Credenziali errate!", false);
			frameLogin.resetTxtPassword();
			frameLogin.resetTxtUsername();
		}
	}
	
	public void verifyRegistration() {
		
		String username = frameLogin.getTxtRegistrationUsername();
		String password = frameLogin.getTxtRegistrationPassword();
		String name = frameLogin.getTxtRegistrationFirstName();
		String surname = frameLogin.getTxtRegistrationSurname();
		Date birthdate = new Date(frameLogin.getComboBirthYear()-1900, frameLogin.getComboBirthMonth()-1, frameLogin.getComboBirthDay());
		
		
		try {
			
			if(!utenteDAO.register(con, ps, username, password, name, surname, birthdate)) {
				throw new Exception();
			}
			else {
				frameLogin.setMessage("Utente registrato con successo!", true);
				frameLogin.returnToLogin();
				frameLogin.resetRegister();
			}
			
		}
		catch(Exception ex ) {
			frameLogin.setRegistrationMessage("Username non disponibile!", false);
		}
		
	}
	
	public boolean checkDate(int day, int month, int year) {
		
		boolean check;
		
		switch(month) {
		
			case 2: {
				check = checkLastDay(day, 2, year);
				break;
			}
			
			case 4: {
				check = checkLastDay(day, month, year);
				break;
			}
			
			case 6: {
				check = checkLastDay(day, month, year);
				break;
			}
			
			case 9: {
				check = checkLastDay(day, month, year);
				break;
			}
			
			case 11: {
				check = checkLastDay(day, month, year);
				break;
			}
			
			default: {
				frameLogin.hideDateError();
				check = true;
				break;
			}
		}
		return check;
	}

	private boolean checkLastDay(int day, int month, int year) {
		
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
			return false;
		}
		
		return true;
		
	}
	
	public boolean checkLoginFields(String username, String password) {
		boolean checkFields = true;
		
		try {
			if(username.length() == 0)
				throw new EmptyFieldException();
			else
				frameLogin.hideUsernameLoginError();
		} 
		catch(EmptyFieldException e) {
			frameLogin.showUsernameLoginError();
			checkFields = false;
		}
		
		try {
			if(password.length() == 0)
				throw new EmptyFieldException();
			else
				frameLogin.hidePasswordLoginError();
		} 
		catch(EmptyFieldException e) {
			frameLogin.showPasswordLoginError();
			checkFields = false;
		}
		
		return checkFields;
	}
	
	public boolean checkAddInsertion(String placeName, String city, String address) {
		boolean checkFields = true;
		
		try {
			if(placeName.length() == 0 || placeName.contains("  "))
				throw new EmptyFieldException();
			else
				frameMain.hidePlaceTitleError();
		} catch(EmptyFieldException e) {
			frameMain.showPlaceTitleError();
			frameMain.setAddInsertionMessage("Verifica i campi in rosso!", false);
			frameMain.showAddInsertionMessage();
			checkFields = false;
		}
		
		try {
			if(city.length() == 0 || city.contains("  "))
				throw new EmptyFieldException();
			else
				frameMain.hideCityError();
		} catch(EmptyFieldException e) {
			frameMain.showCityError();
			frameMain.setAddInsertionMessage("Verifica i campi in rosso!", false);
			frameMain.showAddInsertionMessage();
			checkFields = false;
		}
		
		try {
			if(address.length() == 0 || address.contains("  "))
				throw new EmptyFieldException();
			else
				frameMain.hideAddressError();
		} catch(EmptyFieldException e) {
			frameMain.showAddressError();
			frameMain.setAddInsertionMessage("Verifica i campi in rosso!", false);
			frameMain.showAddInsertionMessage();
			checkFields = false;
		}
		
		return checkFields;
	}

	public boolean checkRegistration(String username, String password, String firstName, String lastName, boolean termsAccepted) {
		
		boolean checkFields = true;
		boolean checkDate;
		
		try {
			if(username.length() == 0 || username.contains(" "))
				throw new EmptyFieldException();
			else
				frameLogin.hideUsernameError();
		} catch(EmptyFieldException e) {
			frameLogin.showUsernameError();
			checkFields = false;
		}
		
		try {
			if(password.length() == 0 || password.contains(" "))
				throw new EmptyFieldException();
			else
				frameLogin.hidePasswordError();
		} catch (EmptyFieldException e) {
			frameLogin.showPasswordError();
			checkFields = false;
		}
		
		try {
			if(firstName.length() == 0 || firstName.contains("  "))
				throw new EmptyFieldException();
			else
				frameLogin.hideFirstNameError();
		} catch (EmptyFieldException e) {
			frameLogin.showFirstNameError();
			checkFields = false;
		}
		
		try {
			if(lastName.length() == 0 || lastName.contains("  "))
				throw new EmptyFieldException();
			else
				frameLogin.hideSurnameError();
		} catch (EmptyFieldException e) {
			frameLogin.showSurnameError();
			checkFields = false;
		}
		
		try {
			if(!termsAccepted)
				throw new UncheckedTermsException();
			else
				frameLogin.hideTermsError();
		} catch (Exception e) {
			frameLogin.showTermsError();
			checkFields = false;
		}
		
		checkDate = checkDate(frameLogin.getComboBirthDay(), frameLogin.getComboBirthMonth(), frameLogin.getComboBirthYear());
		
		if(checkFields && checkDate)
			return true;
		else
			return false;
			
	}
	
	public void uploadImgProfile() {
		chooser = new JFileChooser();
		chooserReturn = chooser.showOpenDialog(null);
		
		switch(chooserReturn) {
			default: {
				break;
			}
		}
	}
	
	public void uploadImgInsertion() {
		chooser = new JFileChooser();
		chooserReturn = chooser.showOpenDialog(null);
	}

	public Utente getUtente() {
		return utente;
	}
	
	private void setRistorante(int index) {
		ristorante.setCitta(list[index].getCity());
		ristorante.setNome(list[index].getPlaceTitle());
		ristorante.setVia(list[index].getAddress());
		inserzione.setCodice(list[index].getCode());
		inserzione.setPoster(list[index].getPoster());
		inserzione.setTipo("Ristorante");
	}
	
	private void setAttrazione(int index) {
		attrazione.setCitta(list[index].getCity());
		attrazione.setNome(list[index].getPlaceTitle());
		attrazione.setVia(list[index].getAddress());
		inserzione.setCodice(list[index].getCode());
		inserzione.setPoster(list[index].getPoster());
		inserzione.setTipo("Ristorante");
	}
	
	private void setAlloggio(int index) {
		alloggio.setCitta(list[index].getCity());
		alloggio.setNome(list[index].getPlaceTitle());
		alloggio.setVia(list[index].getAddress());
		inserzione.setCodice(list[index].getCode());
		inserzione.setPoster(list[index].getPoster());
		inserzione.setTipo("Ristorante");
	}
	
	public Inserzione getInserzione() {
		return inserzione;
	}
	
	public Ristorante getRistorante() {
		return ristorante;
	}
	
	public Alloggio getAlloggio() {
		return alloggio;
	}
	
	public Attrazione getAttrazione() {
		return attrazione;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
