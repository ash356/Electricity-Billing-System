package Panels;

import DataBase.Users_Database;
import Domain.user;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_User extends JPanel implements ActionListener {

    //---------------Variables--------------------------------------    

    JLabel u_name, pass, r_stat, user_id;
    JTextField user_name, password, role_status, id;
    JButton search_id, update_degree, delete_user;
    ArrayList<user> arr;

    //---------------Constractor--------------------------------------

    public Update_User() {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        //---------------Initializaion Labels-----------------------
        user_id = new JLabel("User ID");
        u_name = new JLabel("User Name");
        pass = new JLabel("Password");
        r_stat = new JLabel("Role Status ");
        user_id.setBounds(50, 30, 250, 30);
        u_name.setBounds(50, 100, 250, 30);
        pass.setBounds(50, 170, 250, 30);
        r_stat.setBounds(50, 240, 250, 30);
        this.add(user_id);
        this.add(u_name);
        this.add(pass);
        this.add(r_stat);
        //--------------Initializaion TextFields---------------------
        id = new JTextField();
        id.setBounds(150, 30, 250, 30);
        user_name = new JTextField();
        user_name.setBounds(150, 100, 250, 30);
        password = new JTextField();
        password.setBounds(150, 170, 250, 30);
        role_status = new JTextField();
        role_status.setBounds(150, 240, 250, 30);

        this.add(id);
        this.add(user_name);
        this.add(password);
        this.add(role_status);

    //---------------Initializaion Buttons-----------------------
        search_id = new JButton("Search ID");
        search_id.setBounds(420, 30, 100, 30);
        search_id.setBackground(Color.ORANGE);
        update_degree = new JButton("Update User");
        update_degree.setBounds(280, 300, 120, 40);
        update_degree.setBackground(Color.CYAN);
        delete_user = new JButton("Delete User ");
        delete_user.setBounds(50, 300, 120, 40);
        delete_user.setBackground(Color.RED);
        this.add(update_degree);
        this.add(delete_user);
        update_degree.addActionListener(this);
        delete_user.addActionListener(this);
        this.add(search_id);
        search_id.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_id) {
            arr = Users_Database.get_user_id(Integer.parseInt(id.getText()));
            user_name.setText(arr.get(0).getUser_name());
            password.setText(arr.get(0).getPassword());
            role_status.setText(arr.get(0).getRole_status());

        }
        if (e.getSource() == update_degree) {
            DataBase.Users_Database.update_user(Integer.parseInt(id.getText()), user_name.getText(), password.getText(), role_status.getText());
            JOptionPane.showMessageDialog(null, "User Updated Successfully ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            user_name.setText("");
            password.setText("");
            role_status.setText("");
        }
        if (e.getSource() == delete_user) {
            DataBase.Users_Database.delete_user(Integer.parseInt(id.getText()));
            JOptionPane.showMessageDialog(null, "User Deleted Successfully ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            user_name.setText("");
            password.setText("");
            role_status.setText("");
        }
    }
}
