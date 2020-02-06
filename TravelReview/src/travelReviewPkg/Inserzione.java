package travelReviewPkg;

public class Inserzione {
	
	private enum TipoInserzione {
		RISTORANTE,
		ALLOGGIO,
		ATTRAZIONE;
	}
	
	private TipoInserzione tipo;
	private String codice;

	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;	
	}
	
	public TipoInserzione getTipo() {
		return tipo;
	}

	public void setTipo(TipoInserzione tipo) {
		this.tipo = tipo;
	}
	
}
