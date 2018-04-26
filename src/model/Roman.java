package model;

// TO DO ...
public class Roman extends Livre {

	private int prixLitteraire;

	public Roman(String titre, String auteur, int nbPages, int prixLitteraire) {
		super(titre, auteur, nbPages);
		this.prixLitteraire = prixLitteraire;
	}

	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	public void setPrixLitteraire(int prixLitteraire) {
		this.prixLitteraire = prixLitteraire;
	}
}
