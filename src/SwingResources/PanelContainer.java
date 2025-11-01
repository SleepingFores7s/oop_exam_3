package SwingResources;

import javax.swing.*;
import java.awt.*;

public class PanelContainer extends JPanel {

    //Essentials
    private ButtonNumberPanel numberPanel;
    JButton newGameButton = new JButton("New Game");

    public PanelContainer(int sizeW,int sizeH) {

        //Sets Layout
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

        //Sets panel size
        setPreferredSize(new Dimension(sizeW, sizeH));

        //Number Buttons
        numberPanel = new ButtonNumberPanel();
        add(numberPanel,BorderLayout.CENTER);

        //New Game button + listener
        newGameButton.addActionListener(e -> {
            resetGame();
            System.out.println("Log: Game reset.");
        });

        //Sets the color for New Game button
        newGameButton.setBackground(Color.decode("#FFFAF0"));
        newGameButton.setForeground(Color.decode("#005577"));

        //Adds New Game button to panel
        add(newGameButton, BorderLayout.SOUTH);
    }

    //Resets the game / re-shuffles
    public void resetGame() {
        numberPanel.removeAll();
        numberPanel.shuffleButtons();
        numberPanel.addToPanel();
        numberPanel.revalidate();
    }

}
