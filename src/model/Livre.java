package model;

// TO DO ...
public class Livre extends Document implements InterfaceAuteur {

	private String auteur;
	private int nbPages;

	@Override
	public String getAuteur() {
		return null;
	}

	public Livre(String titre, String auteur, int nbPages) {
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	public int getNbPages() {
		return nbPages;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Livre{" +
				"auteur='" + auteur + '\'' +
				", nbPages=" + nbPages +
				'}';
	}
}
