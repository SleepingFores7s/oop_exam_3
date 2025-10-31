package SwingResources;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

class ButtonNumberPanelTest {

    ArrayList<JButton> buttonArrayTest = new ArrayList<>();

    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("");



    @Test
    void actionPerformed() {

        buttonArrayTest.add(button1);
        buttonArrayTest.add(button2);
        buttonArrayTest.add(button3);
        buttonArrayTest.add(button4);
        buttonArrayTest.add(button5);

        button1.doClick();


    }
}