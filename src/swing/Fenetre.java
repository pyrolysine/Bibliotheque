package swing;

import model.Bibliotheque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;

import static controller.GestionFichier.lectureDocument2;

public class Fenetre extends JFrame {


    public int width,height;
    public Bibliotheque bibliotheque = lectureDocument2("./src/Bibliotheque_test.csv");


    public Fenetre(){

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
        Affichage.add(Bouton("AjoueManuel"));
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
    { JPanel AjoueLivre=new JPanel();
        AjoueLivre.setName("AjoueLivre");
        AjoueLivre.setBackground(Color.pink);
        AjoueLivre.setLayout(new GridLayout(5, 1));


        AjoueLivre.add(new Formulaire("test","valeur"));
        AjoueLivre.add(new Formulaire("test","valeur"));
        AjoueLivre.add(new Formulaire("test","valeur"));
        AjoueLivre.add(new Formulaire("test","valeur"));

        AjoueLivre.add(Retour());
        return AjoueLivre;
    }
    public JPanel AjoueRoman()
    { JPanel Affichage=new JPanel();
        Affichage.setName("AjoueRoman");
        Affichage.setBackground(Color.yellow);
        Affichage.add(Retour());
        return Affichage;
    }

    public JPanel AjoueManuel()
    { JPanel Affichage=new JPanel();
        Affichage.setName("AjoueManuel");
        Affichage.setBackground(Color.green);
        Affichage.add(Retour());
        return Affichage;
    }
    public JPanel AjoueRevue()
    { JPanel Affichage=new JPanel();
        Affichage.setName("AjoueRevue");
        Affichage.setBackground(Color.gray);
        Affichage.add(Retour());
        return Affichage;
    }


    //--------------------------------------------------------------------------------------------------------------------------
    class changementFenetre implements ActionListener   {@Override   public void actionPerformed(ActionEvent e) {changementFenetre(e.getActionCommand());    System.out.println(e.getActionCommand()); }}
    class RetourAcceuil implements ActionListener       {@Override   public void actionPerformed(ActionEvent e) {changementFenetre("Acceuil");      System.out.println(e.getActionCommand()); }}
}
