package swing;

import javax.swing.*;
import java.awt.*;

public class SaisieDocument extends JPanel {

    public JPanel AjoueLivre, AjoueRoman,AjoueManuel, AjoueRevue,actif;


    public  SaisieDocument()
    {AjoueLivre();
     AjoueRoman();
     AjoueManuel();
     AjoueRevue();
        actif=AjoueLivre;
    }

    public JPanel getActif(int i)
    {
        switch (i)
    {   case 1:actif= AjoueLivre;break;
        case 2:actif= AjoueRoman;break;
        case 3:actif= AjoueManuel;break;
        case 4:actif= AjoueRevue;break;
        default:actif=AjoueLivre;break;
        }
    return actif;
    }
    public JPanel getActif()
    {return actif;
    }

    private void AjoueLivre()
    { AjoueLivre=new JPanel();
        AjoueLivre.setName("AjoueLivre");
        AjoueLivre.setBackground(Color.blue);

    }
    private void AjoueRoman()
    { AjoueRoman=new JPanel();
        AjoueRoman.setBackground(Color.yellow);

    }
    private void AjoueManuel()
    { AjoueManuel=new JPanel();
        AjoueManuel.setBackground(Color.green);

    }
    private void AjoueRevue()
    { AjoueRevue=new JPanel();
        AjoueRevue.setBackground(Color.red);

    }

}
