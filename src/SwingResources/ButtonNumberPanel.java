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
        setLayout(new GridLayout(4, 4, 4, 4));

        //puts the number buttons into the array
        putIntoArray();

        //Empty space button
        JButton buttonEmpty = new JButton("");
        buttonArray.add(buttonEmpty);

        //Shuffles the array
        shuffleButtons();

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

    public void shuffleButtons() {
        Collections.shuffle(buttonArray);
    }

    public void addToPanel() {

        for (JButton jButton : buttonArray) {
            add(jButton);
        }

    }

    public int getPressedLocation(ActionEvent e) {

        for (int i = 0; i < buttonArray.size(); i++) {
            if (e.getSource() == buttonArray.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public int getEmptyLocation() {

        for (int j = 0; j < buttonArray.size(); j++) {
            if (buttonArray.get(j).getText().isEmpty()) {
                return j;
            }
        }
        return -1;
    }

    public void switchPositions(int pressLocation, int emptyLocation) {

        JButton tempStorage;
        tempStorage = buttonArray.get(emptyLocation);
        buttonArray.set(emptyLocation, buttonArray.get(pressLocation));
        buttonArray.set(pressLocation, tempStorage);

        removeAll();
        addToPanel();
        revalidate();

        winningCheck();
    }

    public void winningCheck() {
        for (int i = 0; i < 15; i++) {

            if (buttonArray.get(i).getText().equals("")) {
                break;
            }

            int numberInOrder = Integer.parseInt(buttonArray.get(i).getText());

            if (numberInOrder != (i + 1)) {
                break;
            } else {
                if (numberInOrder == 15) {
                    winningPanel();
                }
            }

        }
    }

    public void winningPanel() {
        //Todo - Make a call to a panel to display that player has won
        System.out.println("You won!");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Gets the pressed & empty buttons locations
        int pressedLocation = getPressedLocation(e);
        int emptyLocation = getEmptyLocation();

        //Checks if the number is located on the left side
        if (pressedLocation == 3 || pressedLocation == 7 || pressedLocation == 11 || pressedLocation == 15) {
            if ((pressedLocation + 4) == emptyLocation || (pressedLocation - 1) == emptyLocation || (pressedLocation - 4) == emptyLocation) {

                switchPositions(pressedLocation, emptyLocation);

            }

            //Checks if the number is located on the right side
        } else if (pressedLocation == 0 || pressedLocation == 4 || pressedLocation == 8 || pressedLocation == 12) {
            if ((pressedLocation + 1) == emptyLocation || (pressedLocation + 4) == emptyLocation || (pressedLocation - 4) == emptyLocation) {

                switchPositions(pressedLocation, emptyLocation);

            }

            //Runs if the number is not on the left or right side
        } else {
            if ((pressedLocation + 4) == emptyLocation || (pressedLocation + 1) == emptyLocation || (pressedLocation - 1) == emptyLocation || (pressedLocation - 4) == emptyLocation) {

                switchPositions(pressedLocation, emptyLocation);

            }

        }


    }
}
