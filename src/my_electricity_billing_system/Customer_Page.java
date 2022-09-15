package my_electricity_billing_system;

import Panels.Logout;
import Panels.Pay_Bill;
import Panels.Send;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Customer_Page extends JFrame {

    //---------------Variables--------------------------------------

    JTabbedPane tab;

    //---------------Constractor--------------------------------------

    public Customer_Page() {

    }

    //---------------Method--------------------------------------

    public void show_customer_screen() throws SQLException {

        //---------------Tabbed Pane--------------------------------------
        Send send = new Send();

        Pay_Bill pay = new Pay_Bill();
        Logout logout = new Logout();
        tab = new JTabbedPane();
        tab.addTab("Send", send);
        tab.addTab("Pay Bill", pay);
        tab.addTab("Log Out", logout);
        add(tab);
        //---------------Frame Component------------------------------
        setTitle("Customer Page");
        setSize(725, 900);
        setLocation(450, 90);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
