
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{

    double[] xCoordinates = new double[10000];
    double[] yCoordinates = new double[10000];

    public void paintComponent(Graphics g) {

        SimpleGraph graph = new SimpleGraph();

        super.paintComponent(g);

        g.setColor(Color.decode("#EAEAEA"));
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.fillRect(500, 0, 3, 1000);
        g.fillRect(0, 500, 1000, 3);
        g.fillRect(1000, 0, 1, 1000);

        g.fillOval(600, 400, 5, 5);
        g.fillOval(700, 300, 5, 5);
        g.fillOval(800, 200, 5, 5);
        g.fillOval(900, 100, 5, 5);

        g.setColor(Color.RED);
        for (int i = 0; i < xCoordinates.length; i ++){
            if(i % 100 == 0){
                 //System.out.println("(" + (int) (xCoordinates[i]) + ", " + (int) (-1 * yCoordinates[i]) + ")");
            }
           
            g.fillOval((int) (xCoordinates[i] * (100) + 500), (int) (-1 * yCoordinates[i] * 100 + 500), 3, 3);
        }

    }

    public void createCoordinates(double x, double y, int place){
        xCoordinates[place] = x;
        yCoordinates[place] = y;
    }
    


}
