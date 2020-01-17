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
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = -1361424214147021740L;
	
	
	private JPanel contentPane;
	private JPanel cardLayoutPanel;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private CardLayout cl_cardLayoutPanel;
	private Controller ctrl;
	private JTextField txtRegUsername;
	private JTextField txtRegName;
	private JTextField txtRegSurname;
	private JPasswordField pswReg;

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
		
		KGradientPanel gradientMainBg = new KGradientPanel();
		gradientMainBg.kGradientFocus = 650;
		gradientMainBg.kStartColor = new Color(33, 147, 176);
		gradientMainBg.kEndColor = new Color(109, 213, 237);
		gradientMainBg.setBounds(0, 0, 899, 493);
		contentPane.add(gradientMainBg);
		gradientMainBg.setLayout(null);
		KGradientPanel errorPanel = new KGradientPanel();
		
		errorPanel.kEndColor = new Color(255, 69, 0);
		errorPanel.kStartColor = new Color(204, 51, 0);
		errorPanel.setBounds(0, 0, 899, 24);
		gradientMainBg.add(errorPanel);
		
		JLabel lblErrorMsg = new JLabel("Connessione al Database assente! Per riprovare, riavvia il software.");
		lblErrorMsg.setForeground(new Color(255, 255, 255));
		lblErrorMsg.setFont(new Font("Ubuntu", Font.BOLD, 13));
		errorPanel.add(lblErrorMsg);
		
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBounds(466, 0, 450, 530);
		gradientMainBg.add(cardLayoutPanel);
		cardLayoutPanel.setLayout(new CardLayout(0, 0));
		cl_cardLayoutPanel = (CardLayout) cardLayoutPanel.getLayout();
		
		JPanel loginPanel = new JPanel();
		cardLayoutPanel.add(loginPanel, "loginPanel_name");
		loginPanel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		loginPanel.setBackground(new Color(255, 255, 255));
		loginPanel.setLayout(null);
		
		JLabel lblBenvenutoInTravelreview = new JLabel("Benvenuto in TravelReview");
		lblBenvenutoInTravelreview.setFont(new Font("Ubuntu", Font.BOLD, 22));
		lblBenvenutoInTravelreview.setBounds(83, 23, 302, 57);
		loginPanel.add(lblBenvenutoInTravelreview);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(83, 161, 292, 31);
		loginPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(83, 233, 292, 31);
		loginPanel.add(txtPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblUsername.setBounds(83, 138, 82, 13);
		loginPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblPassword.setBounds(83, 210, 82, 13);
		loginPanel.add(lblPassword);
		
		KGradientPanel gradientLoginBtn = new KGradientPanel();
		gradientLoginBtn.kStartColor = new Color(204, 51, 255);
		gradientLoginBtn.setBounds(108, 341, 228, 37);
		loginPanel.add(gradientLoginBtn);
		gradientLoginBtn.setLayout(null);
		
		JLabel lblAccedi = new JLabel("Accedi");
		lblAccedi.setForeground(new Color(255, 255, 255));
		lblAccedi.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblAccedi.setBounds(86, 10, 54, 17);
		gradientLoginBtn.add(lblAccedi);
		
		JLabel lblNonSeiRegistrato = new JLabel("Non sei registrato?");
		lblNonSeiRegistrato.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblNonSeiRegistrato.setBounds(109, 430, 237, 21);
		loginPanel.add(lblNonSeiRegistrato);
		
		JLabel lblRegistratiOra = new JLabel("<html>\r\n<body>\r\n<u>Registrati ora, \u00E8 gratuito!</u>\r\n</body>\r\n</html>");
		lblRegistratiOra.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblRegistratiOra.setBounds(109, 448, 237, 31);
		loginPanel.add(lblRegistratiOra);
		
		JSeparator loginSeparator = new JSeparator();
		loginSeparator.setForeground(new Color(0, 0, 0));
		loginSeparator.setBackground(new Color(0, 0, 0));
		loginSeparator.setBounds(83, 410, 300, 10);
		loginPanel.add(loginSeparator);
		
		JCheckBox chckbxMantieniLaSessione = new JCheckBox("Mantieni la sessione");
		chckbxMantieniLaSessione.setBackground(new Color(255, 255, 255));
		chckbxMantieniLaSessione.setFont(new Font("Ubuntu", Font.BOLD, 16));
		chckbxMantieniLaSessione.setBounds(131, 313, 179, 21);
		loginPanel.add(chckbxMantieniLaSessione);
		
		JLabel lblVaiDaQualche = new JLabel("Vai da qualche parte?");
		lblVaiDaQualche.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblVaiDaQualche.setBounds(143, 69, 172, 21);
		loginPanel.add(lblVaiDaQualche);
		
		JLabel lblAccediOraPer = new JLabel("Accedi ora per visualizzare migliaia di recensioni!");
		lblAccediOraPer.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblAccediOraPer.setBounds(56, 90, 363, 21);
		loginPanel.add(lblAccediOraPer);
		
		JPanel registrationPanel = new JPanel();
		registrationPanel.setBackground(Color.WHITE);
		cardLayoutPanel.add(registrationPanel, "registrationPanel_name");
		registrationPanel.setLayout(null);
		
		JLabel lblRegistrazioneInTravelreview = new JLabel("Registrazione in TravelReview");
		lblRegistrazioneInTravelreview.setFont(new Font("Ubuntu", Font.BOLD, 22));
		lblRegistrazioneInTravelreview.setBounds(74, 23, 319, 57);
		registrationPanel.add(lblRegistrazioneInTravelreview);
		
		txtRegUsername = new JTextField();
		txtRegUsername.setBounds(74, 126, 319, 28);
		registrationPanel.add(txtRegUsername);
		txtRegUsername.setColumns(10);
		
		txtRegName = new JTextField();
		txtRegName.setBounds(74, 269, 140, 28);
		registrationPanel.add(txtRegName);
		txtRegName.setColumns(10);
		
		txtRegSurname = new JTextField();
		txtRegSurname.setBounds(249, 269, 144, 28);
		registrationPanel.add(txtRegSurname);
		txtRegSurname.setColumns(10);
		
		pswReg = new JPasswordField();
		pswReg.setBounds(74, 197, 319, 28);
		registrationPanel.add(pswReg);
		
		JComboBox comboBirthDay = new JComboBox();
		comboBirthDay.setBounds(74, 349, 99, 28);
		registrationPanel.add(comboBirthDay);
		
		JComboBox comboBirthMonth = new JComboBox();
		comboBirthMonth.setBounds(185, 349, 98, 28);
		registrationPanel.add(comboBirthMonth);
		
		JComboBox comboBirthYear = new JComboBox();
		comboBirthYear.setBounds(294, 349, 99, 28);
		registrationPanel.add(comboBirthYear);
		
		JLabel lblRegUsername = new JLabel("Username");
		lblRegUsername.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegUsername.setBounds(74, 103, 99, 21);
		registrationPanel.add(lblRegUsername);
		
		JLabel lblRegPsw = new JLabel("Password");
		lblRegPsw.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegPsw.setBounds(74, 174, 140, 21);
		registrationPanel.add(lblRegPsw);
		
		JLabel lblRegName = new JLabel("Nome");
		lblRegName.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegName.setBounds(74, 246, 85, 21);
		registrationPanel.add(lblRegName);
		
		JLabel lblRegCognome = new JLabel("Cognome");
		lblRegCognome.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegCognome.setBounds(249, 246, 99, 21);
		registrationPanel.add(lblRegCognome);
		
		JLabel lblRegBirthdate = new JLabel("Data di Nascita");
		lblRegBirthdate.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblRegBirthdate.setBounds(74, 326, 140, 21);
		registrationPanel.add(lblRegBirthdate);
		
		JCheckBox chkboxRegTerms = new JCheckBox("<html>\r\n<body>\r\nAccetto i <u>Termini e Condizioni</u> del servizio.\r\n</body>\r\n</html>");
		chkboxRegTerms.setBackground(Color.WHITE);
		chkboxRegTerms.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		chkboxRegTerms.setBounds(74, 395, 330, 34);
		registrationPanel.add(chkboxRegTerms);
		
		KGradientPanel gradientRegBtn = new KGradientPanel();
		gradientRegBtn.kGradientFocus = 175;
		gradientRegBtn.kEndColor = new Color(50, 205, 50);
		gradientRegBtn.kStartColor = Color.GREEN;
		gradientRegBtn.setBounds(74, 435, 319, 42);
		registrationPanel.add(gradientRegBtn);
		gradientRegBtn.setLayout(null);
		
		JLabel lblRegistratiOra_1 = new JLabel("Registrati ora");
		lblRegistratiOra_1.setBounds(111, 10, 100, 24);
		gradientRegBtn.add(lblRegistratiOra_1);
		lblRegistratiOra_1.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblRegistratiOra_1.setForeground(Color.WHITE);
		
		JLabel lblWorldplanelogo = new JLabel("");
		lblWorldplanelogo.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TestModernUI\\resources\\travelreview_logo_big.png"));
		lblWorldplanelogo.setBounds(24, 87, 432, 375);
		gradientMainBg.add(lblWorldplanelogo);
		
		JLabel lblTravelreview = new JLabel("TravelReview");
		lblTravelreview.setForeground(new Color(255, 255, 255));
		lblTravelreview.setFont(new Font("Quicksand Medium", Font.PLAIN, 52));
		lblTravelreview.setBounds(10, 39, 361, 83);
		gradientMainBg.add(lblTravelreview);
		
		registerMouseListener(ctrl, gradientLoginBtn, gradientRegBtn, lblRegistratiOra);
		
		if(c.isConnected()) {
			errorPanel.setVisible(false);
		}
	}
	
	
	public void registerMouseListener(Controller ctrl, KGradientPanel gradientLoginBtn, KGradientPanel gradientRegBtn, JLabel lblRegistratiOra) {
		
		lblRegistratiOra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_cardLayoutPanel.show(cardLayoutPanel, "registrationPanel_name");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblRegistratiOra.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		
		
	}
}
