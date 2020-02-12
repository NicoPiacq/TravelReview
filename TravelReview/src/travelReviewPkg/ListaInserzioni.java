package travelReviewPkg;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import keeptoo.KGradientPanel;

public class ListaInserzioni extends JPanel {
	
	private JLabel lblPlaceTitle = new JLabel(getPlaceTitle());
	private JLabel lblCity = new JLabel(getCity());
	private JLabel lblAddress = new JLabel(getAddress());
	private JLabel lblPoster = new JLabel(getPoster());
	private JLabel lblOpenInsertionBtn = new JLabel("Visualizza");
	private KGradientPanel openInsertionBtn;
	
	public ListaInserzioni() {
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxLayout);
		this.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		
		openInsertionBtn.add(lblOpenInsertionBtn);
		
		this.add(lblPlaceTitle);
		this.add(lblAddress);
		this.add(lblCity);
		this.add(lblPoster);
		this.add(openInsertionBtn);
		
	}
	
	private String type;
	private Image image;
	private int code;
	private String poster;
	private String placeTitle;
	private String city;
	private String address;
	private String placeSpecialization;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getPlaceTitle() {
		return placeTitle;
	}
	public void setPlaceTitle(String placeTitle) {
		this.placeTitle = placeTitle;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlaceSpecialization() {
		return placeSpecialization;
	}
	public void setPlaceSpecialization(String placeSpecialization) {
		this.placeSpecialization = placeSpecialization;
	}

}
