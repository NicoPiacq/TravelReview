package travelReviewPkg;

import java.awt.Image;

public class Inserzione {
	
	private enum TipoInserzione {
		Ristorante,
		Alloggio,
		Attrazione;
	}
	
	
	private TipoInserzione tipo;
	private int codice;
	private Image image;
	private String poster;
	
	
	public TipoInserzione getTipo() {
		return tipo;
	}
	public void setTipo(String type) {
		switch(type) {
			case "Ristorante": {
				tipo = TipoInserzione.Ristorante;
				break;
			}
			case "Alloggio": {
				tipo = TipoInserzione.Alloggio;
				break;
			}
			case "Attrazione": {
				tipo = TipoInserzione.Attrazione;
				break;
			}
		}
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}

	
	
}
