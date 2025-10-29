package SwingResources;

import javax.swing.*;
import java.awt.*;

public class PanelContainer extends JPanel {

    public PanelContainer(int sizeW,int sizeH) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeW, sizeH));

        ButtonNumberPanel numberPanel = new ButtonNumberPanel();
        add(numberPanel,BorderLayout.CENTER);

        ButtonNewGamePanel newgamePanel = new ButtonNewGamePanel();
        add(newgamePanel, BorderLayout.SOUTH);


    }

}
