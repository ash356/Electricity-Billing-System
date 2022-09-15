package Panels;

import DataBase.Customer_Database;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import my_electricity_billing_system.Login_Page;

public class Pay_Bill extends JPanel implements ActionListener {

    //---------------Variables--------------------------------------
    JLabel title, meter, month, bil, bill, cashh, bill_month;
    //Choice c1;
    double j;
    int number;
    String stat;
    JTextField meter_no, cash;
    JButton calculate, pay;
    //---------------Constractor--------------------------------------

    public Pay_Bill() throws SQLException {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        number = get_meter_no();
        //---------------Initializaion Labels-----------------------
        title = new JLabel("Electricity Bill");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(150, 20, 400, 30);
        meter = new JLabel("Meter No");
        month = new JLabel("Month");
        bil = new JLabel("Your Bill ");
        bill = new JLabel("");
        cashh = new JLabel("Cash Amount");
        meter.setBounds(50, 150, 150, 30);
        month.setBounds(50, 350, 100, 30);
        bil.setBounds(50, 250, 150, 30);
        bill.setBounds(150, 250, 150, 30);
        cashh.setBounds(50, 450, 150, 30);
        this.add(title);
        this.add(month);
        this.add(cashh);
        this.add(meter);
        this.add(bil);
        this.add(bill);
//        //--------------Initializaion Choice--------------------
//        c1 = new Choice();
//        c1.setBounds(150, 350, 250, 20);
//        c1.add("January");
//        c1.add("February");
//        c1.add("March");
//        c1.add("April");
//        c1.add("May");
//        c1.add("June");
//        c1.add("July");
//        c1.add("August");
//        c1.add("September");
//        c1.add("October");
//        c1.add("November");
//        c1.add("December");
//        add(c1);
        bill_month = new JLabel("");
        bill_month.setBounds(150, 350, 250, 20);
        add(bill_month);
        //--------------Initializaion TextFields---------------------
        meter_no = new JTextField();
        meter_no.setBounds(150, 150, 250, 30);
        cash = new JTextField();
        cash.setBounds(150, 450, 250, 30);
        this.add(meter_no);
        this.add(cash);
        //---------------Initializaion Buttons-----------------------
        calculate = new JButton("Calculate");
        calculate.setBounds(450, 150, 150, 30);
        calculate.setBackground(Color.GREEN);
        calculate.setForeground(Color.BLUE);
        pay = new JButton("Pay Bill");
        pay.setBounds(450, 460, 150, 60);
        pay.setBackground(Color.CYAN);
        pay.setForeground(Color.BLACK);
        this.add(calculate);
        this.add(pay);
        calculate.addActionListener(this);
        pay.addActionListener(this);
        //---------------to convert meter number to string  --------------------------------------
        String s = String.valueOf(number);
        meter_no.setText(s);
    }

    //---------------get_meter_no Method--------------------------------------

    public static int get_meter_no() throws SQLException {
        int result = new Login_Page().get_meter_no();
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pay) {
            if (cash.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You haven't entered anything", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                //String user = c1.getSelectedItem();
                try {
                    String month_bill = Customer_Database.select_month_bill(Integer.parseInt(meter_no.getText()));
                    Customer_Database.update_bill_status(Integer.parseInt(meter_no.getText()), month_bill);
                    JOptionPane.showMessageDialog(null, "Bill Paid Successfully * " + meter.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        if (e.getSource() == calculate) {
            try {
                int new_reading = Customer_Database.select_new_reading(Integer.parseInt(meter_no.getText()));
                System.out.println(new_reading);

                int old_reading = Customer_Database.select_old_reading(Integer.parseInt(meter_no.getText()));
                System.out.println(old_reading);

                double difference_reading = new_reading - old_reading;
                System.out.println(difference_reading);
                double i = difference_reading;
                Customer_Database.update_new_reading(Integer.parseInt(meter_no.getText()));
                Customer_Database.update_old_reading(Integer.parseInt(meter_no.getText()), new_reading);
                String month_bill = Customer_Database.select_month_bill(Integer.parseInt(meter_no.getText()));
                //----------------------------------------------------------------------------
                //first
                if (i >= 0 && i <= 50) {
                    j = (i * 0.38);
                } //second
                else if (i >= 51 && i <= 100) {
                    j = (50 * 0.38 + (i - 50) * 48);
                } //third
                else if (i >= 101 && i <= 200) {
                    j = (i * 0.65);
                } //fourth
                else if (i >= 201 && i <= 350) {
                    j = (200 * 0.65 + (i - 200) * 0.96);
                } //fifth
                else if (i >= 351 && i <= 650) {
                    j = (200 * 0.65 + 150 * 0.96 + (i - 350) * 1.18);
                } //sixth
                else if (i >= 651 && i <= 1000) {
                    j = (i * 1.18);
                } //seventh
                else if (i > 1001) {
                    j = (i * 1.45);
                }

                String s = String.valueOf(j);
                bill.setText(s);
                bill_month.setText(month_bill);// to put month value in label 
            } catch (SQLException ee) {  // (NumberFormatException ee)
                System.out.println(ee.getMessage());
            }
        }
    }

}
