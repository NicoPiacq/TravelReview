package travelReviewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import keeptoo.KGradientPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Controller ctrl;

	/**
	 * Create the frame.
	 */
	public MainFrame(Controller c) {
		
		ctrl = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		KGradientPanel gradientMainBg = new KGradientPanel();
		gradientMainBg.kStartColor = new Color(33, 147, 176);
		gradientMainBg.kEndColor = new Color(109, 213, 237);
		gradientMainBg.setBounds(0, 0, 1386, 768);
		contentPane.add(gradientMainBg);
		gradientMainBg.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0, 0, 0, 0));
		menuPanel.setBounds(10, 10, 1366, 57);
		gradientMainBg.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel lblTitolo = new JLabel("TravelReview");
		lblTitolo.setForeground(Color.WHITE);
		lblTitolo.setFont(new Font("Quicksand Medium", Font.PLAIN, 32));
		lblTitolo.setBounds(60, 10, 217, 40);
		menuPanel.add(lblTitolo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\logo_small.png"));
		lblLogo.setBounds(0, 0, 65, 57);
		menuPanel.add(lblLogo);
		
		JLabel lblAlloggio = new JLabel("");
		lblAlloggio.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\icon_alloggio.png"));
		lblAlloggio.setBounds(906, 0, 65, 57);
		menuPanel.add(lblAlloggio);
		
		JSeparator alloggioSeparator = new JSeparator();
		alloggioSeparator.setPreferredSize(new Dimension(alloggioSeparator.getWidth(), 11));
		alloggioSeparator.setVisible(false);
		alloggioSeparator.setBounds(906, 50, 57, 0);
		menuPanel.add(alloggioSeparator);
		
		lblAlloggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				alloggioSeparator.setVisible(true);
			}
		});
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(10, 84, 258, 658);
		gradientMainBg.add(userPanel);
		
		JPanel cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBorder(null);
		cardLayoutPanel.setBounds(268, 84, 1108, 658);
		gradientMainBg.add(cardLayoutPanel);
	}
}
