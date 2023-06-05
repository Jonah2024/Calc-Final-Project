
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{

    //stores coordinates
    double[] xCoordinates = new double[20000];
    double[] yCoordinates = new double[20000];
    double[] xCoordinatesSeries = new double[20000];
    double[] yCoordinatesSeries = new double[20000];
    

    public void paintComponent(Graphics g) {

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

        g.drawString("0", 480, 515);
        g.drawString("-1", 480, 565);
        g.drawString("-2", 480, 615);
        g.drawString("-3", 480, 665);
        g.drawString("-4", 480, 715);
        g.drawString("-5", 480, 765);
        g.drawString("-6", 480, 815);
        g.drawString("-7", 480, 865);
        g.drawString("-8", 480, 915);
        g.drawString("-9", 480, 965);
        g.drawString("-10", 480, 1015);

        g.drawString("1", 490, 465);
        g.drawString("2", 490, 415);
        g.drawString("3", 490, 365);
        g.drawString("4", 490, 315);
        g.drawString("5", 490, 265);
        g.drawString("6", 490, 215);
        g.drawString("7", 490, 165);
        g.drawString("8", 490, 115);
        g.drawString("9", 490, 65);
        g.drawString("10", 480, 15);

        g.drawString("-1", 430, 515);
        g.drawString("-2", 380, 515);
        g.drawString("-3", 330, 515);
        g.drawString("-4", 280, 515);
        g.drawString("-5", 230, 515);
        g.drawString("-6", 180, 515);
        g.drawString("-7", 130, 515);
        g.drawString("-8", 80, 515);
        g.drawString("-9", 30, 515);

        g.drawString("1", 540, 515);
        g.drawString("2", 590, 515);
        g.drawString("3", 640, 515);
        g.drawString("4", 690, 515);
        g.drawString("5", 740, 515);
        g.drawString("6", 790, 515);
        g.drawString("7", 840, 515);
        g.drawString("8", 890, 515);
        g.drawString("9", 940, 515);
        g.drawString("10", 980, 515);

        //draws f(x) graph
        g.setColor(Color.RED);
        for (int i = 0; i < xCoordinates.length - 1; i ++){
            g.fillOval((int) (xCoordinates[i] * (50) + 500), (int) (-1 * yCoordinates[i] * 50 + 500), 3, 3);
        }

        //draws taylor series graph
        g.setColor(Color.BLUE);
        for (int i = 0; i < xCoordinates.length - 1; i ++){
            g.fillOval((int) (xCoordinatesSeries[i] * (50) + 500), (int) (-1 * yCoordinatesSeries[i] * 50 + 500), 2, 2);
        }

    }

    //puts f(x) coordinates into their list
    public void createCoordinates(double x, double y, int place){
        xCoordinates[place] = x;
        yCoordinates[place] = y;
    }

    //creates coordinates for a taylor series with N terms
    public void createSeries(String equation, int order){
        //clears previous coordinates
        for (int i = 0; i < xCoordinatesSeries.length; i ++){
            xCoordinatesSeries[i] = 0;
            yCoordinatesSeries[i] = 0;
        }
        Derivitive derive = new Derivitive();
        for (int i = 0; i <= order; i ++){
            double a = derive.derive(equation, i);
            int factorial = 1;
            for (int f = 1; f <= i; f ++){
                factorial = factorial * f;
            }
            for (int j = 0; j < 20000; j ++){
                double x = (j - 10000.0)/1000.0;
                xCoordinatesSeries[j] = x;
                yCoordinatesSeries[j] = yCoordinatesSeries[j] + ((a / factorial) * Math.pow(x, i));
            }
        }
        repaint();
    }
}
