package travelReviewPkg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import keeptoo.KGradientPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	private Controller ctrl;
	private boolean foodBtnIsPressed, attrBtnIsPressed, hotelBtnIsPressed;

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
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(97, 152, 232));
		menuPanel.setBounds(0, 0, 1084, 57);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\logo_small.png"));
		lblLogo.setBounds(5, 0, 65, 57);
		menuPanel.add(lblLogo);
		
		JLabel lblLogoTitle = new JLabel("TravelReview");
		lblLogoTitle.setBounds(65, 9, 217, 40);
		menuPanel.add(lblLogoTitle);
		lblLogoTitle.setForeground(Color.WHITE);
		lblLogoTitle.setFont(new Font("Quicksand Medium", Font.PLAIN, 32));
		
		JPanel foodBtn = new JPanel();
		foodBtnIsPressed = false;
		foodBtn.setBackground(new Color(97, 152, 232));
		foodBtn.setBounds(415, 0, 223, 57);
		menuPanel.add(foodBtn);
		foodBtn.setLayout(null);
		
		JPanel selectFood = new JPanel();
		selectFood.setBackground(new Color(255, 255, 255));
		selectFood.setBounds(0, 0, 5, 57);
		foodBtn.add(selectFood);
		selectFood.setVisible(false);
		
		JPanel attrBtn = new JPanel();
		attrBtnIsPressed = false;
		attrBtn.setBackground(new Color(97, 152, 232));
		attrBtn.setBounds(637, 0, 223, 57);
		menuPanel.add(attrBtn);
		attrBtn.setLayout(null);
		
		JPanel selectAttr = new JPanel();
		selectAttr.setBackground(new Color(255, 255, 255));
		selectAttr.setBounds(0, 0, 5, 57);
		attrBtn.add(selectAttr);
		selectAttr.setVisible(false);
		
		JPanel hotelBtn = new JPanel();
		hotelBtnIsPressed = false;
		hotelBtn.setBackground(new Color(97, 152, 232));
		hotelBtn.setBounds(861, 0, 223, 57);
		menuPanel.add(hotelBtn);
		hotelBtn.setLayout(null);
		
		JPanel selectHotel = new JPanel();
		selectHotel.setBackground(new Color(255, 255, 255));
		selectHotel.setBounds(0, 0, 5, 57);
		hotelBtn.add(selectHotel);
		selectHotel.setVisible(false);
		
		JPanel userPanel = new JPanel();
		userPanel.setBackground(new Color(97, 152, 232));
		userPanel.setBounds(0, 55, 223, 506);
		contentPane.add(userPanel);
		userPanel.setLayout(null);
		
		JLabel lblUserTitle = new JLabel("<html>\r\n<body>\r\n<center>Josh Kennedy</center>\r\n</body>\r\n</hml>");
		lblUserTitle.setForeground(new Color(255, 255, 255));
		lblUserTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 29));
		lblUserTitle.setBounds(41, 11, 174, 47);
		userPanel.add(lblUserTitle);
		
		JLabel lblUsername = new JLabel("JoKen");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUsername.setBounds(94, 39, 121, 47);
		userPanel.add(lblUsername);
		
		JPanel userPanelShadow2 = new JPanel();
		userPanelShadow2.setBackground(new Color(95, 10, 232, 25));
		userPanelShadow2.setBounds(0, 903, 331, 10);
		userPanel.add(userPanelShadow2);
		
		JLabel lblImgProfile = new JLabel("");
		lblImgProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgProfile.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\profile_nopic_ph.png"));
		lblImgProfile.setBounds(31, 97, 160, 160);
		userPanel.add(lblImgProfile);
		
		JLabel lblNumRewTitle = new JLabel("Recensioni pubblicate");
		lblNumRewTitle.setForeground(new Color(255, 255, 255));
		lblNumRewTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNumRewTitle.setBounds(22, 280, 181, 58);
		userPanel.add(lblNumRewTitle);
		
		JLabel lblNumReviews = new JLabel("57");
		lblNumReviews.setFont(new Font("Segoe UI Light", Font.PLAIN, 44));
		lblNumReviews.setForeground(new Color(255, 255, 255));
		lblNumReviews.setBounds(92, 320, 67, 47);
		userPanel.add(lblNumReviews);
		
		KGradientPanel AddRewBtn = new KGradientPanel();
		AddRewBtn.kEndColor = new Color(255, 215, 0);
		AddRewBtn.kStartColor = Color.WHITE;
		AddRewBtn.setBounds(0, 425, 224, 47);
		userPanel.add(AddRewBtn);
		AddRewBtn.setLayout(null);
		
		JLabel lblAddRewBtnTitle = new JLabel("Pubblica un'inserzione");
		lblAddRewBtnTitle.setFont(new Font("Ubuntu", Font.BOLD, 18));
		lblAddRewBtnTitle.setForeground(new Color(0, 0, 0));
		lblAddRewBtnTitle.setBounds(16, 11, 195, 27);
		AddRewBtn.add(lblAddRewBtnTitle);
		
		JLabel lblAddRewBtnIcon = new JLabel("");
		lblAddRewBtnIcon.setIcon(new ImageIcon("C:\\Users\\Nicola\\Desktop\\edit_26px.png"));
		lblAddRewBtnIcon.setBounds(28, 5, 26, 33);
		AddRewBtn.add(lblAddRewBtnIcon);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(233, 65, 851, 496);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblOops = new JLabel("Oops!");
		lblOops.setFont(new Font("Segoe UI Light", Font.PLAIN, 43));
		lblOops.setBounds(237, 245, 117, 58);
		mainPanel.add(lblOops);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n<body>\r\nSembra esserci un errore... <br>\r\nProva a riavviare il software.\r\n</body>\r\n</html>");
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 27));
		lblNewLabel.setBounds(237, 316, 467, 74);
		mainPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(":(");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 82));
		lblNewLabel_1.setBounds(237, 72, 57, 160);
		mainPanel.add(lblNewLabel_1);
		
		registerMouseListener(foodBtn, attrBtn, hotelBtn, AddRewBtn, selectFood, selectAttr, selectHotel);
		
		JLabel lblAlloggi = new JLabel("Alloggi");
		lblAlloggi.setForeground(Color.WHITE);
		lblAlloggi.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		lblAlloggi.setBounds(80, 12, 86, 32);
		hotelBtn.add(lblAlloggi);
		
		JLabel lblHotelIcon = new JLabel("");
		lblHotelIcon.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\hostel_30px.png"));
		lblHotelIcon.setBounds(15, 12, 30, 30);
		hotelBtn.add(lblHotelIcon);
		
		JLabel lblAttrazioni = new JLabel("Attrazioni");
		lblAttrazioni.setForeground(Color.WHITE);
		lblAttrazioni.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		lblAttrazioni.setBounds(70, 15, 123, 25);
		attrBtn.add(lblAttrazioni);
		
		JLabel lblAttrIcon = new JLabel("");
		lblAttrIcon.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\exhibition_30px.png"));
		lblAttrIcon.setBounds(15, 12, 30, 30);
		attrBtn.add(lblAttrIcon);
		
		JLabel lblRistoranti = new JLabel("Ristoranti");
		lblRistoranti.setBounds(60, 15, 123, 25);
		foodBtn.add(lblRistoranti);
		lblRistoranti.setForeground(new Color(255, 255, 255));
		lblRistoranti.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		
		JLabel lblFoodIcon = new JLabel("");
		lblFoodIcon.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\food_and_wine_30px.png"));
		lblFoodIcon.setBounds(15, 12, 30, 30);
		foodBtn.add(lblFoodIcon);
		
		JPanel mainPanelShadow2 = new JPanel();
		mainPanelShadow2.setBounds(223, 65, 10, 496);
		contentPane.add(mainPanelShadow2);
		mainPanelShadow2.setBackground(new Color(79, 57, 232, 70));
		
		JPanel mainPanelShadow = new JPanel();
		mainPanelShadow.setBounds(223, 55, 861, 10);
		contentPane.add(mainPanelShadow);
		mainPanelShadow.setBackground(new Color(79, 57, 232, 70));
		
	}
	
	
	// Metodo che contiene tutti i Listener dei bottoni dell'UI
	public void registerMouseListener(JPanel ristorantiBtn, JPanel attrazioneBtn, JPanel hotelBtn, KGradientPanel addRewBtn, JPanel selectFood, JPanel selectAttr, JPanel selectHotel) {
		
		ristorantiBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ristorantiBtn.setBackground(new Color(97, 168, 232));
				selectFood.setVisible(true);
				
				attrazioneBtn.setBackground(new Color(97, 152, 232));
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
					ristorantiBtn.setBackground(new Color(97, 152, 232));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ristorantiBtn.setBackground(new Color(97, 168, 232));
			}
			
		});
		
		attrazioneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				attrazioneBtn.setBackground(new Color(97, 168, 232));
				selectAttr.setVisible(true);
				
				ristorantiBtn.setBackground(new Color(97, 152, 232));
				selectFood.setVisible(false);
				
				hotelBtn.setBackground(new Color(97, 152, 232));
				selectHotel.setVisible(false);
				
				foodBtnIsPressed = false;
				attrBtnIsPressed = true;
				hotelBtnIsPressed = false;
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				attrazioneBtn.setBackground(new Color(97, 168, 232));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!attrBtnIsPressed)
					attrazioneBtn.setBackground(new Color(97, 152, 232));
			}
			
		});
		
		hotelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				hotelBtn.setBackground(new Color(97, 168, 232));
				selectHotel.setVisible(true);
				
				attrazioneBtn.setBackground(new Color(97, 152, 232));
				selectAttr.setVisible(false);
				
				ristorantiBtn.setBackground(new Color(97, 152, 232));
				selectFood.setVisible(false);
				
				foodBtnIsPressed = false;
				attrBtnIsPressed = false;
				hotelBtnIsPressed = true;
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				hotelBtn.setBackground(new Color(97, 168, 232));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!hotelBtnIsPressed)
					hotelBtn.setBackground(new Color(97, 152, 232));
			}
			
		});
		
	}
}
