package swing;

import javax.swing.*;

public class Formulaire extends JPanel {

    public JLabel Label;
    public JTextField champ;

    public  Formulaire(String Entrer,String ValeurDefault)
    {Label=new JLabel(Entrer);
    champ=new JTextField(ValeurDefault);
       add(Label);
       add(champ);
        setSize(400, 30);
    }


}
