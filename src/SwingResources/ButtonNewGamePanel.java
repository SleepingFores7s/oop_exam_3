package SwingResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNewGamePanel extends JPanel implements ActionListener {

    public ButtonNewGamePanel() {
       JButton newgameButton = new JButton("New Game");
       add(newgameButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
