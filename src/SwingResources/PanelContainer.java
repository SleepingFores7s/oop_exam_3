package SwingResources;

import javax.swing.*;
import java.awt.*;

public class PanelContainer extends JPanel {

    //Essentials
    private ButtonNumberPanel numberPanel;
    private NewGameButton newGameButton;
//    JButton newGameButton = new JButton("New Game");

    public PanelContainer(int sizeW,int sizeH) {

        //Sets Layout
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

        //Sets panel size
        setPreferredSize(new Dimension(sizeW, sizeH));

        //Number Buttons
        numberPanel = new ButtonNumberPanel();
        add(numberPanel,BorderLayout.CENTER);

        //New Game Button
        newGameButton = new NewGameButton();
        add(newGameButton, BorderLayout.SOUTH);

    }

}
