import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FutureValueCalculator extends JFrame {

   //create text fields
   private JTextField jtfInvestment = new JTextField();
   private JTextField jtfNumberOfYears = new JTextField();
   private JTextField jtfAnnIntRate = new JTextField();
   private JTextField jtfFutureValue = new JTextField();
   
   //create "calculate" button
   private JButton jbtCalculate = new JButton("Calculate");
   
   public FutureValueCalculator() {
      //create jpanel and add components
      JPanel p1 = new JPanel(new GridLayout(4, 2));
      p1.add(new JLabel("Investment Amount"));
      p1.add(jtfInvestment);
      p1.add(new JLabel("Years"));
      p1.add(jtfNumberOfYears);
      p1.add(new JLabel("Annual Interest Rate"));
      p1.add(jtfAnnIntRate);
      p1.add(new JLabel("Future value"));
      p1.add(jtfFutureValue);
      
         
        //panel for calculate button 
      JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      p2.add(jbtCalculate);
      
      
      add(p1, BorderLayout.CENTER);
      add(p2, BorderLayout.SOUTH);
      
      
      jbtCalculate.addActionListener(new ButtonListener());
   }
   
   //listener class
   private class ButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         //variables for investment calculations 
         double investment = Double.parseDouble(jtfInvestment.getText());
         int year = Integer.parseInt(jtfNumberOfYears.getText());
         double interestRate = Double.parseDouble(jtfAnnIntRate.getText());
         double futureValue = 0;   
         //investment calculation   
         futureValue = investment * Math.pow((1 + (interestRate/1200)),(year * 12));
         
         
         jtfFutureValue.setText(String.format("%.2f",
            futureValue));
         
       }
     }
     //main method to create a frame
     public static void main(String[] args) {
      FutureValueCalculator frame = new FutureValueCalculator();
      frame.pack();
      frame.setTitle("Exercise 16_5");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      }
    }