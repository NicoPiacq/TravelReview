package travelReviewPkg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller {

	private LoginFrame frameLogin = new LoginFrame(this);
	private MainFrame frameMain;
	
	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter;
	private int chooserReturn;
	
	private boolean connected = true;
	
	private RigaInserzione[] list;
	private int index = 0;
	private int reviewIndex = 0;
	
	private RigaRecensione[] reviewList;
	
	private File imgInsertionFile;
	private BufferedImage insertionBimg;
	
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
	private RecensioneDAO recensioneDAO = new RecensioneDAO();
	
	// CLASSI
	private Utente utente;
	private Inserzione inserzione = new Inserzione();
	private Ristorante ristorante = new Ristorante();
	private Alloggio alloggio  = new Alloggio();
	private Attrazione attrazione = new Attrazione();
	private Recensione recensione = new Recensione();
	
	public Controller() {
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException ex) {
			frameLogin.setMessage("Driver di connessione non trovato!", false);
			ex.printStackTrace();
		}
		
		// CREAZIONE CONNESSIONE AL DATABASE
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/travelreview", "postgres", "postgres");
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
	
	public int getNumberOfReviewByCode(int code) {
		int number = 0;
		
		number = recensioneDAO.countReviewsByCode(con, ps, code);
		
		return number;
	}
	
	public int getNumberOfInsertionsByType(String placeType) {
		int number = 0;
		
		number = inserzioneDAO.countInsertionByCategory(con, ps, placeType);
		
		return number;
	}
	
	public RigaRecensione[] buildReviewList(int numberOfReviews, int code) {
		
		reviewList = new RigaRecensione[numberOfReviews];
		int i = 0;
		
		for(int j = 0; j < numberOfReviews; j++) {
			reviewList[j] = new RigaRecensione(this);
		}
		
		ResultSet rs = recensioneDAO.getReviews(con, ps, code);
		
		try {
			while(rs.next()) {
				reviewList[i].setTitle(rs.getString("titolo"));
				reviewList[i].setMessage(rs.getString("testo"));
				reviewList[i].setPoster(rs.getString("username"));
				reviewList[i].setCode(i);
				reviewList[i].setAllTexts();
				i++;
			}
			
			rs.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return reviewList;
	}
	
	public RigaInserzione[] buildList(int numberOfInsertions, String placeType) {
		
		list = new RigaInserzione[numberOfInsertions];
		int i = 0;
		
		for(int j = 0; j < numberOfInsertions; j++) {
			list[j] = new RigaInserzione(this);
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
				list[i].setDbCode(rs2.getInt("codice"));
				list[i].setPoster(rs2.getString("poster"));
				list[i].setType(rs2.getString("tipo"));
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
				setInserzione(index);
				frameMain.setlblInsertionImage("Ristorante");
				frameMain.showInsertionPage(type);
				break;
			}
			case "Alloggio": {
				setAlloggio(index);
				setInserzione(index);
				frameMain.setlblInsertionImage("Alloggio");
				frameMain.showInsertionPage(type);
				break;
			}
			case "Attrazione": {
				setAttrazione(index);
				setInserzione(index);
				frameMain.setlblInsertionImage("Attrazione");
				frameMain.showInsertionPage(type);
				break;
			}
		}
		
		frameMain.buildReviewList(list[index].getDbCode());
		
	}
	
	public void refreshReviewList() {
		frameMain.buildReviewList(list[index].getDbCode());
	}
	
	public boolean checkUserReview() {
		
		boolean result = recensioneDAO.checkUserReview(con, ps, getUtente().getUsername(), list[index].getDbCode());
		
		return result;
	}
	
	public void addReview() {
		
		String reviewTitle = frameMain.getTxtReviewTitle();
		String reviewMessage = frameMain.getTxtReviewText();
		String poster = getUtente().getUsername();
		int insertionCode = list[index].getDbCode();		
		
		try {
			if(recensioneDAO.addReview(con, ps, reviewTitle, reviewMessage, poster, insertionCode)) {
				frameMain.setReviewMessage("Recensione creata con successo!", true);
				frameMain.lockAddReview();
				getUserNumberReviews();
				frameMain.hideCreateReviewBtn();
			}
			else
				throw new Exception();
		}
		catch(Exception ex) {
			frameMain.setReviewMessage("Errore nell'inserimento della recensione!", false);
		}
		
	}
	
	public void getUserNumberReviews() {
		
		frameMain.setNumberOfReviews(recensioneDAO.countReviewsByUsername(con, ps, getUtente().getUsername()));
		
	}
	
	public void addInsertion() {
	
		String placeName = frameMain.getPlaceTitle();
		String city = frameMain.getCity();
		String address = frameMain.getAddress();
		String placeType = frameMain.getPlaceType();
		String placeTypeSpecialization = frameMain.getPlaceSpecialization();
		
		try {
			if(address.length() == 0 || address.contains("  "))
				throw new EmptyFieldException();
			else
				frameMain.hideAddressError();
		} 
		catch(EmptyFieldException e) {
			frameMain.showAddressError();
		}
		
		if(imgInsertionFile == null)
			imgInsertionFile = new File("src/resources/no_pic_default.png");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(imgInsertionFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			if(inserzioneDAO.addInsertion(con, ps, placeType, getUtente().getUsername(), (int) imgInsertionFile.length(), fis)) {
				
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
				
				
				imgInsertionFile = null;
				frameMain.showAddInsertionMessage();
			}
			else {
				throw new Exception();	
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			frameMain.setAddInsertionMessage("Errore nell'inserimento dell'inserzione!", false);
			frameMain.showAddInsertionMessage();
		}
	}
	
	public void verifyAccess() {
		
		String username = frameLogin.getTxtUsername();
		String password = frameLogin.getTxtPassword();
		
		try {
			utente = utenteDAO.login(con, ps, username, password);
			
			if(utente == null) {
				throw new SQLException();
			}
			else {
				frameLogin.setVisible(false);
				
				frameMain = new MainFrame(this);
				frameMain.setVisible(true);
				
				getUserNumberReviews();
			}
		}	
		catch(SQLException ex) {
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
				else if(month != 2) {
					frameLogin.hideDateError();
					return true;
				}
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
			if(placeName.length() == 0 || placeName.contains("  ") || placeName.charAt(0) == ' ')
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
			if(city.length() == 0 || city.contains("  ") || city.charAt(0) == ' ')
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
			if(address.length() == 0 || address.contains("  ") || address.charAt(0) == ' ')
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
	
	public boolean checkAddReview(String reviewTitle, String reviewText) {
		boolean checkFields = true;
		
		try {
			if(reviewTitle.contains("  ") || reviewTitle.length() == 0 || reviewTitle.charAt(0) == ' ')
				throw new EmptyFieldException();
			else
				frameMain.hideReviewTitleError();
		} catch(EmptyFieldException e) {
			frameMain.showReviewTitleError();
			frameMain.setReviewMessage("Verifica i campi in rosso!", false);
			checkFields = false;
		}
		
		try {
			if(reviewText.contains("  ") || reviewText.length() == 0 || reviewText.charAt(0) == ' ')
				throw new EmptyFieldException();
			else
				frameMain.hideReviewTextError();
		} catch(EmptyFieldException e) {
			frameMain.showReviewTextError();
			frameMain.setReviewMessage("Verifica i campi in rosso!", false);
			checkFields = false;
		}
		
		return checkFields;
	}

	public boolean checkRegistration(String username, String password, String firstName, String lastName, boolean termsAccepted) {
		
		boolean checkFields = true;
		boolean checkDate;
		
		try {
			if(username.length() == 0 || username.contains(" ") || username.charAt(0) == ' ')
				throw new EmptyFieldException();
			else
				frameLogin.hideUsernameError();
		} catch(EmptyFieldException e) {
			frameLogin.showUsernameError();
			checkFields = false;
		}
		
		try {
			if(password.length() == 0 || password.contains(" ") || password.charAt(0) == ' ')
				throw new EmptyFieldException();
			else
				frameLogin.hidePasswordError();
		} catch (EmptyFieldException e) {
			frameLogin.showPasswordError();
			checkFields = false;
		}
		
		try {
			if(firstName.length() == 0 || firstName.contains("  ") || firstName.charAt(0) == ' ')
				throw new EmptyFieldException();
			else
				frameLogin.hideFirstNameError();
		} catch (EmptyFieldException e) {
			frameLogin.showFirstNameError();
			checkFields = false;
		}
		
		try {
			if(lastName.length() == 0 || lastName.contains("  ") || lastName.charAt(0) == ' ')
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
	
	public void logout() {
		
		frameMain.setVisible(false);
		frameMain = null;
		utente = null;
		
		frameLogin.setMessage("Sei uscito dal programma!", true);
		frameLogin.resetTxtPassword();
		frameLogin.resetTxtUsername();
		frameLogin.hideUsernameLoginError();
		frameLogin.hidePasswordLoginError();
		frameLogin.setVisible(true);
		
	}
	
	public void uploadImgProfile() {
		
		chooser = new JFileChooser();
		chooser.setDialogTitle("Carica un'immagine nel tuo profilo!");
		chooser.setApproveButtonText("Carica");
		chooser.setAcceptAllFileFilterUsed(false);
		
		filter = new FileNameExtensionFilter("Immagini", ImageIO.getReaderFileSuffixes());
		chooser.setFileFilter(filter);
		
		chooserReturn = chooser.showOpenDialog(null);
		
		switch(chooserReturn) {
			case 0: {
				// PREMUTO TASTO APRI
				
				File imgFile = chooser.getSelectedFile();
				
				try {
					BufferedImage checkerDimension = ImageIO.read(imgFile);
					
					if(checkerDimension.getWidth() > 160 && checkerDimension.getHeight() > 160)
						throw new IOException();
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Hai caricato un'immagine troppo grande! La dimensione massima è 160x160");
					break;
				}
				
				try {
					
					FileInputStream fis = new FileInputStream(imgFile);
					utenteDAO.uploadImgProfile(con, ps, (int) imgFile.length(), fis, getUtente().getUsername());
					
					getUtente().setProfileImage(utenteDAO.loadImgProfile(con, ps, getUtente().getUsername()));
					
					frameMain.updateImgProfile(getUtente().getProfileImage());
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				break;
			}
				
			case 1: {
				// PREMUTO TASTO ANNULLA
				break;
			}
				
			default: {
				JOptionPane.showMessageDialog(null, "Errore sconosciuto durante il caricamento dell'immagine!");
				break;
			}
		}
	}
	
	public void uploadImgInsertion() {
		chooser = new JFileChooser();
		chooser.setDialogTitle("Carica un'immagine nell'inserzione!");
		chooser.setApproveButtonText("Carica");
		chooser.setAcceptAllFileFilterUsed(false);
		
		filter = new FileNameExtensionFilter("Immagini", ImageIO.getReaderFileSuffixes());
		chooser.setFileFilter(filter);
		
		chooserReturn = chooser.showOpenDialog(null);
		
		switch(chooserReturn) {
			case 0: {
				// PREMUTO TASTO APRI
				
				imgInsertionFile = chooser.getSelectedFile();
				
				try {
					insertionBimg = ImageIO.read(imgInsertionFile);
					
					if(insertionBimg.getWidth() > 180 && insertionBimg.getHeight() > 130)
						throw new IOException();
					
					frameMain.setLblInsertionImagePreview(insertionBimg);
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Hai caricato un'immagine troppo grande! La dimensione massima è 180x130");
					break;
				}
				
				break;
			}
				
			case 1: {
				// PREMUTO TASTO ANNULLA
				break;
			}
				
			default: {
				JOptionPane.showMessageDialog(null, "Errore sconosciuto durante il caricamento dell'immagine!");
				break;
			}
		}
	}

	public Utente getUtente() {
		return utente;
	}
	
	private void setRistorante(int index) {
		ristorante.setCitta(list[index].getCity());
		ristorante.setNome(list[index].getPlaceTitle());
		ristorante.setVia(list[index].getAddress());
		ristorante.setSpecialita(list[index].getPlaceCategory());
		inserzione.setTipo("Ristorante");
	}
	
	private void setAttrazione(int index) {
		attrazione.setCitta(list[index].getCity());
		attrazione.setNome(list[index].getPlaceTitle());
		attrazione.setVia(list[index].getAddress());
		attrazione.setSpecialita(list[index].getPlaceCategory());
		inserzione.setTipo("Attrazione");
	}
	
	private void setAlloggio(int index) {
		alloggio.setCitta(list[index].getCity());
		alloggio.setNome(list[index].getPlaceTitle());
		alloggio.setVia(list[index].getAddress());
		alloggio.setSpecialita(list[index].getPlaceCategory());
		inserzione.setTipo("Alloggio");
	}
	
	private void setInserzione(int index) {
		inserzione.setCodice(list[index].getCode());
		inserzione.setPoster(list[index].getPoster());
		inserzione.setImage(inserzioneDAO.loadImgInsertion(con, ps, list[index].getDbCode()));	
	}
	
	public Recensione getRecensione() {
		return recensione;
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
	
	public void setReviewIndex(int i) {
		this.reviewIndex = i;
	}
	
	public int getReviewIndex() {
		return reviewIndex;
	}
	
}
