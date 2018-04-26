package model;
import java.lang.String;
// TO DO ...
public abstract class Document {

	private static int nbrDoc;
	private int numEnreg;
	private String titre;

	public Document(String titre) {
		nbrDoc++;
		this.numEnreg = nbrDoc;
		this.titre = titre;
	}

	public static int getNbrDoc() {
		return nbrDoc;
	}

	public int getNumEnreg() {
		return numEnreg;
	}

	public String getTitre() {
		return titre;
	}

	public void setNumEnreg(int numEnreg) {
		this.numEnreg = numEnreg;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Document{" +
				"numEnreg=" + numEnreg +
				", titre='" + titre + '\'' +
				'}';
	}
}
