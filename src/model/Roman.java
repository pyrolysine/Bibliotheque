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

	public String getPrixLitteraire() {
		switch (prixLitteraire){
			case 1: return "GONCOURD";
			case 2: return "MEDICIS";
			case 3: return "INTERALLIE";
			case 4: return "PUBLITER";
			default: return  "Aucun Prix";

		}

	}

	public int setPrixLitteraire(String prixLitteraire) {
		if(prixLitteraire.equals("Roman.GONCOURT")  ){
			return GONCOURT;
		} else if (prixLitteraire.equals("Roman.MEDICIS")){
			return MEDICIS;
		} else if (prixLitteraire.equals("Roman.INTERALLIE")){
			return INTERALLIE;
		} else if (prixLitteraire.equals("Roman.PULITER")){
			return PULITZER;
		} else {
			return 42;
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

	@Override
	protected Roman clone() throws CloneNotSupportedException {
		Roman copy = (Roman) super.clone();
		return copy;
	}
}
