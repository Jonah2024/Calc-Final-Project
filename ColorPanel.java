
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.decode("#EAEAEA"));
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.fillRect(500, 0, 3, 1000);
        g.fillRect(0, 500, 1000, 3);
        g.fillRect(1000, 0, 1, 1000);

    }

    


}
