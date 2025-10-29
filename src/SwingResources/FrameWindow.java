package SwingResources;


import javax.swing.*;
import java.awt.*;

public class FrameWindow extends JFrame {

    final int SIZE_WIDTH = 500;
    final int SIZE_HEIGHT = 500;

    public void frameGUI(){

        setTitle("Sliding Pussle");
        setSize(SIZE_WIDTH,SIZE_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        ButtonNumberPanel buttonNumberPanel = new ButtonNumberPanel(SIZE_HEIGHT, SIZE_WIDTH);
        add(buttonNumberPanel, BorderLayout.CENTER);


        pack();


    }
}
