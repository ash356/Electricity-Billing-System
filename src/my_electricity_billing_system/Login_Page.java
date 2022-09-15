package my_electricity_billing_system;

import DataBase.Admin_Database;
import DataBase.Customer_Database;
import DataBase.Operator_Database;
import static DataBase.Users_Database.get_users;
import Domain.user;
import Images.Image1;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_Page extends JFrame implements ActionListener {

    //---------------Variables--------------------------------------

    Image1 ii = new Image1();
    JLabel user, pass, log_as, made;
    static JTextField user_name;
    static JPasswordField password;
    JButton signin, signup;
    Choice choose;

    //---------------Constractor--------------------------------------

    public Login_Page() {

    }

    //---------------Method--------------------------------------

    public void show_first_screen() {
        //---------------Initializaion Labels------------------------
        user = new JLabel("Username");
        pass = new JLabel("Password");
        log_as = new JLabel("Log AS");
        made = new JLabel("Made By : EL Hackers ");
        user.setBounds(50, 40, 150, 30);
        pass.setBounds(50, 100, 150, 30);
        log_as.setBounds(50, 160, 100, 30);
        made.setBounds(100, 600, 300, 100);
        ii.add(user);
        ii.add(pass);
        ii.add(log_as);
        ii.add(made);
        //--------------Initializaion TextFields---------------------
        user_name = new JTextField();
        user_name.setBounds(150, 40, 250, 30);
        password = new JPasswordField();
        password.setBounds(150, 100, 250, 30);
        ii.add(user_name);
        ii.add(password);
        //--------------Initializaion Choice---------------------
        choose = new Choice();
        choose.add("SELECT");
        choose.add("Admin");
        choose.add("Customer");
        choose.add("Operator");
        choose.setBounds(150, 160, 250, 2);
        choose.setFont(new Font("Tahoma", Font.BOLD, 14));
        ii.add(choose);
        //--------------Initializaion Buttons------------------------
        signin = new JButton("Sign In");
        signup = new JButton("Sign Up");
        signin.setBounds(150, 220, 80, 50);
        signup.setBounds(320, 220, 80, 50);
        signin.setBackground(Color.CYAN);
        signup.setBackground(Color.GREEN);
        ii.add(signin);
        ii.add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);
        //---------------Frame Component------------------------------ 
        setTitle("Login Page");
        setSize(600, 755);
        setLocation(700, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(ii);
        

    }
    //----------------------------------------------------------------------------------------------
    public static int get_meter_no() throws SQLException {
         int result = Customer_Database.select_meter_no(user_name.getText(), password.getText());
        return result; 
    }
    
//----------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signin) {
            String user = choose.getSelectedItem();
            ArrayList<user> arr = get_users();
            if (user.equals("Admin")) {
                int output = Admin_Database.check_Admin(user_name.getText(), password.getText());

                if (output == 1) {
                    JOptionPane.showMessageDialog(null, "Welcome Admin  " + user_name.getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Admin_Page().show_admin_screen();
                } else if (output == 2) {
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User " + user_name.getText() + " Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (user.equals("Operator")) {
                int output = Operator_Database.check_operator(user_name.getText(), password.getText());
                if (output == 1) {
                    JOptionPane.showMessageDialog(null, "Welcome Operator " + user_name.getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Operator_Page().show_operator_screen();
                } else if (output == 2) {
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User " + user_name.getText() + " Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (user.equals("Customer")) {
                int output = Customer_Database.check_customer(user_name.getText(), password.getText());
                if (output == 1) {
                    JOptionPane.showMessageDialog(null, "Welcome Customer  " + user_name.getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    try {
                        new Customer_Page().show_customer_screen();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login_Page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (output == 2) {
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User " + user_name.getText() + " Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, " Select A Valid User !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == signup) {
            this.dispose(); // to close frame (Login page)
            new Signup_Page().show_signup_screen(); // to open (signup) frame 
        }
    }

}
