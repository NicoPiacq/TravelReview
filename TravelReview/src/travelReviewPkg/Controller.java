package travelReviewPkg;

public class Controller {

	private LoginFrame frameLogin = new LoginFrame(this);
	private MainFrame frameMain = new MainFrame(this);
	
	public Controller() {
		
		//frameLogin.setVisible(true);
		frameMain.setVisible(true);
		
	}
	
}
