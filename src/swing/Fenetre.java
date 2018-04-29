package swing;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.security.PublicKey;
import java.util.ArrayList;

import static controller.GestionFichier.lectureDocument2;

public class Fenetre extends JFrame {


    public int width,height;
    public Bibliotheque bibliotheque = lectureDocument2("./src/Bibliotheque_test.csv");
    public  String tampon ="";


    public Fenetre(){
        tampon=new String();
        width=400;
        height=400;
        NouvelleFenetre();

    }
    public Fenetre(String nomFenetre,int Width,int Height){

        width=Width;
        height=Height;
        NouvelleFenetre();
    }

    public void NouvelleFenetre(){

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        getContentPane().add(Acceuil());
        this.setTitle("Acceuil");

        //---------------------------------------------------
        this.setVisible(true);
    }

    // ----------------------------------------------------------------------------------------------------------------------
    public JButton Retour()
    {JButton retour=new JButton("Retour");
        retour.addActionListener(new RetourAcceuil());
        return  retour;
    }
    public JButton Bouton(String Contenu)
    {JButton Bouton=new JButton(Contenu);
        Bouton.addActionListener(new changementFenetre());
        return  Bouton;
    }

    public void changementFenetre(String NomFenetre)
    {

        getContentPane().removeAll();

        switch (NomFenetre)
        {
            case "Acceuil":getContentPane().add(Acceuil());break;
            case "Affichage":getContentPane().add(Affichage());break;
            case "AjoueLivre":getContentPane().add(AjoueLivre());break;
            case "AjoueRoman":getContentPane().add(AjoueRoman());break;
            case "AjoueManuel":getContentPane().add(AjoueManuel());break;
            case "AjoueRevue":getContentPane().add(AjoueRevue());break;
            case "AffichageBibli":getContentPane().add(AffichageBibli()); break;
            case "AffichageAuteurs":getContentPane().add(AffichageAuteurs(bibliotheque.afficherAuteur(bibliotheque.getDocuments()))); break;
            case "TrierParTitre":getContentPane().add(AffichageBibliTitre()); break;
            case "AffichagePrix":getContentPane().add(AffichagePrix()); break;


            default:getContentPane().add(Acceuil());break;
        }
        revalidate();
        repaint();
        this.setTitle(NomFenetre);


    }


//----------------------------------------------------------------------------------------------------------------------



    public JPanel Affichage()
    { JPanel Affichage=new JPanel();
        Affichage.setName("Affichage");

        Affichage.setBackground(Color.red);
        Affichage.setLayout(new GridLayout(5, 1));
        Affichage.add(Bouton("AffichageBibli"));
        Affichage.add(Bouton("AffichageAuteurs"));
        Affichage.add(Bouton("TrierParTitre"));
        Affichage.add(Bouton("AffichagePrix"));
        Affichage.add(Bouton("AjoueRevue"));
        Affichage.add(Retour());
        Affichage.add(new JTextArea("test"));
        return Affichage;
    }
    public JPanel AffichageBibli()
    { JPanel Affichage=new JPanel();
        Affichage.setName("Affichage");

        Affichage.setBackground(Color.red);
        Affichage.add(Retour());
        Affichage.add(new JTextArea(bibliotheque.toString()));
        return Affichage;
    }
    public JPanel AffichageAuteurs(ArrayList<String> listString)
    { JPanel Affichage=new JPanel();
        Affichage.setName("Affichage");

        Affichage.setBackground(Color.red);
        Affichage.add(Retour());
        Affichage.add(new JTextArea(listString.toString()));
        return Affichage;
    }
    public JPanel AffichageBibliTitre()
    { JPanel Affichage=new JPanel();
        Affichage.setName("Affichage");

        Affichage.setBackground(Color.red);
        Affichage.add(Retour());

        Affichage.add(new JTextArea( bibliotheque.TrieParTitre().toString() ) );

        return Affichage;
    }

    public JPanel AffichagePrix()
    { JPanel Affichage=new JPanel();
        Affichage.setName("Affichage");

        Affichage.add(new prixLitteraire("prixLittéraire"));


        Affichage.setLayout(new GridLayout(1, 1));

        return Affichage;
    }


    public JPanel Acceuil()
    {JPanel Acceuil=new JPanel();
        Acceuil.setName("Acceuil");
        Acceuil.setBackground(Color.blue);
        Acceuil.setLayout(new GridLayout(5, 1));
        Acceuil.add(Bouton("Affichage"));
        Acceuil.add(Bouton("AjoueLivre"));
        Acceuil.add(Bouton("AjoueRoman"));
        Acceuil.add(Bouton("AjoueManuel"));
        Acceuil.add(Bouton("AjoueRevue"));


        return Acceuil;
    }

    public JPanel AjoueLivre()
    {
        LinkedList<String> ListeFormulaire=new LinkedList<String>();
        ListeFormulaire.add("Titre :");
        ListeFormulaire.add("Auteur :");
        ListeFormulaire.add("Nombre de pages :");

        JPanel AjoueLivre= new ListFormulaire("Livre",ListeFormulaire);;
        AjoueLivre.setName("AjoueLivre");
        AjoueLivre.setBackground(Color.pink);


        return AjoueLivre;
    }
    public JPanel AjoueRoman()
    {  LinkedList<String> ListeFormulaire=new LinkedList<String>();
        ListeFormulaire.add("Titre :");
        ListeFormulaire.add("Auteur :");
        ListeFormulaire.add("Nombre de pages :");
        ListeFormulaire.add("Prix Litteraire :");
        JPanel AjoueRoman= new ListFormulaire("Roman",ListeFormulaire);;
        AjoueRoman.setName("AjoueRoman");
        AjoueRoman.setBackground(Color.pink);

        return AjoueRoman;
    }

