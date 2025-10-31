package SwingResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNewGamePanel extends JPanel implements ActionListener {

    FrameWindow frame = new FrameWindow();

    public ButtonNewGamePanel() {
       JButton newgameButton = new JButton("New Game");
       newgameButton.addActionListener(this);
       add(newgameButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.removeAll();
        frame.frameGUI();
        frame.revalidate();
        frame.repaint();

    }
}
