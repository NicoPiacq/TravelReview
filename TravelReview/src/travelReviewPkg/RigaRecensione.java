package travelReviewPkg;

import java.awt.Dimension;

import javax.swing.JPanel;

public class RigaRecensione extends JPanel {
	
	private String poster;
	private String title;
	private String message;
	
	public RigaRecensione(Controller c) {
		
	}
	
	public void setAllTexts() {
		
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

}
