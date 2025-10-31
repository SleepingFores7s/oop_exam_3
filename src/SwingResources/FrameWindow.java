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

        
        PanelContainer panels = new PanelContainer(SIZE_WIDTH, SIZE_HEIGHT);
        add(panels, BorderLayout.CENTER);



        setVisible(true);
    }
}
