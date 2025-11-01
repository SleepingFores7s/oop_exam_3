package SwingResources;

import javax.swing.*;
import java.awt.*;

public class FrameWindow extends JFrame{

    final int SIZE_WIDTH = 500;
    final int SIZE_HEIGHT = 500;

    PanelContainer panels;

    public void frameGUI(){
        //sets [Titel, Width/Height, Not-Resizable, Start-In-Center, Exit-on-close, Layout]
        setTitle("Sliding Pussle");
        setSize(SIZE_WIDTH,SIZE_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Adds the Panel Container
        panels = new PanelContainer(SIZE_WIDTH, SIZE_HEIGHT);
        add(panels, BorderLayout.CENTER);

        //Sets the window to visible
        setVisible(true);
    }
}