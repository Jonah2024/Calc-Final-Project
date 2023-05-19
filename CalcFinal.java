

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalcFinal extends JFrame{

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

        JButton graphButton = new JButton("Graph");
        graphButton.addActionListener(click);
        graphButton.setBounds(1050, 150, 150, 50);
        panel.add(graphButton);
        
        equationInput.addActionListener(click);
        equationInput.setBounds(1025, 100, 250, 35);
        panel.add(equationInput);
   
        Container pane = frame.getContentPane();
        pane.add(panel);
        frame.setVisible(true);

    }

    private class Clicklistener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            graph.setEquation(equationInput.getText());

            for (double i = 0; i < 20000; i ++){
                double x = (i - 10000)/1000;
                panel.createCoordinates(x, graph.Calculate(x, equationInput.getText(), 0)[1], (int)i);
                //System.out.println("Y value: " + graph.Calculate(x, equationInput.getText(), 0)[1]);
            }
            panel.repaint();
            //System.out.print("Calculations done");
        }
    
    }
        

}
