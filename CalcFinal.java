

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.apache.commons.math4.legacy.analysis.differentiation.*;

public class CalcFinal extends JFrame{

    private int n = 0;
    private int p = 65;
    private String equationString = "T(x) =";
    JTextField nText = new JTextField("N = " + n);
    JTextField equationText = new JTextField("T(x) = ");

    Clicklistener click = new Clicklistener();
    SimpleGraph graph = new SimpleGraph();

    private ColorPanel panel = new ColorPanel();
    JTextField equationInput = new JTextField();

    public static void main(String[] args) throws Exception {
        new CalcFinal();
    }

    public CalcFinal(){
        
        JFrame frame = new JFrame("Graph");
        frame.setSize(1300, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.WHITE);
        panel.setSize(1300, 1000);
        panel.setLayout(null); 

        equationInput.addActionListener(click);
        equationInput.setActionCommand("graph");
        equationInput.setBounds(1075, 100, 150, 35);
        panel.add(equationInput);

        JButton graphButton = new JButton("Graph");
        graphButton.addActionListener(click);
        graphButton.setActionCommand("graph");
        graphButton.setBounds(1075, 150, 150, 50);
        panel.add(graphButton);

        nText.setBounds(1125, 275, 75, 25);
        nText.setEditable(false);
        panel.add(nText);

        JButton nPlus = new JButton("n+");
        nPlus.addActionListener(click);
        nPlus.setActionCommand("n+");
        nPlus.setBounds(1075, 300, 75, 50);
        panel.add(nPlus);

        JButton nMinus = new JButton("n-");
        nMinus.addActionListener(click);
        nMinus.setActionCommand("n-");
        nMinus.setBounds(1150, 300, 75, 50);
        panel.add(nMinus);

        JButton deriveButton = new JButton("Show Series");
        deriveButton.addActionListener(click);
        deriveButton.setActionCommand("derive");
        deriveButton.setBounds(1075, 350, 150, 50);
        panel.add(deriveButton);
        
        equationText.setBounds(50, 50, p, 25);
        equationText.setEditable(false);
        panel.add(equationText);
   
        Container pane = frame.getContentPane();
        pane.add(panel);
        frame.setVisible(true);
    }

    private class Clicklistener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            Derivitive derive = new Derivitive();

            // if the graph button or a new equation is entered - resets everything
            if (e.getActionCommand().equals("graph")){
                n = 0;
                equationString = "T(x) =";
                double a = derive.derive(equationInput.getText(), n);
                if (a >= 0) equationString = equationString + " + " + (int) a + "(x)^" + n + " /" + n + "! " ;
                else equationString = equationString + " - " + -1 * (int) a + "(x)^" + n + " /" + n + "! ";
                p = 20 + equationString.length() * 6;
                p = 25 + equationString.length() * 6; 
                equationText.setBounds(50, 50, p, 25);
                equationText.setText(equationString);
                graph.setEquation(equationInput.getText());
                nText.setText("N = " + n);
            for (double i = 0; i < 20000; i ++){
                double x = (i - 10000)/1000;
                panel.createCoordinates(x, graph.Calculate(x, equationInput.getText(), 0)[1], (int)i);
            }
            panel.createSeries(equationInput.getText(), n);
            panel.repaint();
            }
            //increases number of taylor terms
            else if (e.getActionCommand().equals("n+")){
                n ++;
                double a = derive.derive(equationInput.getText(), n);
                nText.setText("N = " + n);
                if (a >= 0) equationString = equationString + " + " + (int) a + "(x)^" + n + " /" + n + "! " ;
                else equationString = equationString + " - " + -1 * (int) a + "(x)^" + n + " /" + n + "! ";
                p = 20 + equationString.length() * 6;
                equationText.setBounds(50, 50, p, 25);
                equationText.setText(equationString);
                panel.createSeries(equationInput.getText(), n);
                panel.repaint();
            }
            //decreases number of taylor terms
            else if (e.getActionCommand().equals("n-") && n > 0){
                double a = derive.derive(equationInput.getText(), n);

                int length = equationString.indexOf(" + " + (int) a + "(x)^" + n + " /" + n + "! ", 0);
                if (length == -1) length = equationString.indexOf(" - " + - 1 * (int) a + "(x)^" + n + " /" + n + "! ", 0);
                equationString = equationString.substring(0, length);
                p = 20 + equationString.length() * 6;
                equationText.setBounds(50, 50, p, 25);
                equationText.setText(equationString);
                n --;
                nText.setText("N = " + n);
                panel.createSeries(equationInput.getText(), n);
                panel.repaint();
            }
            else if (e.getActionCommand().equals("derive")){
                panel.createSeries(equationInput.getText(), n);
                panel.repaint();
            }
        }
    }
}
