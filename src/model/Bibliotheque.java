package model;


import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.sort;

public class Bibliotheque {

	// Liste des documents de la bibliotheque
	private ArrayList<Document> documents;

	public Bibliotheque(ArrayList<Document> documents){		this.documents = documents;	}
	public Bibliotheque() {		this.documents = new ArrayList<Document>(){{}};	}

	public void setDocuments(ArrayList<Document> documents) {		this.documents = documents;	}

	/** Renvoie la liste des documents de la bibliotheque.*/
	public ArrayList<Document> getDocuments() {		return documents;	}

	/** Renvoie le i ème document de la liste des documents, s'il existe, ou null sinon.*/
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
	    String documentsList = new String();
	    for (Document docs : documents){
	        documentsList +=  "\n" + docs.toString();
        }
		return ("Bibliotheque de " + documents.size() + " documents" + documentsList );
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


	public ArrayList<Document> TrieParTitre(){
        sort(documents, new TrieParTitre());
		return documents;}
	public void TrieParTitreDesc(){
		sort(documents, new TrieParTitre());}
	public void TrieParnumEnreg(){
		sort(documents, new TrieParnumEnreg());}


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


	public ArrayList<Document> rechercherParPrix(String prix){
		ArrayList<Document> listePrix = new ArrayList<Document>();
		for (Document docs: this.documents){
			if (docs instanceof Roman){
				if (((Roman)(docs)).getPrixLitteraire().equals(prix)){
					listePrix.add(docs);
				}
			}
		}
		return listePrix;
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

	@Override
	protected Bibliotheque clone() throws CloneNotSupportedException {
		Bibliotheque copy = (Bibliotheque)super.clone();
		copy.documents = (ArrayList<Document>) documents.clone(); 
		return copy;
	}

	public Bibliotheque toutesLesOccurences(String type){
		Bibliotheque bibliType = new Bibliotheque();
		for (Document docs : this.documents){
			if (type.equals("Livre")){
				if (docs instanceof Livre){
					bibliType.documents.add(docs);
				}
			} else if (type.equals("Revue")){
				if (docs instanceof Revue){
					bibliType.documents.add(docs);
				}
			} else if (type.equals("Manuel")){
				if (docs instanceof Manuel){
					bibliType.documents.add(docs);
				}
			} else if (type.equals("Roman")){
				if (docs instanceof Roman){
					bibliType.documents.add(docs);
				}
			}
		}
		return bibliType;
	}



	public void afficherDocument(ArrayList<Document> Documents){
		for(Document docs : Documents){
			System.out.println(docs);
		}
	}

	public ArrayList<String> afficherAuteur(ArrayList<Document> Documents){
		ArrayList<String> listeAuteurs= new ArrayList<>();
		for (Document docs : Documents){
			if (docs instanceof Livre){
				listeAuteurs.add(((Livre)(docs)).getAuteur());
			}
		}
		sort(listeAuteurs);
		return listeAuteurs;
	}

}
