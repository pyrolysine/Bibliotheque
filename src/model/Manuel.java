package model;

// TO DO ...
public class Manuel extends Livre {

	private int niveau;

	public Manuel(String titre, String auteur, int nbPages, int niveau) {
		super(titre, auteur, nbPages);
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return  "Manuel{" +
				"numEnreg=" + getNumEnreg() +
				", titre='" + getTitre() + '\'' +
				"auteur='" + getAuteur() + '\'' +
				", nbPages=" + getNbPages() +
				"niveau=" + niveau +
				'}';
	}

}
