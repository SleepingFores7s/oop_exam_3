package SwingResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonNumberPanel extends JPanel implements ActionListener {

    //Essentials
    private ArrayList<JButton> buttonArray = new ArrayList<>();

    public ButtonNumberPanel() {

        //sets Layout
        setLayout(new GridLayout(4, 4, 4, 4));

        //puts the number buttons into the array
        putIntoArray();

        //Empty space button
        JButton buttonEmpty = new JButton("");
        buttonEmpty.setBackground(Color.decode("#DCDCDC"));
        buttonArray.add(buttonEmpty);

        //Shuffles the array
        shuffleButtons();

        //adds the buttons to the panel
        addToPanel();
    }

    //Places buttons into Array
    public void putIntoArray() {
        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setBackground(Color.decode("#FFFAF0"));
            button.setForeground(Color.decode("#005577"));
            button.addActionListener(this);
            buttonArray.add(button);
        }
        System.out.println("log: Buttons added to Array. Size: " + buttonArray.size());
    }

    //Shuffles Array
    public void shuffleButtons() {
        Collections.shuffle(buttonArray);
        System.out.println("log: Buttons shuffled");
    }

    //Adds Array buttons to panel
    public void addToPanel() {

        for (JButton jButton : buttonArray) {
            add(jButton);
        }
        System.out.println("log: Buttons added to panel");
    }

    //Gets Array location of pressed button
    public int getPressedLocation(ActionEvent e) {

        for (int i = 0; i < buttonArray.size(); i++) {
            if (e.getSource() == buttonArray.get(i)) {
                System.out.println("log: Pressed button = "+i);
                return i;
            }
        }
        return -1;
    }

    //gets Array location of empty button
    public int getEmptyLocation() {

        for (int j = 0; j < buttonArray.size(); j++) {
            if (buttonArray.get(j).getText().isEmpty()) {
                System.out.println("log: Empty location = " + j);
                return j;
            }
        }
        return -1;
    }

    //Switches position of empty & pressed buttons, then checks if the game is won
    public void switchPositions(int pressLocation, int emptyLocation) {

        JButton tempStorage;
        tempStorage = buttonArray.get(emptyLocation);
        buttonArray.set(emptyLocation, buttonArray.get(pressLocation));
        buttonArray.set(pressLocation, tempStorage);

        removeAll();
        addToPanel();
        revalidate();

        System.out.println("log: Positions switched");

        winningCheck();
    }

    //Checks if buttons are in correct order to win
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

    //Makes a win panel appear
    public void winningPanel() {

        //Text Field to be added to panel
        JTextField winMessage = new JTextField("You Won!");
        winMessage.setHorizontalAlignment(0);

        removeAll();
        add(winMessage);
        revalidate();
        repaint();

    }

    //Checks if the pressed button is on the Left/Middle/Right side, then calls switchPositions
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
