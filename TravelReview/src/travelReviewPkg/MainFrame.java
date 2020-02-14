package travelReviewPkg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import keeptoo.KGradientPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSlider;

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
	private KGradientPanel uploadImageBtn;
	private KGradientPanel addInsertionBtn;
	private KGradientPanel cancelInsertionBtn;
	private JLabel lblAdsBackground;
	private JLabel lblAddInsertion;
	private JLabel lblCancelInsertion;
	private JLabel lblUploadImage;
	private JComboBox comboPlaceSpecialization;
	private JLabel lblPlaceSpecialization;
	private String[] insertionType = {"Ristorante", "Alloggio", "Attrazione"};
	private String[] restaurantSpecializations = {"Generale", "Pizzeria", "Braceria"};
	private String[] hotelSpecializations = {"Generale", "Hotel", "Residence"};
	private String[] attractionSpecializations = {"Generale", "Museo", "Parco"};
	private JPanel welcomePanel;
	private JPanel reviewCardLayout;
	private JPanel createReviewPanel;
	private JScrollPane insertionListScrollBar;
	private JScrollPane reviewListScrollBar;
	private JLabel lblWelcomeTitle;
	private JLabel lblWelcomeTo;
	private JLabel lblWelcomeLogo;
	private JLabel lblWelcomeDescription;
	private JLabel lblAddInsertionMessage;
	private JPanel insertionInfo;
	private JLabel lblInfoPlaceTitle;
	private JLabel lblInfoWrittenBy;
	private JLabel lblInfoFullAddress;
	private JLabel lblInfoPhoto;
	
	//private RigaInserzione[] list;
	
	public MainFrame(Controller c) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(this, "Errore grave! Il software non rileva correttamente il tema di Sistema!");
		}
		
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
		
		lblUserTitle = new JLabel(ctrl.getUtente().getNome()+" "+ctrl.getUtente().getCognome());
		lblUserTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserTitle.setForeground(new Color(255, 255, 255));
		lblUserTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 21));
		lblUserTitle.setBounds(0, 11, 224, 47);
		userPanel.add(lblUserTitle);
		
		lblUsername = new JLabel(ctrl.getUtente().getUsername());
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUsername.setBounds(0, 39, 224, 47);
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
		
		lblNumReviews = new JLabel("0");
		lblNumReviews.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumReviews.setFont(new Font("Segoe UI Light", Font.PLAIN, 44));
		lblNumReviews.setForeground(new Color(255, 255, 255));
		lblNumReviews.setBounds(0, 320, 224, 47);
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
		
		welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		mainPanel.add(welcomePanel, "welcomePanel_card");
		welcomePanel.setLayout(null);
		
		lblWelcomeTitle = new JLabel("TravelReview");
		lblWelcomeTitle.setFont(new Font("Quicksand Medium", Font.PLAIN, 45));
		lblWelcomeTitle.setBounds(370, 100, 355, 57);
		welcomePanel.add(lblWelcomeTitle);
		
		lblWelcomeTo = new JLabel("Benvenuto in...");
		lblWelcomeTo.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lblWelcomeTo.setBounds(370, 78, 145, 22);
		welcomePanel.add(lblWelcomeTo);
		
		lblWelcomeLogo = new JLabel("");
		lblWelcomeLogo.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/logo_medium.png")));
		lblWelcomeLogo.setBounds(141, 24, 216, 216);
		welcomePanel.add(lblWelcomeLogo);
		
		lblWelcomeDescription = new JLabel("<html>\r\nCiao! <br>\r\nQuesta \u00E8 la <b>pagina iniziale</b>, da qui puoi scegliere se <b>pubblicare</b> una nuova inserzione oppure <b>cercare</b> delle inserzioni scegliendo una delle tre categorie principali.\r\n</html>");
		lblWelcomeDescription.setFont(new Font("Ubuntu", Font.PLAIN, 22));
		lblWelcomeDescription.setBounds(67, 238, 704, 138);
		welcomePanel.add(lblWelcomeDescription);
		
		JLabel lblWelcomeBackground = new JLabel("");
		lblWelcomeBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/welcome_background.png")));
		lblWelcomeBackground.setBounds(0, 345, 851, 151);
		welcomePanel.add(lblWelcomeBackground);
		
		insertionListPanel = new JPanel();
		insertionListPanel.setBackground(Color.WHITE);
		insertionListPanel.setLayout(null);
		
		insertionListScrollBar = new JScrollPane(insertionListPanel);
		insertionListScrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(insertionListScrollBar, "insertionListPanel_card");
		
		//////////////////////////////////////////////////////////////////////
		
		reviewPanel = new JPanel();
		mainPanel.add(reviewPanel, "reviewPanel_card");
		reviewPanel.setLayout(null);
		
		reviewCardLayout = new JPanel();
		reviewCardLayout.setLayout(new CardLayout());
		reviewCardLayout.setBounds(0, 166, 851, 330);
		reviewPanel.add(reviewCardLayout);
		
		reviewListPanel = new JPanel();
		reviewListPanel.setBackground(new Color(255, 255, 255));
		reviewListPanel.setLayout(null);
		
		createReviewPanel = new JPanel();
		createReviewPanel.setBackground(new Color(255, 255, 255));
		createReviewPanel.setLayout(null);
		
		reviewListScrollBar = new JScrollPane(reviewListPanel);
		reviewListScrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		reviewCardLayout.add(reviewListScrollBar, "reviewListPanel_card");
		reviewCardLayout.add(createReviewPanel, "createReviewPanel_card");
		
		JLabel lblTest = new JLabel("QUESTO E' IL PANEL PER CREARE UNA RECENSIONE");
		lblTest.setBounds(0, 0, 413, 14);
		createReviewPanel.add(lblTest);
		
		/////////////////////////////////////////////////////////////////////////
		
		createInsertionPanel = new JPanel();
		createInsertionPanel.setBackground(Color.WHITE);
		mainPanel.add(createInsertionPanel, "createInsertionPanel_card");
		createInsertionPanel.setLayout(null);
		
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
		
		insertionInfo = new JPanel();
		insertionInfo.setBackground(new Color(255, 255, 255));
		insertionInfo.setBounds(0, 0, 851, 155);
		reviewPanel.add(insertionInfo);
		insertionInfo.setLayout(null);
		
		displayAddInsertion();
		
		displayInsertion();
		
		registerMouseListener(foodBtn, attrBtn, hotelBtn, addRewBtn, selectFood, selectAttr, selectHotel, uploadImageBtn, lblImgProfile, addInsertionBtn, cancelInsertionBtn, comboPlaceType);
		
	}
	
	public void displayInsertion() {
		
		lblInfoPlaceTitle = new JLabel();
		lblInfoPlaceTitle.setFont(new Font("Ubuntu", Font.BOLD, 21));
		lblInfoPlaceTitle.setBounds(10, 28, 312, 25);
		insertionInfo.add(lblInfoPlaceTitle);
		
		lblInfoFullAddress = new JLabel();
		lblInfoFullAddress.setVerticalAlignment(SwingConstants.TOP);
		lblInfoFullAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfoFullAddress.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		lblInfoFullAddress.setBounds(10, 56, 312, 57);
		insertionInfo.add(lblInfoFullAddress);
		
		lblInfoWrittenBy = new JLabel();
		lblInfoWrittenBy.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		lblInfoWrittenBy.setBounds(10, 124, 187, 14);
		insertionInfo.add(lblInfoWrittenBy);
		
		lblInfoPhoto = new JLabel("");
		lblInfoPhoto.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/no_pic_default.png")));
		lblInfoPhoto.setBounds(520, 12, 180, 130);
		insertionInfo.add(lblInfoPhoto);
		
	}
	
	public void displayAddInsertion() {
		
		comboPlaceSpecialization = new JComboBox(restaurantSpecializations);
		comboPlaceSpecialization.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		comboPlaceSpecialization.setBounds(309, 338, 106, 30);
		createInsertionPanel.add(comboPlaceSpecialization);
		
		lblPlaceSpecialization = new JLabel("Specialit\u00E0");
		lblPlaceSpecialization.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblPlaceSpecialization.setBounds(308, 301, 107, 30);
		createInsertionPanel.add(lblPlaceSpecialization);
		
		lblAddInsertionMessage = new JLabel("Verifica i campi in rosso!");
		lblAddInsertionMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddInsertionMessage.setForeground(Color.RED);
		lblAddInsertionMessage.setVisible(false);
		lblAddInsertionMessage.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblAddInsertionMessage.setBounds(209, 59, 421, 14);
		createInsertionPanel.add(lblAddInsertionMessage);
		
		lblNewInsertionTitle = new JLabel("Crea una nuova inserzione");
		lblNewInsertionTitle.setFont(new Font("Ubuntu", Font.BOLD, 23));
		lblNewInsertionTitle.setBounds(280, 11, 326, 37);
		createInsertionPanel.add(lblNewInsertionTitle);
		
		txtPlaceTitle = new JTextField();
		txtPlaceTitle.setBounds(185, 121, 230, 30);
		createInsertionPanel.add(txtPlaceTitle);
		txtPlaceTitle.setColumns(10);
		
		lblPlaceTitle = new JLabel("Nome del luogo");
		lblPlaceTitle.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblPlaceTitle.setBounds(185, 88, 151, 22);
		createInsertionPanel.add(lblPlaceTitle);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(185, 188, 230, 30);
		createInsertionPanel.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblAddressTitle = new JLabel("Indirizzo");
		lblAddressTitle.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblAddressTitle.setBounds(185, 162, 116, 25);
		createInsertionPanel.add(lblAddressTitle);
		
		txtCity = new JTextField();
		txtCity.setBounds(185, 260, 230, 30);
		createInsertionPanel.add(txtCity);
		txtCity.setColumns(10);
		
		lblCityTitle = new JLabel("Citt\u00E0");
		lblCityTitle.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblCityTitle.setBounds(185, 235, 83, 20);
		createInsertionPanel.add(lblCityTitle);
		
		comboPlaceType = new JComboBox(insertionType);
		comboPlaceType.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		comboPlaceType.setBounds(185, 338, 106, 30);
		createInsertionPanel.add(comboPlaceType);
		
		lblPlaceType = new JLabel("Tipologia");
		lblPlaceType.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblPlaceType.setBounds(185, 301, 100, 30);
		createInsertionPanel.add(lblPlaceType);
		
		uploadImageBtn = new KGradientPanel();
		uploadImageBtn.setkStartColor(new Color(102, 204, 153));
		uploadImageBtn.kEndColor = new Color(102, 204, 0);
		uploadImageBtn.setBounds(542, 175, 215, 37);
		createInsertionPanel.add(uploadImageBtn);
		uploadImageBtn.setLayout(null);
		
		lblUploadImage = new JLabel("Carica immagine");
		lblUploadImage.setForeground(new Color(0, 0, 0));
		lblUploadImage.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblUploadImage.setBounds(53, 5, 127, 26);
		uploadImageBtn.add(lblUploadImage);
		
		lblAdsBackground = new JLabel("");
		lblAdsBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/new_ad_background.png")));
		lblAdsBackground.setBounds(595, 240, 256, 256);
		createInsertionPanel.add(lblAdsBackground);
		
		addInsertionBtn = new KGradientPanel();
		addInsertionBtn.kEndColor = new Color(102, 204, 0);
		addInsertionBtn.kStartColor = new Color(51, 102, 0);
		addInsertionBtn.setBounds(54, 413, 206, 37);
		createInsertionPanel.add(addInsertionBtn);
		addInsertionBtn.setLayout(null);
		
		lblAddInsertion = new JLabel("Pubblica");
		lblAddInsertion.setForeground(new Color(255, 255, 255));
		lblAddInsertion.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblAddInsertion.setBounds(68, 11, 87, 14);
		addInsertionBtn.add(lblAddInsertion);
		
		cancelInsertionBtn = new KGradientPanel();
		cancelInsertionBtn.kEndColor = new Color(255, 102, 51);
		cancelInsertionBtn.kStartColor = new Color(204, 0, 0);
		cancelInsertionBtn.setBounds(308, 413, 206, 37);
		createInsertionPanel.add(cancelInsertionBtn);
		cancelInsertionBtn.setLayout(null);
		
		lblCancelInsertion = new JLabel("Annulla");
		lblCancelInsertion.setForeground(Color.WHITE);
		lblCancelInsertion.setFont(new Font("Ubuntu", Font.BOLD, 17));
		lblCancelInsertion.setBounds(77, 11, 87, 14);
		cancelInsertionBtn.add(lblCancelInsertion);
		
	}
	
	// Metodo che contiene tutti i Listener dei bottoni dell'UI
	public void registerMouseListener(JPanel foodBtn, JPanel attrBtn, JPanel hotelBtn, KGradientPanel addRewBtn, JPanel selectFood, JPanel selectAttr, JPanel selectHotel, JPanel uploadImageBtn, JLabel lblImgProfile, KGradientPanel addInsertionBtn, KGradientPanel cancelInsertionBtn, JComboBox comboPlaceType) {
		
		comboPlaceType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch((String) comboPlaceType.getSelectedItem()) {
					case "Ristorante": {
						comboPlaceSpecialization.removeAllItems();
						comboPlaceSpecialization.addItem(restaurantSpecializations[0]);
						comboPlaceSpecialization.addItem(restaurantSpecializations[1]);
						comboPlaceSpecialization.addItem(restaurantSpecializations[2]);
						comboPlaceSpecialization.setSelectedIndex(0);
						break;
					}
					
					case "Alloggio": {
						comboPlaceSpecialization.removeAllItems();
						comboPlaceSpecialization.addItem(hotelSpecializations[0]);
						comboPlaceSpecialization.addItem(hotelSpecializations[1]);
						comboPlaceSpecialization.addItem(hotelSpecializations[2]);
						comboPlaceSpecialization.setSelectedIndex(0);
						break;
					}
					
					case "Attrazione": {
						comboPlaceSpecialization.removeAllItems();
						comboPlaceSpecialization.addItem(attractionSpecializations[0]);
						comboPlaceSpecialization.addItem(attractionSpecializations[1]);
						comboPlaceSpecialization.addItem(attractionSpecializations[2]);
						comboPlaceSpecialization.setSelectedIndex(0);
						break;
					}
				}
			}
		});
		
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
				
				buildInsertionList("ristorante");
				cl_cardLayoutPanel.show(mainPanel, "insertionListPanel_card");
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
		
		addInsertionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				addInsertionBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ctrl.checkAddInsertion(getPlaceTitle(), getCity(), getAddress()))
					ctrl.addInsertion();
			}
		});
		
		cancelInsertionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				cancelInsertionBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_cardLayoutPanel.show(mainPanel, "welcomePanel_card");
				resetAddInsertion();
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
				
				buildInsertionList("attrazione");
				cl_cardLayoutPanel.show(mainPanel, "insertionListPanel_card");
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
				
				buildInsertionList("alloggio");
				cl_cardLayoutPanel.show(mainPanel, "insertionListPanel_card");
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
				
				foodBtn.setBackground(new Color(97, 152, 232));
				selectFood.setVisible(false);
				
				attrBtn.setBackground(new Color(97, 152, 232));
				selectAttr.setVisible(false);
				
				hotelBtn.setBackground(new Color(97, 152, 232));
				selectHotel.setVisible(false);
				
				foodBtnIsPressed = false;
				attrBtnIsPressed = false;
				hotelBtnIsPressed = false;
				
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
	
	private void buildInsertionList(String placeType) {
		
		insertionListPanel.removeAll();
		
		int numberOfInsertions = ctrl.getNumberOfInsertionsByType(placeType);
		
		RigaInserzione[] list;
		list = ctrl.buildList(numberOfInsertions, placeType);
		
		insertionListPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);
		
		for(int i = 0; i < numberOfInsertions; i++) {
			insertionListPanel.add(list[i], gbc);
			gbc.gridy += 1;
		}
		
		insertionListPanel.revalidate();
		insertionListPanel.repaint();
	}
	
	public void buildReviewList(int code) {
		
		reviewListPanel.removeAll();
		
		int numberOfReviews = ctrl.getNumberOfReviewByCode(code);	
		
		RigaRecensione[] list;
		list = ctrl.buildReviewList(numberOfReviews, code);
		
		reviewListPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		
		for(int i = 0; i < numberOfReviews; i++) {
			reviewListPanel.add(list[i], gbc);
			gbc.gridy += 1;
		}
		
		reviewListPanel.revalidate();
		reviewListPanel.repaint();
	}
	
	public void showInsertionPage(String type) {
		
		switch(type) {
			case "Ristorante": {
				lblInfoPlaceTitle.setText(ctrl.getRistorante().getNome());
				lblInfoWrittenBy.setText("<html>Pubblicato da: <b>"+ctrl.getInserzione().getPoster()+"</b></html>");
				lblInfoFullAddress.setText("<html>Si trova a: "+ctrl.getRistorante().getVia()+", "+ctrl.getRistorante().getCitta());
				break;
			}
			case "Alloggio": {
				lblInfoPlaceTitle.setText(ctrl.getAlloggio().getNome());
				lblInfoWrittenBy.setText("<html>Pubblicato da: <b>"+ctrl.getInserzione().getPoster()+"</b></html>");
				lblInfoFullAddress.setText("<html>Si trova a: "+ctrl.getAlloggio().getVia()+", "+ctrl.getAlloggio().getCitta());
				break;
			}
			case "Attrazione": {
				lblInfoPlaceTitle.setText(ctrl.getAttrazione().getNome());
				lblInfoWrittenBy.setText("<html>Pubblicato da: <b>"+ctrl.getInserzione().getPoster()+"</b></html>");
				lblInfoFullAddress.setText("<html>Si trova a: "+ctrl.getAttrazione().getVia()+", "+ctrl.getAttrazione().getCitta());
				break;
			}
		}
		
		cl_cardLayoutPanel.show(mainPanel, "reviewPanel_card");
	}

	public void resetAddInsertion() {
		txtPlaceTitle.setText("");
		txtCity.setText("");
		txtAddress.setText("");
		setAddInsertionMessage("Verifica i campi in rosso!", false);
		hideAddInsertionMessage();
		hidePlaceTitleError();
		hideCityError();
		hideAddressError();
		comboPlaceType.setSelectedIndex(0);
	}

	public String getPlaceTitle() {
		return txtPlaceTitle.getText();
	}
	
	public String getCity() {
		return txtCity.getText();
	}
	
	public String getAddress() {
		return txtAddress.getText();
	}
	
	public String getPlaceType() {
		return (String) comboPlaceType.getSelectedItem();
	}
	
	public String getPlaceSpecialization() {
		return (String) comboPlaceSpecialization.getSelectedItem();
	}
	
	public void showPlaceTitleError() {
		lblPlaceTitle.setForeground(Color.RED);
	}
	
	public void hidePlaceTitleError() {
		lblPlaceTitle.setForeground(Color.BLACK);
	}
	
	public void showCityError() {
		lblCityTitle.setForeground(Color.RED);
	}
	
	public void hideCityError() {
		lblCityTitle.setForeground(Color.BLACK);
	}
	
	public void showAddressError() {
		lblAddressTitle.setForeground(Color.RED);
	}
	
	public void hideAddressError() {
		lblAddressTitle.setForeground(Color.BLACK);
	}
	
	public void showAddInsertionMessage() {
		lblAddInsertionMessage.setVisible(true);
	}
	
	public void hideAddInsertionMessage() {
		lblAddInsertionMessage.setVisible(false);
	}
	
	public void setAddInsertionMessage(String text, boolean state) {
		lblAddInsertionMessage.setText(text);
		
		if(state) {
			lblAddInsertionMessage.setForeground(Color.GREEN);
		}
		else {
			lblAddInsertionMessage.setForeground(Color.RED);
		}
	}
}