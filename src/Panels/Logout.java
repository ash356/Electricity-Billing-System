package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import my_electricity_billing_system.Login_Page;

public class Logout extends JPanel implements ActionListener {

    //---------------Variables--------------------------------------

    JButton log;

    //---------------Constractor--------------------------------------

    public Logout() {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        close_page();
    }

    //---------------Method--------------------------------------

    public void close_page() {
        //---------------Initializaion Buttons-----------------------
        log = new JButton("LOG OUT");
        log.setBounds(350, 250, 300, 100);
        log.setBackground(Color.RED);
        log.setForeground(Color.BLACK);
        this.add(log);
        log.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log) {

            getTopLevelAncestor().setVisible(false);  // to close frame    
            // System.exit(0);
            new Login_Page().show_first_screen();;

        }
    }
}
