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
		return this.getNumEnreg() + "" + this.getTitre() + "" + this.getAuteur() + "" + this.getNbPages() + "pages" + this.getNiveau() + "Annee";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Manuel manuel = (Manuel) o;

		return niveau == manuel.niveau;
	}

	@Override
	protected Manuel clone() throws CloneNotSupportedException {
		Manuel copy = (Manuel)super.clone();
		return copy;
	}
}
