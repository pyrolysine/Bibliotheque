package view;

import model.Document;
import model.Livre;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.sort;

/**
 * Utilitaires d'affichage
 */
public class Affichage {
    public void afficherDocument(ArrayList<Document> Documents){
        for(Document docs : Documents){
            System.out.println(docs);
        }
    }

    public void afficherAuteur(ArrayList<Document> Documents){
        ArrayList<String> listeAuteurs= new ArrayList<>();
        for (Document docs : Documents){
            if (docs instanceof Livre){
                listeAuteurs.add(((Livre)(docs)).getAuteur());
            }
        }
        sort(listeAuteurs);
        for (String auteur : listeAuteurs){
            System.out.println(auteur);
        }
    }




}
