package SwingResources;

import javax.swing.*;
import java.awt.*;

public class PanelContainer extends JPanel {

    ButtonNumberPanel numberPanel;
    JButton newGameButton = new JButton("New Game");

    public PanelContainer(int sizeW,int sizeH) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeW, sizeH));

        //Number Buttons
        numberPanel = new ButtonNumberPanel();
        add(numberPanel,BorderLayout.CENTER);


        //New Game button + listener
        newGameButton.addActionListener(e -> {
            resetGame();
        });
        add(newGameButton, BorderLayout.SOUTH);


    }

    //resets the game / re-shuffles
    public void resetGame() {
        numberPanel.removeAll();
        numberPanel.shuffleButtons();
        numberPanel.addToPanel();
        numberPanel.revalidate();
    }

}
