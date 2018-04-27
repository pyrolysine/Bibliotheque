package controller;


import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GestionFichier {

        public static  ArrayList<Document> lectureDocument(String Nom_document)
    { LinkedList<LinkedList<String>> Entrer = lectureDocument1(Nom_document);
        ArrayList<Document>   Bibliotheque_importer = new ArrayList<Document>() ;

        for(LinkedList<String> element :Entrer )
        {
            if    (element.get(0).equals("Livre"))
            {Bibliotheque_importer.add(new Livre(element.get(1), element.get(2), Integer.parseInt(element.get(3))));}
            else  if(element.get(0).equals("Roman"))
            {String prixLitteraire;
                switch (element.get(4))
                {case "1" :prixLitteraire="Roman.GONCOURT";break;
                case "2" :prixLitteraire="Roman.MEDICIS";break;
                case "3" :prixLitteraire="Roman.INTERALLIE";break;
                case "4" :prixLitteraire="Roman.PULITZER";break;
                    default: prixLitteraire="Aucun";break;
                }

                Bibliotheque_importer.add(new Roman(element.get(1), element.get(2), Integer.parseInt(element.get(3)),prixLitteraire));}
            else  if(element.get(0).equals("Revue"))
            {Bibliotheque_importer.add(new Revue(element.get(1), Integer.parseInt(element.get(2)), Integer.parseInt(element.get(3))));}
            else  if(element.get(0).equals("Manuel"))
            {Bibliotheque_importer.add(new Manuel(element.get(1), element.get(2),Integer.parseInt(element.get(3)), Integer.parseInt(element.get(4))));}
        }
        return Bibliotheque_importer;
    }

    public static Bibliotheque lectureDocument2(String Nom_document)
    {return new Bibliotheque(lectureDocument( Nom_document));}




    public static  LinkedList<LinkedList<String>> lectureDocument1(String Nom_document)
    { LinkedList<LinkedList<String>> Fichier_lu= new LinkedList();
        File file = new File(Nom_document);

        try{Scanner inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                LinkedList<String> ligne=new LinkedList<String>();

                String ligne_brut = inputStream.nextLine();
                String[] parts = ligne_brut.split(";");
                for (String Cellule:parts) { ligne.add(Cellule);}
                Fichier_lu.add(ligne);
            }
            inputStream.close();


        }catch (FileNotFoundException e){ e.printStackTrace(); }
        return Fichier_lu;
    }



    public static  void ecritureDocument(String Nom_document,LinkedList<LinkedList<String>> Donner)
    {
        try{
            FileWriter writer = new FileWriter(Nom_document);
            StringBuilder sb = new StringBuilder();

            for (LinkedList<String> Ligne:Donner     ) {
                for (String Cellule:Ligne     ) {
                    sb.append(Cellule+";");
                }
                sb.append("\n");
            }
            writer.write(sb.toString());
            writer.close();

        } catch(IOException ex){ }
    }



    public static  void lectureAffichageDocument(String Nom_document)
    {LinkedList<LinkedList<String>> Entrer = lectureDocument1(Nom_document);
        for (LinkedList<String> Ligne: Entrer     ) {
            for (String Cellule:Ligne     ) {
                System.out.print(Cellule+" \t");
            }
            System.out.println();
        }


    }
    public static  void lectureAffichageDocumentArray(String Nom_document)
    {ArrayList<Document> Entrer= lectureDocument( Nom_document);

        for (Document document:Entrer     ) {

            System.out.println(document.toString());
        }


    }

    public static  void ecritureDocument2(String Nom_document,Bibliotheque Bibliotheque)
    {
        ecritureDocument1(Nom_document,Bibliotheque.getDocuments());

    }

    public static  void ecritureDocument1(String Nom_document,ArrayList<Document> Documents)
    {LinkedList<LinkedList<String>> bibliotheque = new LinkedList<LinkedList<String>>();

        for(Document element :Documents )
        {LinkedList<String> current=new LinkedList<String>();

            if (element instanceof Livre)
            {
                current.add("Livre");
                current.add(element.getTitre());
                current.add(((Livre) element).getAuteur());
                current.add(((Livre) element).getNbPages()+ "");
            }
            else  if(element instanceof Roman)
            {
                current.add("Roman");
                current.add(element.getTitre());
                current.add(((Roman) element).getAuteur());
                current.add(((Roman) element).getNbPages() + "");
                current.add(((Roman) element).getPrixLitteraire() + "");
            }
            else  if(element instanceof Revue)
            {
                current.add("Revue");
                current.add(element.getTitre());
                current.add(((Revue) element).getMois() + "");
                current.add(((Revue) element).getAnnee() + "");
            }
            else  if(element instanceof Manuel) {
                current.add("Manuel");
                current.add(element.getTitre());
                current.add(((Manuel) element).getAuteur());
                current.add(((Manuel) element).getNbPages() + "");
                current.add(((Manuel) element).getNiveau() + "");
            }

            bibliotheque.add(current);
        }
        ecritureDocument(Nom_document,bibliotheque);
    }


}
