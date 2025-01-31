package travelReviewPkg;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import keeptoo.KGradientPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RigaInserzione extends JPanel {
	
	private String type;
	private Image image;
	private int code;
	private int dbCode;
	private String poster;
	private String placeTitle;
	private String city;
	private String address;
	private String placeCategory;
	private BufferedImage insertionImage;

	private Controller ctrl;
	
	private JLabel lblPlaceTitle = new JLabel();
	private JLabel lblPlaceType;
	private JLabel lblFullAddress;
	private JLabel lblWrittenBy;
	private JLabel lblOpenInsertionBtn;
	private KGradientPanel openInsertionBtn;
	
	
	public RigaInserzione(Controller c) {
		
		setLayout(null);
		
		ctrl = c;
		
		openInsertionBtn = new KGradientPanel();
		openInsertionBtn.kStartColor = new Color(0, 153, 0);
		openInsertionBtn.setkEndColor(new Color(102, 204, 0));
		openInsertionBtn.setBounds(661, 30, 180, 33);
		add(openInsertionBtn);
		openInsertionBtn.setLayout(null);
		
		lblOpenInsertionBtn = new JLabel("Visualizza");
		lblOpenInsertionBtn.setForeground(new Color(255, 255, 255));
		lblOpenInsertionBtn.setFont(new Font("Ubuntu", Font.BOLD, 15));
		lblOpenInsertionBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenInsertionBtn.setBounds(0, 0, 180, 33);
		openInsertionBtn.add(lblOpenInsertionBtn);
		
	}
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(851, 100);
	}
	
	public void setAllTexts() {
		
		lblPlaceTitle = new JLabel(placeTitle);
		lblPlaceTitle.setFont(new Font("Ubuntu", Font.BOLD, 18));
		lblPlaceTitle.setBounds(10, 30, 207, 21);
		this.add(lblPlaceTitle);
		
		lblPlaceType = new JLabel(type+" - "+placeCategory);
		lblPlaceType.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		lblPlaceType.setBounds(10, 49, 143, 18);
		this.add(lblPlaceType);
		
		lblFullAddress = new JLabel(address+", "+city);
		lblFullAddress.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		lblFullAddress.setBounds(10, 75, 300, 14);
		this.add(lblFullAddress);
		
		lblWrittenBy = new JLabel("<html>Pubblicato da: <b>"+poster+"</b></html>");
		lblWrittenBy.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblWrittenBy.setBounds(661, 74, 180, 14);
		this.add(lblWrittenBy);
		
		registerMouseListener(openInsertionBtn);
	}
	
	public void registerMouseListener(KGradientPanel openInsertionBtn) {
		openInsertionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrl.setIndex(code);
				ctrl.setReviewIndex(dbCode);
				ctrl.showInsertionPage(type, code);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				openInsertionBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
	}

	
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
	public String getPlaceCategory() {
		return placeCategory;
	}
	public void setPlaceCategory(String placeSpecialization) {
		this.placeCategory = placeSpecialization;
	}

	public int getDbCode() {
		return dbCode;
	}

	public void setDbCode(int dbCode) {
		this.dbCode = dbCode;
	}
	
	public BufferedImage getInsertionImage() {
		return insertionImage;
	}

	public void setInsertionImage(BufferedImage insertionImage) {
		this.insertionImage = insertionImage;
	}
}
