package SwingResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JPanel implements ActionListener {

    JButton newGameButton = new JButton("New Game");

    public NewGameButton() {

        newGameButton.addActionListener(this);

        newGameButton.setBackground(Color.decode("#FFFAF0"));
        newGameButton.setForeground(Color.decode("#005577"));

        add(newGameButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Container containerFirstParent = (Container) e.getSource();

        //Parent 1. NewGame-Panel 2. Panel Container 3. Frame
        containerFirstParent = containerFirstParent.getParent().getParent().getParent();

        containerFirstParent.removeAll();
        containerFirstParent.add(new PanelContainer(500,500));
        containerFirstParent.revalidate();
        containerFirstParent.repaint();


    }
}
