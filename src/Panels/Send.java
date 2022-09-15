
package Panels;

import DataBase.Customer_Database;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;
import my_electricity_billing_system.Login_Page;

public class Send extends JPanel implements ActionListener{
    //---------------Variables--------------------------------------
    int number ;
    JLabel meter , read ,comp,month ;
    JTextField meter_no ,reading   ;
    JTextArea complain; 
   JButton add_reading ,send_complain ; 
   Choice c1;
    //---------------Constractor--------------------------------------
public Send() throws SQLException{
        this.setLayout(null);
        this.setBackground(Color.GRAY); 
        number = get_meter_no();
    
    //---------------Initializaion Labels-----------------------
        meter = new JLabel("Meter No");
        read = new JLabel("Reading ");  
        comp = new JLabel("Complain ");  
        month = new JLabel("Month");
        meter.setBounds(50, 50, 150, 30);
        read.setBounds(50, 250, 150, 30);
        month.setBounds(50, 150, 100, 30);
        comp.setBounds(50, 350, 150, 30);
        this.add(meter);this.add(month);
        this.add(read);this.add(comp);
        //--------------Initializaion TextFields---------------------
        meter_no = new JTextField();
        meter_no.setBounds(150, 50, 250, 30);
        reading = new JTextField();
        reading.setBounds(150, 250, 250, 30);
        complain = new JTextArea();
        complain.setBounds(150, 350, 250, 250);
        this.add(meter_no);
        this.add(reading);this.add(complain);
        //---------------Initializaion Buttons-----------------------
        add_reading = new JButton("Add Reading");
        add_reading.setBounds(450,250, 150, 30);
        add_reading.setBackground(Color.GREEN);
        add_reading.setForeground(Color.BLUE);
        send_complain = new JButton("Send Complain");
        send_complain.setBounds(450,560, 150, 30);
        send_complain.setBackground(Color.red);
        send_complain.setForeground(Color.BLACK);
        this.add(add_reading);this.add(send_complain);
        add_reading.addActionListener(this);send_complain.addActionListener(this);
        
        //--------------Initializaion Choice--------------------
        c1 = new Choice();
        c1.setBounds(150, 150, 250, 20);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        this.add(c1);
        
  //---------------to convert meter number to string value --------------------------------------
        String s = String.valueOf(number);
        meter_no.setText(s);
}
//---------------get_meter_no Method--------------------------------------
    public static int get_meter_no() throws SQLException {
       int result = new Login_Page().get_meter_no() ;
       return result ;
    }
       
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()== add_reading) {
            try { 
                    if (reading.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(null, "You haven't entered reading", "ERROR", JOptionPane.ERROR_MESSAGE);
                   }
                    else{
                       Customer_Database.add_reading(Integer.parseInt(meter_no.getText()),Integer.parseInt(reading.getText()),c1.getSelectedItem());
                    
                    JOptionPane.showMessageDialog(null, "Reading Added Successfully For: "+meter_no.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
                     
                    }
                    
                } catch (SQLException ex) {
                   System.out.println(ex.getMessage()); 
            }
        }
          
         if (e.getSource()== send_complain) {
            try { 
                    if (complain.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(null, "You haven't entered anything", "ERROR", JOptionPane.ERROR_MESSAGE);
                   }
                    else{
                      Customer_Database.send_complain(Integer.parseInt(meter_no.getText()),complain.getText());
                    JOptionPane.showMessageDialog(null, "Complain Added Successfully For: "+meter_no.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
                      
                    }
                    
                } catch (SQLException ex) {
                   System.out.println(ex.getMessage()); 
            }
        }
         
    }
    
}
