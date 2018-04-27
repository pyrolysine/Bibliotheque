package model;

// TO DO ...
public class Revue extends Document {

	private int mois;
	private int annee;

	public Revue(String titre, int mois, int annee) {
		super(titre);
		this.mois = mois;
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	@Override
	public String toString() {
		return "Revue{" +
				"mois=" + mois +
				", annee=" + annee +
				'}';
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
}
