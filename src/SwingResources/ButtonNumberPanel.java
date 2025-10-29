package SwingResources;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonNumberPanel extends JPanel {

    ArrayList<JButton> buttonArray = new ArrayList<>();

    public ButtonNumberPanel() {
        setLayout(new GridLayout(4,4,4,4));

        //Empty space button
        JButton buttonEmpty = new JButton("");
        buttonArray.add(buttonEmpty);

        //puts the buttons into the array
        for (int i = 1; i <= 15; i++) {
            buttonArray.add(new JButton(String.valueOf(i)));
        }

        //Shuffles the array
        Collections.shuffle(buttonArray);

        //adds the buttons to the panel
        for (int i = 0; i < buttonArray.size(); i++) {
            add(buttonArray.get(i));
        }
    }
}
