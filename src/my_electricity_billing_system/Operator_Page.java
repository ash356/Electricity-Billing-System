package my_electricity_billing_system;

import Panels.Operator_Print;
import Panels.Operator_Details;
import Panels.Logout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Operator_Page extends JFrame {

    //---------------Variables--------------------------------------

    JTabbedPane tab;
    Operator_Print print;
    Operator_Details details;
    Logout logout;

    //---------------Constractor--------------------------------------

    public Operator_Page() {
        tab = new JTabbedPane();
        print = new Operator_Print();
        details = new Operator_Details();
        logout = new Logout();

        show_operator_screen();
    }

    //---------------Method--------------------------------------

    public void show_operator_screen() {

        //---------------Tabbed Pane--------------------------------------
        tab.addTab("Details", details);
        tab.addTab("Print", print);
        tab.addTab("Log Out", logout);
        add(tab);
        //---------------Frame Component------------------------------
        setTitle("Operator Page");
        setSize(725, 900);
        setLocation(450, 90);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
