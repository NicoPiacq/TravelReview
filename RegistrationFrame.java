package travelReviewPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RegistrationFrame extends JFrame {

	private JPanel contentPane;
	
	Rectangle dimension = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	int frameDimX, frameDimY;

	/**
	 * Create the frame.
	 */
	public RegistrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 930, 500);
		frameDimX = (int) ((dimension.getWidth() - getWidth()) / 2);
	    frameDimY = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(frameDimX, frameDimY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