    public JPanel AjoueManuel()
    {
        LinkedList<String> ListeFormulaire=new LinkedList<String>();
        ListeFormulaire.add("Titre :");
        ListeFormulaire.add("Auteur :");
        ListeFormulaire.add("Nombre de pages :");
        ListeFormulaire.add("Niveau :");
        JPanel AjoueManuel= new ListFormulaire("Manuel",ListeFormulaire);;
        AjoueManuel.setName("AjoueManuel");
        AjoueManuel.setBackground(Color.pink);


        return AjoueManuel;
    }
    public JPanel AjoueRevue()
    { LinkedList<String> ListeFormulaire=new LinkedList<String>();
        ListeFormulaire.add("Titre :");
        ListeFormulaire.add("Année :");
        ListeFormulaire.add("Mois");

        JPanel AjoueRevue= new ListFormulaire("Revue",ListeFormulaire);;
        AjoueRevue.setName("AjoueRevue");
        AjoueRevue.setBackground(Color.pink);


        return AjoueRevue;
    }


    //--------------------------------------------------------------------------------------------------------------------------


    class changementFenetre implements ActionListener   {@Override   public void actionPerformed(ActionEvent e) {changementFenetre(e.getActionCommand());    System.out.println(e.getActionCommand()); }}


    class RetourAcceuil implements ActionListener       {@Override   public void actionPerformed(ActionEvent e) {changementFenetre("Acceuil");      System.out.println(e.getActionCommand()); }}
//--------------------------------------------------------------------------------------------------------------------
//----------------------------------  Formulaire    -----------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------
    public class Formulaire extends JPanel {

        public JLabel Label;
        public JTextField champ;

        public  Formulaire(String Entrer,String ValeurDefault)
        {Label=new JLabel(Entrer);
            champ=new JTextField(ValeurDefault);
            add(Label);
            add(champ);
            setLayout(new GridLayout(1, 2));
        }

    }
    //--------------------------------------------------------------------------------------------------------------------
//----------------------------------              -----------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------
    public class prixLitteraire  extends JPanel {

        public JLabel Label;
        public JTextField champ;
        public JButton bouton;
        public JLabel  resultat;

        public  prixLitteraire(String Entrer)
        {Label=new JLabel(Entrer);
         champ=new JTextField();
            bouton=new JButton("valider");
            resultat=new JLabel("");

            bouton.addActionListener(new valider());

            JLabel ligne=new JLabel();
            ligne.setLayout(new GridLayout(1, 3));
                    ligne.add(Label);
                    ligne.add(champ);
                    ligne.add(bouton);

            setLayout(new GridLayout(3, 1));
                add(ligne);
                add(resultat);
                add(Retour());
        }

        class valider implements ActionListener   {@Override   public void actionPerformed(ActionEvent e)
            {

                if(Label.getText().equals("prixLittéraire"))
                {
                    tampon = bibliotheque.rechercherParPrix(champ.getText()).toString();
                }
                System.out.println(tampon);

            }

        }




    }

//--------------------------------------------------------------------------------------------------------------------
//----------------------------------  ListFormulaire    -----------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------
    public class ListFormulaire extends JPanel
    {
        String TypeConstruit;
        LinkedList<Formulaire> form=new LinkedList<>();
        JButton bouton=new JButton("Valider");
        JLabel affichage=new JLabel("");

        public ListFormulaire(String typeConstruit,LinkedList<String> titre)
        {TypeConstruit=typeConstruit;
            setLayout(new GridLayout(3+titre.size(), 1));
            for(String ligne:titre)
            { form.add(new Formulaire(ligne,"")); }
            bouton.addActionListener(new ListFormulaire.Valider());

            for(Formulaire ligne:form)
            { add(ligne);}

            add(affichage);
            add(bouton);
            add(Retour());
        }


        class Valider implements ActionListener
        {@Override   public void actionPerformed(ActionEvent e) {
            for (Formulaire ligne : form) {if(ligne.champ.getText().equals("")){affichage.setText("Tous les champs ne sont pas remplis");return;} }


            LinkedList<String> text=new LinkedList<>();
            for (Formulaire ligne : form)
            {  text.add(ligne.champ.getText()); }


    try{ switch (TypeConstruit)
    { case "Livre":bibliotheque.addDocument(new Livre(text.get(0),text.get(1),Integer.parseInt(text.get(2))));break;
        case "Roman":bibliotheque.addDocument(new Roman(text.get(0),text.get(1),Integer.parseInt(text.get(2)),text.get(3)));break;
        case "Revue":bibliotheque.addDocument(new Revue(text.get(0),Integer.parseInt(text.get(1)),Integer.parseInt(text.get(2))));break;
        case "Manuel":bibliotheque.addDocument(new Manuel(text.get(0),text.get(1),Integer.parseInt(text.get(2)),Integer.parseInt(text.get(3))));break;
        default:affichage.setText("erreur type de document non renseigner");return;
    }
        affichage.setText(TypeConstruit+ " Ajouter a la bibliotheque");
    }
    catch (java.lang.NumberFormatException Exception)
        {
            affichage.setText("Champ nombre remplie avec un texte");
            }
        }



        }
    }

}
