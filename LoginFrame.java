package travelReviewPkg;

import java.awt.EventQueue;
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

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = -1361424214147021740L;
	
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private CardLayout CL;

	/**
	 * Costruzione del frame
	 */
	public LoginFrame() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 913, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		KGradientPanel homeGradientPanel = new KGradientPanel();
		homeGradientPanel.kGradientFocus = 650;
		homeGradientPanel.kStartColor = new Color(33, 147, 176);
		homeGradientPanel.kEndColor = new Color(109, 213, 237);
		homeGradientPanel.setBounds(0, 0, 916, 530);
		contentPane.add(homeGradientPanel);
		homeGradientPanel.setLayout(null);
		
		JPanel transformPanel = new JPanel();
		transformPanel.setBounds(466, 0, 450, 530);
		homeGradientPanel.add(transformPanel);
		transformPanel.setLayout(new CardLayout(0, 0));
		CL = (CardLayout) transformPanel.getLayout();
		
		JPanel loginPanel = new JPanel();
		transformPanel.add(loginPanel, "loginPanel_name");
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
		
		KGradientPanel gradientPanel_1 = new KGradientPanel();
		gradientPanel_1.kStartColor = new Color(204, 51, 255);
		gradientPanel_1.setBounds(108, 341, 228, 37);
		loginPanel.add(gradientPanel_1);
		gradientPanel_1.setLayout(null);
		
		JLabel lblAccedi = new JLabel("Accedi");
		lblAccedi.setForeground(new Color(255, 255, 255));
		lblAccedi.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblAccedi.setBounds(86, 10, 54, 17);
		gradientPanel_1.add(lblAccedi);
		
		JLabel lblNonSeiRegistrato = new JLabel("Non sei registrato?");
		lblNonSeiRegistrato.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblNonSeiRegistrato.setBounds(108, 446, 237, 21);
		loginPanel.add(lblNonSeiRegistrato);
		
		JLabel lblRegistratiOra = new JLabel("Registrati ora, \u00E8 gratuito!");
		lblRegistratiOra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CL.show(transformPanel, "registrationPanel_name");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblRegistratiOra.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblRegistratiOra.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblRegistratiOra.setBounds(108, 465, 237, 31);
		loginPanel.add(lblRegistratiOra);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(83, 420, 300, 10);
		loginPanel.add(separator);
		
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
		
		JLabel logCloseProgramBtn = new JLabel("X");
		logCloseProgramBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				logCloseProgramBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		logCloseProgramBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		logCloseProgramBtn.setBounds(426, 10, 14, 21);
		loginPanel.add(logCloseProgramBtn);
		
		JPanel registrationPanel = new JPanel();
		registrationPanel.setBackground(Color.WHITE);
		transformPanel.add(registrationPanel, "registrationPanel_name");
		registrationPanel.setLayout(null);
		
		JLabel regCloseProgramBtn = new JLabel("X");
		regCloseProgramBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				regCloseProgramBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		regCloseProgramBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		regCloseProgramBtn.setBounds(426, 10, 14, 21);
		registrationPanel.add(regCloseProgramBtn);
		
		JLabel lblRegistrazioneInTravelreview = new JLabel("Registrazione in TravelReview");
		lblRegistrazioneInTravelreview.setFont(new Font("Ubuntu", Font.BOLD, 22));
		lblRegistrazioneInTravelreview.setBounds(76, 23, 319, 57);
		registrationPanel.add(lblRegistrazioneInTravelreview);
		
		JLabel lblWorldplanelogo = new JLabel("");
		lblWorldplanelogo.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TestModernUI\\resources\\travelreview_logo_big.png"));
		lblWorldplanelogo.setBounds(24, 87, 432, 375);
		homeGradientPanel.add(lblWorldplanelogo);
		
		JLabel lblTravelreview = new JLabel("TravelReview");
		lblTravelreview.setForeground(new Color(255, 255, 255));
		lblTravelreview.setFont(new Font("Quicksand Medium", Font.PLAIN, 52));
		lblTravelreview.setBounds(10, 39, 361, 83);
		homeGradientPanel.add(lblTravelreview);
	}
}
