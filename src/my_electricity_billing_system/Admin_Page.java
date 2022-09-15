package my_electricity_billing_system;

import Panels.Information;
import Panels.Add;
import Panels.Logout;
import Panels.Update_User;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Admin_Page extends JFrame {

    //---------------Variables--------------------------------------

    JTabbedPane tab;

    //---------------Constractor--------------------------------------

    public Admin_Page() {

    }

    //---------------Method--------------------------------------

    public void show_admin_screen() {

        //---------------Tabbed Pane--------------------------------------
        Add add = new Add();
        Information info = new Information();
        Update_User uuu = new Update_User();
        Logout logout = new Logout();
        tab = new JTabbedPane();
        tab.addTab("Information", info);
        tab.addTab("Add", add);
        tab.addTab("Update User", uuu);
        tab.addTab("Log Out", logout);
        add(tab);
        //---------------Frame Component------------------------------
        setTitle("Admin Page");
        setSize(725, 900);
        setLocation(450, 90);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
