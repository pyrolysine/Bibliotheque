package swing;

import javax.swing.*;

public class Fenetre extends JFrame {


    public int width,height;
    public Affichage Affichage;
    public SaisieDocument SaisieDocument;
    public JPanel Actif;

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
        //---------------------------------------------------
        Affichage=new Affichage();
        SaisieDocument=new SaisieDocument();

        Actif=SaisieDocument.AjoueLivre;
        this.setTitle(Actif.getName());

        this.setContentPane( Actif);


        //---------------------------------------------------
        this.setVisible(true);
    }


}
