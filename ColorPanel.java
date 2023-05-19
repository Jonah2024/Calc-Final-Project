
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{

    double[] xCoordinates = new double[20000];
    double[] yCoordinates = new double[20000];

    public void paintComponent(Graphics g) {

        SimpleGraph graph = new SimpleGraph();

        super.paintComponent(g);

        g.setColor(Color.decode("#EAEAEA"));
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.fillRect(500, 0, 3, 1000);
        g.fillRect(0, 500, 1000, 3);
        g.fillRect(1000, 0, 1, 1000);

        //gridLines
        g.setColor(Color.gray);
        g.fillRect(600, 0, 1, 1000);
        g.fillRect(700, 0, 1, 1000);
        g.fillRect(800, 0, 1, 1000);
        g.fillRect(900, 0, 1, 1000);
        g.fillRect(400, 0, 1, 1000);
        g.fillRect(300, 0, 1, 1000);
        g.fillRect(200, 0, 1, 1000);
        g.fillRect(100, 0, 1, 1000);
        g.fillRect(0, 100, 1000, 1);
        g.fillRect(0, 200, 1000, 1);
        g.fillRect(0, 300, 1000, 1);
        g.fillRect(0, 400, 1000, 1);
        g.fillRect(0, 600, 1000, 1);
        g.fillRect(0, 700, 1000, 1);
        g.fillRect(0, 800, 1000, 1);
        g.fillRect(0, 900, 1000, 1);

        g.fillRect(650, 0, 1, 1000);
        g.fillRect(550, 0, 1, 1000);
        g.fillRect(750, 0, 1, 1000);
        g.fillRect(850, 0, 1, 1000);
        g.fillRect(950, 0, 1, 1000);
        g.fillRect(450, 0, 1, 1000);
        g.fillRect(350, 0, 1, 1000);
        g.fillRect(250, 0, 1, 1000);
        g.fillRect(150, 0, 1, 1000);
        g.fillRect(50, 0, 1, 1000);
        g.fillRect(0, 50, 1000, 1);
        g.fillRect(0, 150, 1000, 1);
        g.fillRect(0, 250, 1000, 1);
        g.fillRect(0, 350, 1000, 1);
        g.fillRect(0, 450, 1000, 1);
        g.fillRect(0, 550, 1000, 1);
        g.fillRect(0, 650, 1000, 1);
        g.fillRect(0, 750, 1000, 1);
        g.fillRect(0, 850, 1000, 1);
        g.fillRect(0, 950, 1000, 1);

        g.setColor(Color.RED);
        for (int i = 0; i < xCoordinates.length - 1; i ++){
            if(i % 100 == 0){
                 //System.out.println("(" + (int) (xCoordinates[i]) + ", " + (int) (-1 * yCoordinates[i]) + ")");
            }
            g.fillOval((int) (xCoordinates[i] * (50) + 500), (int) (-1 * yCoordinates[i] * 50 + 500), 3, 3);
        }

    }

    public void createCoordinates(double x, double y, int place){
        xCoordinates[place] = x;
        yCoordinates[place] = y;
    }
    


}
