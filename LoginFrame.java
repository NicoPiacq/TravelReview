package travelReviewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	// L'oggetto "dimension" di tipo Rectangle può ottenere le dimensioni dello schermo dove viene eseguito il programma.
	Rectangle dimension = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int frameDimX, frameDimY;

	// Costruzione del Frame
	public LoginFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 930, 500);
	    frameDimX = (int) ((dimension.getWidth() - getWidth()) / 2);
	    frameDimY = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(frameDimX, frameDimY);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
