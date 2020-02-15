package travelReviewPkg;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;

public class RigaRecensione extends JPanel {
	
	private String poster;
	private String title;
	private String message;
	private int code;
	
	private JLabel lblReviewTitle;
	private JLabel lblReviewMessage;
	
	public RigaRecensione(Controller c) {
		setLayout(null);
		
		lblReviewTitle = new JLabel();
		lblReviewTitle.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblReviewTitle.setBounds(21, 11, 656, 25);
		
		lblReviewMessage = new JLabel();
		lblReviewMessage.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		lblReviewMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblReviewMessage.setVerticalAlignment(SwingConstants.TOP);
		lblReviewMessage.setBounds(21, 47, 671, 92);
	}
	
	public void setAllTexts() {
		
		lblReviewTitle.setText("<html><b>"+title+"</b> (di: "+poster+")</hml>");
		add(lblReviewTitle);
		
		lblReviewMessage.setText("<html><body>"+message+"</body></html>");
		add(lblReviewMessage);
		
	}
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(851, 150);
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
