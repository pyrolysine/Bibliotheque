package model;


import java.util.ArrayList;
import java.util.*;


public class Bibliotheque {

	// Liste des documents de la bibliotheque
	private ArrayList<Document> documents;

	public Bibliotheque(ArrayList<Document> documents){
		this.documents = documents;
	}
	public Bibliotheque() {
		this.documents = new ArrayList<Document>(){{}};
	}


	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}

	/**
	 * Renvoie la liste des documents de la bibliotheque.
	 */
	public ArrayList<Document> getDocuments() {
		return documents;
	}

	/**
	 * Renvoie le i ème document de la liste des documents, s'il existe,
	 * ou null sinon.
	 */
	public Document getDocument(int i) {
		try {
			if (this.documents.get(i) != null) {
				return this.documents.get(i);
			} else {
				return null;
			}
		} catch (RuntimeException re){
			throw new RuntimeException("getDocument() not yet implemented");
		}
	}
	
	/**
	 * Si doc est non null et n'appartient pas déjà à la liste des documents,
	 * alors ajoute doc à cette liste et renvoie true ;
	 * sinon renvoie faux.
	 */
	public boolean addDocument(Document doc) {
		try {
			if (!this.documents.contains(doc)){
				this.documents.add(doc);
				return true;
			} else {
				System.out.println("ce document est deja dans la liste");
				return false;
			}
		} catch (RuntimeException re) {
			throw new RuntimeException("addDocument() not yet implemented");
		}
	}
	
	/**
	 * Si doc est dans la liste des documents, alors l'y supprime et renvoie true;
	 * sinon renvoie false.
	 */
	public boolean removeDocument(Document doc) {
		try {
			if (this.documents.contains(doc)){
				this.documents.remove(this.documents.indexOf(doc));
				return true;
			} else {
				return false;
			}
		}catch (RuntimeException re){
			throw new RuntimeException("removeDocument() not yet implemented");
		}
	}

	@Override
	public String toString() {
		return "Bibliotheque de " + documents.size() + " documents";
	}
	public void rechercherParPrix(){

	}

	public void afficher(){
		System.out.println();
		for(Document ligne:documents)
		{
			System.out.println(ligne.toString());
		}
		System.out.println();
	}


	//---------------------------------------------------------------------------------------
	public void chercherDocumentParTitre(String titre){
		for (Document docs: this.documents){
			if (docs.getTitre().equals(titre)){
				System.out.println(docs);
			}
		}
	}

	public Bibliotheque supprimerDocumentParTitre(String titre){
		for (Document docs: this.documents){
			if (docs.getTitre().equals(titre)){
				this.documents.remove(docs);
			}
		}
		return this;
	}


	public void TrieParTitre(){Collections.sort(documents, new TrieParTitre());}
	public void TrieParTitreDesc(){Collections.sort(documents, new TrieParTitre());}
	public void TrieParnumEnreg(){Collections.sort(documents, new TrieParnumEnreg());}


	public class TrieParTitre implements Comparator<Document> {
        public int compare(Document a, Document b) {
            return a.getTitre().compareTo(b.getTitre());
        }
    }
        public class TrieParTitredesc implements Comparator<Document>
        {public int compare(Document b, Document a)
        {return a.getTitre().compareTo(b.getTitre());}
        }
        public class TrieParnumEnreg implements Comparator<Document>
        {public int compare(Document a, Document b)
        {return a.getNumEnreg()-b.getNumEnreg(); }
        }


	public void rechercherParPrix(String prix){
		for (Document docs: this.documents){
			if (docs instanceof Roman){
				if (((Roman)(docs)).getPrixLitteraire().equals(prix)){
					System.out.println(docs);
				}
			}
		}
	}
	public Bibliotheque supprimerParPrix(String prix){
		for (Document docs: this.documents){
			if (docs instanceof Roman){
				if (((Roman)(docs)).getPrixLitteraire().equals(prix)){
					this.documents.remove(docs);
				}
			}
		}
		return this;
	}
}
