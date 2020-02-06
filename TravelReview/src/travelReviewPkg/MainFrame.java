package travelReviewPkg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import keeptoo.KGradientPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	private JFileChooser chooser;
	int chooserReturn;
	private Controller ctrl;
	private boolean foodBtnIsPressed, attrBtnIsPressed, hotelBtnIsPressed;
	private JTextField txtPlaceTitle;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JPanel menuPanel;
	private JLabel lblLogo;
	private JLabel lblLogoTitle;
	private JPanel foodBtn;
	private JPanel selectFood;
	private JPanel attrBtn;
	private JPanel selectAttr;
	private JPanel hotelBtn;
	private JPanel selectHotel;
	private JPanel userPanel;
	private JLabel lblUserTitle;
	private JLabel lblUsername;
	private JPanel userPanelShadow2;
	private JLabel lblImgProfile;
	private JLabel lblNumRewTitle;
	private JLabel lblNumReviews;
	private KGradientPanel addRewBtn;
	private JLabel lblAddRewBtnTitle;
	private JPanel mainPanel;
	private CardLayout cl_cardLayoutPanel;
	private JPanel insertionListPanel;
	private JPanel reviewPanel;
	private JPanel reviewListPanel;
	private JPanel createInsertionPanel;
	private JLabel lblNewInsertionTitle;
	private JLabel lblPlaceTitle;
	private JLabel lblAddressTitle;
	private JLabel lblCityTitle;
	private JComboBox comboPlaceType;
	private JLabel lblPlaceType;
	private JLabel lblAlloggi;
	private JLabel lblHotelIcon;
	private JLabel lblAttrazioni;
	private JLabel lblAttrIcon;
	private JLabel lblRistoranti;
	private JLabel lblFoodIcon;
	private JPanel mainPanelShadow2;
	private JPanel mainPanelShadow;
	
	private String[] insertionType = {"Ristorante", "Alloggio", "Attrazione"};

	public MainFrame(Controller c) {
		
		ctrl = c;
		
		setTitle("TravelReview");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(97, 152, 232));
		menuPanel.setBounds(0, 0, 1084, 57);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/logo_small.png")));
		lblLogo.setBounds(5, 0, 65, 57);
		menuPanel.add(lblLogo);
		
		lblLogoTitle = new JLabel("TravelReview");
		lblLogoTitle.setBounds(65, 9, 217, 40);
		menuPanel.add(lblLogoTitle);
		lblLogoTitle.setForeground(Color.WHITE);
		lblLogoTitle.setFont(new Font("Quicksand Medium", Font.PLAIN, 32));
		
		foodBtn = new JPanel();
		foodBtnIsPressed = false;
		foodBtn.setBackground(new Color(97, 152, 232));
		foodBtn.setBounds(415, 0, 223, 57);
		menuPanel.add(foodBtn);
		foodBtn.setLayout(null);
		
		selectFood = new JPanel();
		selectFood.setBackground(new Color(255, 255, 255));
		selectFood.setBounds(0, 0, 5, 57);
		foodBtn.add(selectFood);
		selectFood.setVisible(false);
		
		attrBtn = new JPanel();
		attrBtnIsPressed = false;
		attrBtn.setBackground(new Color(97, 152, 232));
		attrBtn.setBounds(637, 0, 223, 57);
		menuPanel.add(attrBtn);
		attrBtn.setLayout(null);
		
		selectAttr = new JPanel();
		selectAttr.setBackground(new Color(255, 255, 255));
		selectAttr.setBounds(0, 0, 5, 57);
		attrBtn.add(selectAttr);
		selectAttr.setVisible(false);
		
		hotelBtn = new JPanel();
		hotelBtnIsPressed = false;
		hotelBtn.setBackground(new Color(97, 152, 232));
		hotelBtn.setBounds(861, 0, 223, 57);
		menuPanel.add(hotelBtn);
		hotelBtn.setLayout(null);
		
		selectHotel = new JPanel();
		selectHotel.setBackground(new Color(255, 255, 255));
		selectHotel.setBounds(0, 0, 5, 57);
		hotelBtn.add(selectHotel);
		selectHotel.setVisible(false);
		
		userPanel = new JPanel();
		userPanel.setBackground(new Color(97, 152, 232));
		userPanel.setBounds(0, 55, 223, 506);
		contentPane.add(userPanel);
		userPanel.setLayout(null);
		
		lblUserTitle = new JLabel("<html>\r\n<body>\r\n<center>Josh Kennedy</center>\r\n</body>\r\n</hml>");
		lblUserTitle.setForeground(new Color(255, 255, 255));
		lblUserTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 29));
		lblUserTitle.setBounds(31, 11, 174, 47);
		userPanel.add(lblUserTitle);
		
		lblUsername = new JLabel("JoKen");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUsername.setBounds(84, 39, 121, 47);
		userPanel.add(lblUsername);
		
		userPanelShadow2 = new JPanel();
		userPanelShadow2.setBackground(new Color(95, 10, 232, 25));
		userPanelShadow2.setBounds(0, 903, 331, 10);
		userPanel.add(userPanelShadow2);
		
		lblImgProfile = new JLabel("");
		lblImgProfile.setToolTipText("Cambia immagine del profilo");
		lblImgProfile.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/profile_nopic_ph.png")));
		lblImgProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgProfile.setBounds(31, 97, 160, 160);
		userPanel.add(lblImgProfile);
		
		lblNumRewTitle = new JLabel("Recensioni pubblicate");
		lblNumRewTitle.setForeground(new Color(255, 255, 255));
		lblNumRewTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNumRewTitle.setBounds(22, 280, 181, 58);
		userPanel.add(lblNumRewTitle);
		
		lblNumReviews = new JLabel("57");
		lblNumReviews.setFont(new Font("Segoe UI Light", Font.PLAIN, 44));
		lblNumReviews.setForeground(new Color(255, 255, 255));
		lblNumReviews.setBounds(92, 320, 67, 47);
		userPanel.add(lblNumReviews);
		
		addRewBtn = new KGradientPanel();
		addRewBtn.kEndColor = new Color(255, 215, 0);
		addRewBtn.kStartColor = Color.WHITE;
		addRewBtn.setBounds(0, 425, 224, 47);
		userPanel.add(addRewBtn);
		addRewBtn.setLayout(null);
		
		lblAddRewBtnTitle = new JLabel("Pubblica un'inserzione");
		lblAddRewBtnTitle.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblAddRewBtnTitle.setForeground(new Color(0, 0, 0));
		lblAddRewBtnTitle.setBounds(20, 11, 183, 27);
		addRewBtn.add(lblAddRewBtnTitle);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(233, 65, 851, 496);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		cl_cardLayoutPanel = (CardLayout) mainPanel.getLayout();
		
		insertionListPanel = new JPanel();
		mainPanel.add(insertionListPanel, "insertionListPanel_card");
		insertionListPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		reviewPanel = new JPanel();
		mainPanel.add(reviewPanel, "reviewPanel_card");
		reviewPanel.setLayout(null);
		
		reviewListPanel = new JPanel();
		reviewListPanel.setBounds(0, 216, 851, 280);
		reviewPanel.add(reviewListPanel);
		
		createInsertionPanel = new JPanel();
		createInsertionPanel.setBackground(Color.WHITE);
		mainPanel.add(createInsertionPanel, "createInsertionPanel_card");
		createInsertionPanel.setLayout(null);
		
		lblNewInsertionTitle = new JLabel("Crea una nuova inserzione");
		lblNewInsertionTitle.setFont(new Font("Ubuntu", Font.BOLD, 19));
		lblNewInsertionTitle.setBounds(10, 11, 239, 22);
		createInsertionPanel.add(lblNewInsertionTitle);
		
		txtPlaceTitle = new JTextField();
		txtPlaceTitle.setBounds(10, 94, 224, 20);
		createInsertionPanel.add(txtPlaceTitle);
		txtPlaceTitle.setColumns(10);
		
		lblPlaceTitle = new JLabel("Nome del luogo");
		lblPlaceTitle.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblPlaceTitle.setBounds(10, 69, 143, 14);
		createInsertionPanel.add(lblPlaceTitle);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(10, 171, 224, 20);
		createInsertionPanel.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblAddressTitle = new JLabel("Indirizzo");
		lblAddressTitle.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblAddressTitle.setBounds(10, 146, 100, 14);
		createInsertionPanel.add(lblAddressTitle);
		
		txtCity = new JTextField();
		txtCity.setBounds(10, 233, 224, 20);
		createInsertionPanel.add(txtCity);
		txtCity.setColumns(10);
		
		lblCityTitle = new JLabel("Citt\u00E0");
		lblCityTitle.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblCityTitle.setBounds(10, 208, 46, 14);
		createInsertionPanel.add(lblCityTitle);
		
		comboPlaceType = new JComboBox(insertionType);
		comboPlaceType.setBounds(10, 304, 100, 20);
		createInsertionPanel.add(comboPlaceType);
		
		lblPlaceType = new JLabel("Tipologia");
		lblPlaceType.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblPlaceType.setBounds(10, 279, 77, 14);
		createInsertionPanel.add(lblPlaceType);
		
		KGradientPanel uploadImageBtn = new KGradientPanel();
		uploadImageBtn.setkStartColor(new Color(102, 204, 153));
		uploadImageBtn.kEndColor = new Color(102, 204, 0);
		uploadImageBtn.setBounds(462, 287, 215, 37);
		createInsertionPanel.add(uploadImageBtn);
		uploadImageBtn.setLayout(null);
		
		JLabel lblUploadImage = new JLabel("Carica immagine");
		lblUploadImage.setForeground(new Color(0, 0, 0));
		lblUploadImage.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblUploadImage.setBounds(53, 5, 127, 26);
		uploadImageBtn.add(lblUploadImage);
		
		lblAlloggi = new JLabel("Alloggi");
		lblAlloggi.setForeground(Color.WHITE);
		lblAlloggi.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		lblAlloggi.setBounds(80, 12, 86, 32);
		hotelBtn.add(lblAlloggi);
		
		lblHotelIcon = new JLabel("");
		lblHotelIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/hostel_30px.png")));
		lblHotelIcon.setBounds(15, 12, 30, 30);
		hotelBtn.add(lblHotelIcon);
		
		lblAttrazioni = new JLabel("Attrazioni");
		lblAttrazioni.setForeground(Color.WHITE);
		lblAttrazioni.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		lblAttrazioni.setBounds(70, 15, 123, 25);
		attrBtn.add(lblAttrazioni);
		
		lblAttrIcon = new JLabel("");
		lblAttrIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/exhibition_30px.png")));
		lblAttrIcon.setBounds(15, 12, 30, 30);
		attrBtn.add(lblAttrIcon);
		
		lblRistoranti = new JLabel("Ristoranti");
		lblRistoranti.setBounds(60, 15, 123, 25);
		foodBtn.add(lblRistoranti);
		lblRistoranti.setForeground(new Color(255, 255, 255));
		lblRistoranti.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		
		lblFoodIcon = new JLabel("");
		lblFoodIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/food_and_wine_30px.png")));
		lblFoodIcon.setBounds(15, 12, 30, 30);
		foodBtn.add(lblFoodIcon);
		
		mainPanelShadow2 = new JPanel();
		mainPanelShadow2.setBounds(223, 65, 10, 496);
		contentPane.add(mainPanelShadow2);
		mainPanelShadow2.setBackground(new Color(79, 57, 232, 70));
		
		mainPanelShadow = new JPanel();
		mainPanelShadow.setBounds(223, 55, 861, 10);
		contentPane.add(mainPanelShadow);
		mainPanelShadow.setBackground(new Color(79, 57, 232, 70));
		
		registerMouseListener(foodBtn, attrBtn, hotelBtn, addRewBtn, selectFood, selectAttr, selectHotel, uploadImageBtn, lblImgProfile);
		
	}
	
	// Metodo che contiene tutti i Listener dei bottoni dell'UI
	public void registerMouseListener(JPanel foodBtn, JPanel attrBtn, JPanel hotelBtn, KGradientPanel addRewBtn, JPanel selectFood, JPanel selectAttr, JPanel selectHotel, JPanel uploadImageBtn, JLabel lblImgProfile) {
		
		foodBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				foodBtn.setBackground(new Color(97, 168, 232));
				selectFood.setVisible(true);
				
				attrBtn.setBackground(new Color(97, 152, 232));
				selectAttr.setVisible(false);
				
				hotelBtn.setBackground(new Color(97, 152, 232));
				selectHotel.setVisible(false);
				
				foodBtnIsPressed = true;
				attrBtnIsPressed = false;
				hotelBtnIsPressed = false;
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!foodBtnIsPressed)
					foodBtn.setBackground(new Color(97, 152, 232));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				foodBtn.setBackground(new Color(97, 168, 232));
				foodBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
		});
		
		attrBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				attrBtn.setBackground(new Color(97, 168, 232));
				selectAttr.setVisible(true);
				
				foodBtn.setBackground(new Color(97, 152, 232));
				selectFood.setVisible(false);
				
				hotelBtn.setBackground(new Color(97, 152, 232));
				selectHotel.setVisible(false);
				
				foodBtnIsPressed = false;
				attrBtnIsPressed = true;
				hotelBtnIsPressed = false;
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				attrBtn.setBackground(new Color(97, 168, 232));
				attrBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!attrBtnIsPressed)
					attrBtn.setBackground(new Color(97, 152, 232));
			}
			
		});
		
		hotelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				hotelBtn.setBackground(new Color(97, 168, 232));
				selectHotel.setVisible(true);
				
				attrBtn.setBackground(new Color(97, 152, 232));
				selectAttr.setVisible(false);
				
				foodBtn.setBackground(new Color(97, 152, 232));
				selectFood.setVisible(false);
				
				foodBtnIsPressed = false;
				attrBtnIsPressed = false;
				hotelBtnIsPressed = true;
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				hotelBtn.setBackground(new Color(97, 168, 232));
				hotelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!hotelBtnIsPressed)
					hotelBtn.setBackground(new Color(97, 152, 232));
			}
			
		});
		
		addRewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				addRewBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cl_cardLayoutPanel.show(mainPanel, "createInsertionPanel_card");
			}
		});
		
		lblImgProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.uploadImgProfile();
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblImgProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
		});
		
		uploadImageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.uploadImgInsertion();
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				uploadImageBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
	}
}
