package travelReviewPkg;

import java.sql.ResultSet;

public class AttrazioneDAO {

	private Attrazione attrazione = new Attrazione();
	
	public AttrazioneDAO(Controller c) {
		
	}
	
	public ResultSet searchByCitta(Attrazione attrazione) {
		String citta = attrazione.getCitta();
	}
	
	
}
