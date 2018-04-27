package model;

// TO DO ...
public class Roman extends Livre {

	private int prixLitteraire;
		public final static int GONCOURT = 1;
		public final static int MEDICIS = 2;
		public final static int INTERALLIE = 3;
		public final static int PULITZER = 4;


	public Roman(String titre, String auteur, int nbPages, String prixLitteraire) {
		super(titre, auteur, nbPages);
		this.prixLitteraire = setPrixLitteraire(prixLitteraire);
	}

	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	public int setPrixLitteraire(String prixLitteraire) {
		if(prixLitteraire == "GONCOURT"){
			return GONCOURT;
		} else if (prixLitteraire == "MEDICIS"){
			return MEDICIS;
		} else if (prixLitteraire == "INTERALLIE"){
			return INTERALLIE;
		} else if (prixLitteraire == "PULITER"){
			return PULITZER;
		} else {
			return 0;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Roman roman = (Roman) o;

		return prixLitteraire == roman.prixLitteraire;
	}

	@Override
	public int hashCode() {
		return prixLitteraire;
	}
}
