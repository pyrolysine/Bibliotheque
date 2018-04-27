package model;

// TO DO ...
public class Roman extends Livre {

	private int prixLitteraire;
		public final static int GONCOURT = 1;
		public final static int MEDICIS = 2;
		public final static int INTERALLIE = 3;
		public final static int PULITZER = 4;


	public Roman(String titre, String auteur, int nbPages, int prixLitteraire) {
		super(titre, auteur, nbPages);
		this.prixLitteraire = prixLitteraire;
	}

	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	public void setPrixLitteraire(String prixLitteraire) {
		if(prixLitteraire == "GONCOURT"){
			this.prixLitteraire = GONCOURT;
		} else if (prixLitteraire == "MEDICIS"){
			this.prixLitteraire = MEDICIS;
		} else if (prixLitteraire == "INTERALLIE"){
			this.prixLitteraire = INTERALLIE;
		} else if (prixLitteraire == "PULITER"){
			this.prixLitteraire = PULITZER;
		} else {
			this.prixLitteraire = 0;
		}
	}

	@Override
	public String toString() {
		return "Roman{" +
				"numEnreg=" + getNumEnreg() +
				", titre='" + getTitre() + '\'' +
				"auteur='" + getAuteur() + '\'' +
				", nbPages=" + getNbPages() +
				"prixLitteraire=" + prixLitteraire +
				'}';
	}
}
