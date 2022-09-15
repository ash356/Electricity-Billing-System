package Panels;

import DataBase.Customer_Database;
import DataBase.Users_Database;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class Add extends JPanel implements ActionListener {

    //---------------Variables--------------------------------------

    JLabel userr, pass, num, add, meter, random, i, emal, cit, att;
    JTextField user_name, password, number, address, id, email, city, attach;
    JButton admin, customer, operator, button;
    Choice choose;

    //---------------Constractor--------------------------------------

    public Add() {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        //--------------Initializaion Choice---------------------
        choose = new Choice();
        choose.add("SELECT");
        choose.add("Admin");
        choose.add("Customer");
        choose.add("Operator");
        choose.setBounds(500, 30, 150, 70);
        this.add(choose);
        //---------------Initializaion Labels-----------------------
        userr = new JLabel("Username");
        pass = new JLabel("Password");
        i = new JLabel("National ID");
        num = new JLabel("Phone Number");
        add = new JLabel("Address");
        emal = new JLabel("Email");
        cit = new JLabel("City");
        meter = new JLabel("Meter No");
        att = new JLabel("Attach Contract");
        att.setBounds(50, 480, 150, 30);
        random = new JLabel();
        userr.setBounds(50, 50, 150, 30);
        pass.setBounds(50, 100, 150, 30);
        i.setBounds(50, 230, 150, 30);
        num.setBounds(50, 280, 150, 30);
        add.setBounds(50, 330, 200, 30);
        emal.setBounds(50, 380, 150, 30);
        cit.setBounds(50, 430, 150, 30);
        meter.setBounds(50, 180, 200, 30);
        random.setBounds(150, 180, 150, 30);
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        random.setText("" + Math.abs(first));
        this.add(num);
        this.add(userr);
        this.add(pass);
        this.add(i);
        this.add(add);
        this.add(add);
        this.add(meter);
        this.add(random);
        this.add(emal);
        this.add(cit);
        this.add(att);
        //--------------Initializaion TextFields---------------------
        user_name = new JTextField();
        user_name.setBounds(150, 50, 250, 30);
        password = new JTextField();
        password.setBounds(150, 100, 250, 30);
        id = new JTextField();
        id.setBounds(150, 230, 250, 30);
        number = new JTextField();
        number.setBounds(150, 280, 250, 30);
        address = new JTextField();
        address.setBounds(150, 330, 250, 30);
        email = new JTextField();
        email.setBounds(150, 380, 250, 30);
        city = new JTextField();
        city.setBounds(150, 430, 250, 30);
        attach = new JTextField();
        attach.setBounds(150, 480, 250, 30);
        this.add(user_name);
        this.add(password);
        this.add(id);
        this.add(number);
        this.add(address);
        this.add(email);
        this.add(city);
        this.add(attach);
        //---------------Initializaion Buttons-----------------------
        admin = new JButton("Add Admin");
        admin.setBounds(500, 100, 150, 50);
        admin.setBackground(Color.GREEN);
        customer = new JButton("Add Customer");
        customer.setBounds(500, 300, 150, 50);
        customer.setBackground(Color.DARK_GRAY);
        customer.setForeground(Color.CYAN);
        operator = new JButton("Add Operator");
        operator.setBounds(500, 200, 150, 50);
        operator.setBackground(Color.DARK_GRAY);
        operator.setForeground(Color.CYAN);
        this.add(admin);
        this.add(operator);
        this.add(customer);
        admin.addActionListener(this);
        operator.addActionListener(this);
        customer.addActionListener(this);
         //------------attatch button ---------------------------------------------------

        button = new JButton("Select File");
        button.addActionListener(this);
        button.setBounds(500, 480, 100, 30);
        this.add(button);

        //---------------Initializaion Image-----------------------
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/image3.jpg"));
        Image image2 = image1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 530, 700, 280);
        this.add(image);
        //--------Default Un Visable-----------------------------------------------
        userr.setVisible(false);
        pass.setVisible(false);
        admin.setVisible(false);
        customer.setVisible(false);
        operator.setVisible(false);
        user_name.setVisible(false);
        password.setVisible(false);
        i.setVisible(false);
        id.setVisible(false);
        meter.setVisible(false);
        random.setVisible(false);
        num.setVisible(false);
        number.setVisible(false);
        add.setVisible(false);
        address.setVisible(false);
        emal.setVisible(false);
        email.setVisible(false);
        cit.setVisible(false);
        city.setVisible(false);
        attach.setVisible(false);
        att.setVisible(false);
        button.setVisible(false);
        //---------Choice Check-----------------------------------------------------
        choose.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = choose.getSelectedItem();
                if (user.equals("Customer")) {
                    customer.setVisible(true);
                    admin.setVisible(false);
                    operator.setVisible(false);
                    meter.setVisible(true);
                    random.setVisible(true);
                    num.setVisible(true);
                    number.setVisible(true);
                    add.setVisible(true);
                    address.setVisible(true);
                    i.setVisible(true);
                    id.setVisible(true);
                    emal.setVisible(true);
                    email.setVisible(true);
                    cit.setVisible(true);
                    city.setVisible(true);
                    userr.setVisible(true);
                    pass.setVisible(true);
                    user_name.setVisible(true);
                    password.setVisible(true);
                    attach.setVisible(true);
                    att.setVisible(true);
                    button.setVisible(true);

                } else if (user.equals("Admin")) {
                    admin.setVisible(true);
                    customer.setVisible(false);
                    operator.setVisible(false);
                    i.setVisible(true);
                    id.setVisible(true);
                    userr.setVisible(true);
                    pass.setVisible(true);
                    user_name.setVisible(true);
                    password.setVisible(true);
                    meter.setVisible(false);
                    random.setVisible(false);
                    num.setVisible(false);
                    number.setVisible(false);
                    add.setVisible(false);
                    address.setVisible(false);
                    emal.setVisible(false);
                    email.setVisible(false);
                    cit.setVisible(false);
                    city.setVisible(false);
                    attach.setVisible(false);
                    att.setVisible(false);
                    button.setVisible(false);
                } else if (user.equals("Operator")) {
                    operator.setVisible(true);
                    admin.setVisible(false);
                    customer.setVisible(false);
                    i.setVisible(true);
                    id.setVisible(true);
                    userr.setVisible(true);
                    pass.setVisible(true);
                    user_name.setVisible(true);
                    password.setVisible(true);
                    meter.setVisible(false);
                    random.setVisible(false);
                    num.setVisible(false);
                    number.setVisible(false);
                    add.setVisible(false);
                    address.setVisible(false);
                    emal.setVisible(false);
                    email.setVisible(false);
                    cit.setVisible(false);
                    city.setVisible(false);
                    attach.setVisible(false);
                    att.setVisible(false);
                    button.setVisible(false);
                } else {
                    admin.setVisible(false);
                    customer.setVisible(false);
                    operator.setVisible(false);
                    meter.setVisible(false);
                    random.setVisible(false);
                    num.setVisible(false);
                    number.setVisible(false);
                    add.setVisible(false);
                    address.setVisible(false);
                    i.setVisible(false);
                    id.setVisible(false);
                    emal.setVisible(false);
                    email.setVisible(false);
                    cit.setVisible(false);
                    city.setVisible(false);
                    userr.setVisible(false);
                    pass.setVisible(false);
                    user_name.setVisible(false);
                    password.setVisible(false);
                    attach.setVisible(false);
                    att.setVisible(false);
                    button.setVisible(false);

                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin) {
            try {
                Users_Database.insert_user_data(Integer.parseInt(id.getText()), user_name.getText(), password.getText(), choose.getSelectedItem());
                JOptionPane.showMessageDialog(null, " Added Successfully * " + user_name.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == customer) {
            try {
                Customer_Database.insert_customer_data(Integer.parseInt(random.getText()), user_name.getText(), password.getText(), Integer.parseInt(id.getText()), Integer.parseInt(number.getText()), address.getText(), email.getText(), city.getText(), attach.getText());
                Users_Database.insert_user_data(Integer.parseInt(id.getText()), user_name.getText(), password.getText(), choose.getSelectedItem());
                LocalDateTime currentDate = LocalDateTime.now();
                Customer_Database.insert_bill_status(Integer.parseInt(random.getText()), "" + currentDate);
                Customer_Database.add_fiest_reading(Integer.parseInt(random.getText()));
                JOptionPane.showMessageDialog(null, "Customer Added Successfully * " + user_name.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == operator) {
            try {

                Users_Database.insert_user_data(Integer.parseInt(id.getText()), user_name.getText(), password.getText(), choose.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Operator Added Successfully * " + user_name.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == button) {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new java.io.File(".")); //sets current directory

            int response = fileChooser.showOpenDialog(null); //select file to open
            //int response = fileChooser.showSaveDialog(null); //select file to save

            if (response == JFileChooser.APPROVE_OPTION) {
                java.io.File file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
                attach.setText("" + file);
                System.out.println(file);// in out put
            }
        }
    }
}
