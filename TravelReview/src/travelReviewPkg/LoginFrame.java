package travelReviewPkg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import keeptoo.KGradientPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class LoginFrame extends JFrame {
	
	private JPanel contentPane;
	private JPanel cardLayoutPanel;
	private JLabel lblMessage;
	private JPanel loginPanel;
	private JLabel lblWelcomeTitle;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private KGradientPanel gradientMainBackground;
	private KGradientPanel gradientLoginBtn;
	private KGradientPanel messagePanel;
	private JLabel lblSignIn;
	private JLabel lblNotRegistered;
	private JLabel lblRegisterNow;
	private JLabel lblEmptyUsername;
	private JLabel lblEmptyPassword;
	private JSeparator loginSeparator;
	private JLabel lblWelcomeDescription1;
	private JLabel lblWelcomeDescription2;
	private JPanel registrationPanel;
	private JLabel lblRegistrationDescription;
	private JComboBox comboBirthDay;
	private JComboBox comboBirthMonth;
	private JComboBox comboBirthYear;
	private JLabel lblRegistrationUsername;
	private JLabel lblRegistrationPassword;
	private JLabel lblRegistrationFirstName;
	private JLabel lblRegistrationSurname;
	private JLabel lblRegistrationBirthdate;
	private JCheckBox checkboxRegistration;
	private KGradientPanel gradientRegistrationBtn;
	private JLabel lblRegisterNow_1;
	private JLabel lblLogo;
	private JLabel lblTravelReview;
	private JLabel lblTurnBackIcon;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private CardLayout cl_cardLayoutPanel;
	private Controller ctrl;
	private JTextField txtRegistrationUsername;
	private JTextField txtRegistrationFirstName;
	private JTextField txtRegistrationSurname;
	private JPasswordField txtRegistrationPassword;
	private JLabel lblDateError;
	
	private Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	private Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private int numYears = Calendar.getInstance().get(Calendar.YEAR)+1 - 1900;
	private Integer[] year = new Integer[numYears];
	private JLabel lblRegistrationMessage;
 
	public LoginFrame(Controller c) {
		setTitle("TravelReview - Read before you go");
		
		ctrl = c;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 530);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gradientMainBackground = new KGradientPanel();
		gradientMainBackground.kGradientFocus = 650;
		gradientMainBackground.kStartColor = new Color(33, 147, 176);
		gradientMainBackground.kEndColor = new Color(109, 213, 237);
		gradientMainBackground.setBounds(0, 0, 899, 493);
		contentPane.add(gradientMainBackground);
		gradientMainBackground.setLayout(null);
		
		messagePanel = new KGradientPanel();
		messagePanel.setVisible(false);
		messagePanel.kEndColor = new Color(255, 69, 0);
		messagePanel.kStartColor = new Color(204, 51, 0);
		messagePanel.setBounds(0, 0, 899, 24);
		gradientMainBackground.add(messagePanel);
		
		lblMessage = new JLabel("");
		lblMessage.setForeground(new Color(255, 255, 255));
		lblMessage.setFont(new Font("Ubuntu", Font.BOLD, 13));
		messagePanel.add(lblMessage);
		
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBounds(466, 0, 433, 493);
		gradientMainBackground.add(cardLayoutPanel);
		cardLayoutPanel.setLayout(new CardLayout(0, 0));
		cl_cardLayoutPanel = (CardLayout) cardLayoutPanel.getLayout();
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LoginFrame.class.getResource("/resources/logo_big.png")));
		lblLogo.setBounds(24, 87, 432, 375);
		gradientMainBackground.add(lblLogo);
		
		lblTravelReview = new JLabel("TravelReview");
		lblTravelReview.setForeground(new Color(255, 255, 255));
		lblTravelReview.setFont(new Font("Quicksand Medium", Font.PLAIN, 52));
		lblTravelReview.setBounds(10, 39, 361, 83);
		gradientMainBackground.add(lblTravelReview);
		
		for(int anno = Calendar.getInstance().get(Calendar.YEAR), i = 0; anno >= 1900; anno--, i++) {
			year[i] = anno;
		}
		
		displayLogin();
		
		displayRegistration();
		
		registerMouseListener(ctrl, gradientLoginBtn, gradientRegistrationBtn, lblRegisterNow, lblTurnBackIcon);
		
		registerKeyListener(ctrl, txtUsername, txtPassword);
		
		if(c.isConnected()) {
			messagePanel.setVisible(false);
		}
	}
	
	public void displayLogin() {
		
		loginPanel = new JPanel();
		cardLayoutPanel.add(loginPanel, "loginPanel_card");
		loginPanel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		loginPanel.setBackground(new Color(255, 255, 255));
		loginPanel.setLayout(null);
		
		lblWelcomeTitle = new JLabel("Benvenuto in TravelReview");
		lblWelcomeTitle.setFont(new Font("Ubuntu", Font.BOLD, 22));
		lblWelcomeTitle.setBounds(83, 23, 302, 57);
		loginPanel.add(lblWelcomeTitle);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(83, 161, 292, 31);
		loginPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(83, 233, 292, 31);
		loginPanel.add(txtPassword);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblUsername.setBounds(83, 138, 82, 13);
		loginPanel.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblPassword.setBounds(83, 210, 82, 13);
		loginPanel.add(lblPassword);
		
		gradientLoginBtn = new KGradientPanel();
		gradientLoginBtn.kStartColor = new Color(204, 51, 255);
		gradientLoginBtn.setBounds(109, 315, 228, 37);
		loginPanel.add(gradientLoginBtn);
		gradientLoginBtn.setLayout(null);
		
		lblSignIn = new JLabel("Accedi");
		lblSignIn.setForeground(new Color(255, 255, 255));
		lblSignIn.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblSignIn.setBounds(86, 10, 54, 17);
		gradientLoginBtn.add(lblSignIn);
		
		lblNotRegistered = new JLabel("Non sei registrato?");
		lblNotRegistered.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblNotRegistered.setBounds(109, 430, 237, 21);
		loginPanel.add(lblNotRegistered);
		
		lblRegisterNow = new JLabel("<html>\r\n<body>\r\n<u>Registrati ora, \u00E8 gratuito!</u>\r\n</body>\r\n</html>");
		lblRegisterNow.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblRegisterNow.setBounds(109, 448, 237, 31);
		loginPanel.add(lblRegisterNow);
		
		loginSeparator = new JSeparator();
		loginSeparator.setForeground(new Color(0, 0, 0));
		loginSeparator.setBackground(new Color(0, 0, 0));
		loginSeparator.setBounds(83, 410, 300, 10);
		loginPanel.add(loginSeparator);
		
		lblWelcomeDescription1 = new JLabel("Vai da qualche parte?");
		lblWelcomeDescription1.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblWelcomeDescription1.setBounds(143, 69, 172, 21);
		loginPanel.add(lblWelcomeDescription1);
		
		lblWelcomeDescription2 = new JLabel("Accedi ora per visualizzare migliaia di recensioni!");
		lblWelcomeDescription2.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblWelcomeDescription2.setBounds(56, 90, 363, 21);
		loginPanel.add(lblWelcomeDescription2);
		
		lblEmptyPassword = new JLabel("Campo vuoto!");
		lblEmptyPassword.setVisible(false);
		lblEmptyPassword.setForeground(Color.RED);
		lblEmptyPassword.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblEmptyPassword.setBounds(202, 211, 99, 14);
		loginPanel.add(lblEmptyPassword);
		
		lblEmptyUsername = new JLabel("Campo vuoto!");
		lblEmptyUsername.setVisible(false);
		lblEmptyUsername.setForeground(Color.RED);
		lblEmptyUsername.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblEmptyUsername.setBounds(202, 138, 99, 14);
		loginPanel.add(lblEmptyUsername);
		
	}
	
	public void displayRegistration() {
		
		registrationPanel = new JPanel();
		registrationPanel.setBackground(Color.WHITE);
		cardLayoutPanel.add(registrationPanel, "registrationPanel_card");
		registrationPanel.setLayout(null);
		
		lblRegistrationDescription = new JLabel("Registrazione in TravelReview");
		lblRegistrationDescription.setFont(new Font("Ubuntu", Font.BOLD, 22));
		lblRegistrationDescription.setBounds(63, 23, 319, 57);
		registrationPanel.add(lblRegistrationDescription);
		
		txtRegistrationUsername = new JTextField();
		txtRegistrationUsername.setBounds(63, 120, 319, 28);
		registrationPanel.add(txtRegistrationUsername);
		txtRegistrationUsername.setColumns(10);
		
		txtRegistrationFirstName = new JTextField();
		txtRegistrationFirstName.setBounds(63, 263, 140, 28);
		registrationPanel.add(txtRegistrationFirstName);
		txtRegistrationFirstName.setColumns(10);
		
		txtRegistrationSurname = new JTextField();
		txtRegistrationSurname.setBounds(238, 263, 144, 28);
		registrationPanel.add(txtRegistrationSurname);
		txtRegistrationSurname.setColumns(10);
		
		txtRegistrationPassword = new JPasswordField();
		txtRegistrationPassword.setBounds(63, 191, 319, 28);
		registrationPanel.add(txtRegistrationPassword);
		
		comboBirthDay = new JComboBox(days);
		comboBirthDay.setBounds(63, 343, 99, 28);
		registrationPanel.add(comboBirthDay);
		
		comboBirthMonth = new JComboBox(months);
		comboBirthMonth.setBounds(174, 343, 98, 28);
		registrationPanel.add(comboBirthMonth);
		
		comboBirthYear = new JComboBox(year);
		comboBirthYear.setBounds(283, 343, 99, 28);
		registrationPanel.add(comboBirthYear);
		
		lblRegistrationUsername = new JLabel("Username");
		lblRegistrationUsername.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegistrationUsername.setBounds(63, 97, 99, 21);
		registrationPanel.add(lblRegistrationUsername);
		
		lblRegistrationPassword = new JLabel("Password");
		lblRegistrationPassword.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegistrationPassword.setBounds(63, 168, 140, 21);
		registrationPanel.add(lblRegistrationPassword);
		
		lblRegistrationFirstName = new JLabel("Nome");
		lblRegistrationFirstName.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegistrationFirstName.setBounds(63, 240, 85, 21);
		registrationPanel.add(lblRegistrationFirstName);
		
		lblRegistrationSurname = new JLabel("Cognome");
		lblRegistrationSurname.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegistrationSurname.setBounds(238, 240, 99, 21);
		registrationPanel.add(lblRegistrationSurname);
		
		lblRegistrationBirthdate = new JLabel("Data di Nascita");
		lblRegistrationBirthdate.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegistrationBirthdate.setBounds(63, 320, 140, 21);
		registrationPanel.add(lblRegistrationBirthdate);
		
		checkboxRegistration = new JCheckBox("<html>\r\n<body>\r\nAccetto i <u>Termini e Condizioni</u> del servizio.\r\n</body>\r\n</html>");
		checkboxRegistration.setBackground(Color.WHITE);
		checkboxRegistration.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		checkboxRegistration.setBounds(63, 389, 330, 34);
		registrationPanel.add(checkboxRegistration);
		
		gradientRegistrationBtn = new KGradientPanel();
		gradientRegistrationBtn.kGradientFocus = 175;
		gradientRegistrationBtn.kEndColor = new Color(50, 205, 50);
		gradientRegistrationBtn.kStartColor = Color.GREEN;
		gradientRegistrationBtn.setBounds(63, 429, 319, 42);
		registrationPanel.add(gradientRegistrationBtn);
		gradientRegistrationBtn.setLayout(null);
		
		lblRegisterNow_1 = new JLabel("Registrati ora");
		lblRegisterNow_1.setBounds(111, 10, 100, 24);
		gradientRegistrationBtn.add(lblRegisterNow_1);
		lblRegisterNow_1.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblRegisterNow_1.setForeground(Color.WHITE);
		
		lblTurnBackIcon = new JLabel("");
		lblTurnBackIcon.setIcon(new ImageIcon(LoginFrame.class.getResource("/resources/turnBack_50px.png")));
		lblTurnBackIcon.setBounds(4, 7, 54, 28);
		registrationPanel.add(lblTurnBackIcon);
		
		lblDateError = new JLabel("Data non valida");
		lblDateError.setForeground(Color.RED);
		lblDateError.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblDateError.setBounds(213, 324, 111, 14);
		lblDateError.setVisible(false);
		registrationPanel.add(lblDateError);
		
		lblRegistrationMessage = new JLabel("C'\u00E8 qualche errore, ricontrolla i campi rossi!");
		lblRegistrationMessage.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblRegistrationMessage.setForeground(Color.RED);
		lblRegistrationMessage.setBounds(85, 74, 280, 14);
		lblRegistrationMessage.setVisible(false);
		registrationPanel.add(lblRegistrationMessage);
		
	}

	public void registerMouseListener(Controller ctrl, KGradientPanel gradientLoginBtn, KGradientPanel gradientRegistrationBtn, JLabel lblRegisterNow, JLabel lblTurnBackIcon) {
		
		lblRegisterNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_cardLayoutPanel.show(cardLayoutPanel, "registrationPanel_card");
				messagePanel.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblRegisterNow.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		gradientLoginBtn.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtUsername.getText().length() == 0 && txtPassword.getPassword().length == 0) {
					lblEmptyUsername.setVisible(true);
					lblEmptyPassword.setVisible(true);
				}
				else if(txtUsername.getText().length() == 0) {
					lblEmptyUsername.setVisible(true);
					lblEmptyPassword.setVisible(false);
				}
				else if(txtPassword.getPassword().length == 0) {
					lblEmptyUsername.setVisible(false);
					lblEmptyPassword.setVisible(true);
				}
				else {
					lblEmptyUsername.setVisible(false);
					lblEmptyPassword.setVisible(false);
					ctrl.verifyAccess();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				gradientLoginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		
		lblTurnBackIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblTurnBackIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_cardLayoutPanel.show(cardLayoutPanel, "loginPanel_card");
				messagePanel.setVisible(false);
				resetRegister();
			}
		});
		
		gradientRegistrationBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(ctrl.checkRegistration(getTxtRegistrationUsername(), getTxtRegistrationPassword(), getTxtRegistrationFirstName(), getTxtRegistrationSurname(), isTermsAccepted()) ) {
					ctrl.verifyRegistration();
				}
				else {
					lblRegistrationMessage.setVisible(true);
				}
			}
		});
		
	}
	
	public void registerKeyListener(Controller ctrl, JTextField txtUsername, JPasswordField txtPassword) {
		
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					if(txtUsername.getText().length() == 0 && txtPassword.getPassword().length == 0) {
						lblEmptyUsername.setVisible(true);
						lblEmptyPassword.setVisible(true);
					}
					else if(txtUsername.getText().length() == 0) {
						lblEmptyUsername.setVisible(true);
						lblEmptyPassword.setVisible(false);
					}
					else if(txtPassword.getPassword().length == 0) {
						lblEmptyUsername.setVisible(false);
						lblEmptyPassword.setVisible(true);
					}
					else {
						lblEmptyUsername.setVisible(false);
						lblEmptyPassword.setVisible(false);
						ctrl.verifyAccess();
					}
				}
			}
		});
		
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					if(txtUsername.getText().length() == 0 && txtPassword.getPassword().length == 0) {
						lblEmptyUsername.setVisible(true);
						lblEmptyPassword.setVisible(true);
					}
					else if(txtUsername.getText().length() == 0) {
						lblEmptyUsername.setVisible(true);
						lblEmptyPassword.setVisible(false);
					}
					else if(txtPassword.getPassword().length == 0) {
						lblEmptyUsername.setVisible(false);
						lblEmptyPassword.setVisible(true);
					}
					else {
						lblEmptyUsername.setVisible(false);
						lblEmptyPassword.setVisible(false);
						ctrl.verifyAccess();
					}
				}
			}	
		});
	}


	public int getComboBirthDay() {
		return (int) comboBirthDay.getSelectedItem();
	}


	public int getComboBirthMonth() {
		return (int) comboBirthMonth.getSelectedItem();
	}


	public int getComboBirthYear() {
		return (int) comboBirthYear.getSelectedItem();
	}


	public boolean getCheckboxRegistration() {
		if(checkboxRegistration.isSelected())
			return true;
		else
			return false;
	}


	public String getTxtUsername() {
		return txtUsername.getText();
	}


	public String getTxtPassword() {
		char[] temp = txtPassword.getPassword();
		String password = new String(temp);
		
		return password;
	}
	

	public String getTxtRegistrationUsername() {
		return txtRegistrationUsername.getText();
	}


	public String getTxtRegistrationFirstName() {
		return txtRegistrationFirstName.getText();
	}


	public String getTxtRegistrationSurname() {
		return txtRegistrationSurname.getText();
	}


	public String getTxtRegistrationPassword() {
		
		char[] temp = txtRegistrationPassword.getPassword();
		String password = new String(temp);
		
		return password;
	}
	
	public boolean isTermsAccepted() {
		
		if(checkboxRegistration.isSelected())
			return true;
		else
			return false;
	}


	public void resetTxtPassword() {
		this.txtPassword.setText("");;
	}
	
	public void resetTxtUsername() {
		this.txtUsername.setText("");;
	}
	
	public void resetRegister() {
		txtRegistrationFirstName.setText("");
		txtRegistrationSurname.setText("");
		txtRegistrationUsername.setText("");
		txtRegistrationPassword.setText("");
		comboBirthDay.setSelectedIndex(0);
		comboBirthMonth.setSelectedIndex(0);
		comboBirthDay.setSelectedIndex(0);
		hideDateError();
		hideFirstNameError();
		hideRegistrationMessage();
		hidePasswordError();
		hideSurnameError();
		hideTermsError();
		hideUsernameError();
	}

	public void setMessage(String text, boolean type) {
		lblMessage.setText(text);
		
		if(type) {
			messagePanel.kEndColor = new Color(0, 220, 0);
			messagePanel.kStartColor = new Color(0, 199, 0);
		}
		else {
			messagePanel.kEndColor = new Color(255, 69, 0);
			messagePanel.kStartColor = new Color(204, 51, 0);
		}
		
		messagePanel.setVisible(true);
	}
	
	public void hideMessage() {
		messagePanel.setVisible(false);
	}
	
	public void showDateError() {
		lblRegistrationMessage.setVisible(true);
		lblDateError.setVisible(true);
		lblRegistrationBirthdate.setForeground(Color.RED);
	}
	
	public void hideDateError() {
		lblRegistrationMessage.setVisible(true);
		lblDateError.setVisible(false);
		lblRegistrationBirthdate.setForeground(Color.BLACK);
	}
	
	public void showUsernameError() {
		lblRegistrationMessage.setVisible(true);
		lblRegistrationUsername.setForeground(Color.RED);
	}
	
	public void hideUsernameError() {
		lblRegistrationUsername.setForeground(Color.BLACK);
	}
	
	public void showPasswordError() {
		lblRegistrationMessage.setVisible(true);
		lblRegistrationPassword.setForeground(Color.RED);
	}
	
	public void hidePasswordError() {
		lblRegistrationPassword.setForeground(Color.BLACK);
	}
	
	public void showFirstNameError() {
		lblRegistrationMessage.setVisible(true);
		lblRegistrationFirstName.setForeground(Color.RED);
	}
	
	public void hideFirstNameError() {
		lblRegistrationFirstName.setForeground(Color.BLACK);
	}
	
	public void showSurnameError() {
		lblRegistrationMessage.setVisible(true);
		lblRegistrationSurname.setForeground(Color.RED);
	}
	
	public void hideSurnameError() {
		lblRegistrationSurname.setForeground(Color.BLACK);
	}
	
	public void showTermsError() {
		lblRegistrationMessage.setVisible(true);
		checkboxRegistration.setForeground(Color.RED);
	}
	
	public void hideTermsError() {
		checkboxRegistration.setForeground(Color.BLACK);
	}
	
	public void setRegistrationMessage(String message, boolean registrationResult) {
		lblRegistrationMessage.setText(message);
		if(registrationResult)
			lblRegistrationMessage.setForeground(Color.GREEN);
		else
			lblRegistrationMessage.setForeground(Color.RED);
		lblRegistrationMessage.setVisible(true);
	}
	
	public void hideRegistrationMessage() {
		lblRegistrationMessage.setVisible(false);
	}
	
	public void returnToLogin() {
		cl_cardLayoutPanel.show(cardLayoutPanel, "loginPanel_card");
	}
}
