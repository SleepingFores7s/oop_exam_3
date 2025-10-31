package SwingResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonNumberPanel extends JPanel implements ActionListener {

    ArrayList<JButton> buttonArray = new ArrayList<>();

    public ButtonNumberPanel() {
        setLayout(new GridLayout(4,4,4,4));

        //Empty space button
        JButton buttonEmpty = new JButton("");
        buttonArray.add(buttonEmpty);

        //puts the buttons into the array
        putIntoArray();

        //Shuffles the array
        Collections.shuffle(buttonArray);

        //adds the buttons to the panel
        addToPanel();
    }

    public void putIntoArray() {
        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttonArray.add(button);
        }
    }

    public void addToPanel() {

        for (int i = 0; i < buttonArray.size(); i++) {
            add(buttonArray.get(i));
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Check the array for the used button and save its position in a temp variable
        //Use the temp vari to look at -4,-1, +1, +4 to see if any of them is ""
        //  -if not do nothing
        //  -if it is, swap positions of the "" and used button

        int tempPress = -1;
        int tempEmpty = -1;
        int i;
        int j;
        //Todo - move pressed source into its own method

        for (i = 0; i < buttonArray.size(); i++) {
            if(e.getSource() == buttonArray.get(i)) {
                tempPress = i;
                break;
            }
        }

        //Todo - move blank space location into its own method
        for (j = 0; j < buttonArray.size(); j++) {
            if (buttonArray.get(j).getText().equals("")) {
                tempEmpty = j;
                break;
            }
        }

        JButton tempStorage;

        if(tempPress == 3 || tempPress == 7 || tempPress == 11 || tempPress == 15) {

            if((tempPress +4) == tempEmpty || (tempPress - 1) == tempEmpty || (tempPress - 4) == tempEmpty) {

                tempStorage = buttonArray.get(tempEmpty);

                buttonArray.set(tempEmpty, buttonArray.get(tempPress));
                buttonArray.set(tempPress, tempStorage);

                removeAll();

                addToPanel();

                revalidate();
            }

        } else if (tempPress == 0 || tempPress == 4 || tempPress == 8 || tempPress == 12) {

            if((tempPress +4) == tempEmpty || (tempPress + 1) == tempEmpty || (tempPress - 4) == tempEmpty) {

                tempStorage = buttonArray.get(tempEmpty);

                buttonArray.set(tempEmpty, buttonArray.get(tempPress));
                buttonArray.set(tempPress, tempStorage);

                removeAll();

                addToPanel();

                revalidate();
            }

        }else {
            if ((tempPress + 1) == tempEmpty || (tempPress + 4) == tempEmpty || (tempPress - 1) == tempEmpty || (tempPress - 4) == tempEmpty) {

                tempStorage = buttonArray.get(tempEmpty);

                buttonArray.set(tempEmpty, buttonArray.get(tempPress));
                buttonArray.set(tempPress, tempStorage);

                removeAll();

                addToPanel();

                revalidate();
            }
        }



    }
}
