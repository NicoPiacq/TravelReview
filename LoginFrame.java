package travelReviewPkg;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	// L'oggetto "dimension" di tipo Rectangle può ottenere le dimensioni dello schermo dove viene eseguito il programma.
	Rectangle dimension = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int frameDimX, frameDimY;
    private JTextField textField;
    private JTextField textField_1;

	// Costruzione del Frame
	public LoginFrame() {
		setTitle("TravelReview");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 930, 500);
	    frameDimX = (int) ((dimension.getWidth() - getWidth()) / 2);
	    frameDimY = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(frameDimX, frameDimY);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(SystemColor.menu);
		loginPanel.setBounds(482, 68, 395, 315);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(161, 90, 197, 23);
		loginPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(49, 88, 82, 23);
		loginPanel.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 146, 197, 23);
		loginPanel.add(textField_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(49, 146, 82, 23);
		loginPanel.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(102, 213, 191, 47);
		loginPanel.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon("J:\\Personal Category\\Documenti vari\\Eclipse WorkSpace\\TravelReview\\resources\\Logo.png"));
		lblNewLabel.setBounds(10, 159, 480, 137);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistratiOra = new JButton("REGISTRATI ORA");
		btnRegistratiOra.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistratiOra.setBounds(544, 395, 272, 47);
		contentPane.add(btnRegistratiOra);
	}
}
