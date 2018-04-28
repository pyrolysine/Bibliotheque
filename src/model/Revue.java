package model;


import java.util.Comparator;

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

	public void setAnnee(int annee) {
		this.annee = annee;
	}


	@Override
	public String toString() {
		return "Revue{" +
				"mois=" + mois +
				", annee=" + annee +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Revue revue = (Revue) o;

		if (mois != revue.mois) return false;
		return annee == revue.annee;
	}

	@Override
	protected Revue clone() throws CloneNotSupportedException {
		Revue copy = (Revue)super.clone();
		return copy;
	}
}
