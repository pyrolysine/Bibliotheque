package model;

import java.util.Comparator;

// TO DO ...
public class Livre extends Document implements InterfaceAuteur {

	private String auteur;
	private int nbPages;

	@Override
	public String getAuteur() {
		return this.auteur;
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
				"numEnreg=" + getNumEnreg() + '\t' +
				", titre='" + getTitre() + "\t\t" +
				"auteur='" + auteur + '\t' +
				", nbPages=" + nbPages +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Livre livre = (Livre) o;

		if (nbPages != livre.nbPages) return false;
		return auteur != null ? auteur.equals(livre.auteur) : livre.auteur == null;
	}

	@Override
	protected Livre clone() throws CloneNotSupportedException {
		Livre copy = (Livre)super.clone();
<<<<<<< HEAD
		return copy;
=======

		return super.clone();
>>>>>>> cc2fb6cfad6540bdb8ad29e7ba3c034b4beb82ca
	}
}