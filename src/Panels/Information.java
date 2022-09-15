package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Information extends JPanel {

    //---------------Variables--------------------------------------

    JTable table1, table2;
    JScrollPane jsp1, jsp2;
    String data[][];
    String data2[][];
    String header1[] = {"User_Name", "Bill_Status", "Address", "City "};
    String header2[] = {"District", "Consumption_Rate", "Price"};
    ArrayList<Domain.admin> arr = DataBase.Admin_Database.get_customers();
    ArrayList<Domain.admin> arr2 = DataBase.Admin_Database.get_stat();
    //---------------Constractor--------------------------------------

    public Information() {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        dipalay();
    }
//---------------Display Method--------------------------------------

    public void dipalay() {

        data = new String[arr.size()][4];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i).getUser_name();
            data[i][1] = arr.get(i).getBill_status();
            data[i][2] = arr.get(i).getAddress();
            data[i][3] = arr.get(i).getCity();
        }

        table1 = new JTable(data, header1);
        jsp1 = new JScrollPane(table1);
        jsp1.setBounds(0, 0, 350, 900);
        this.add(jsp1);

        data2 = new String[arr2.size()][3];
        for (int i = 0; i < arr2.size(); i++) {
            data2[i][0] = arr2.get(i).getDistrict();
            data2[i][1] = "" + arr2.get(i).getCons_rate();
            data2[i][2] = "" + arr2.get(i).getPrice();
        }

        table2 = new JTable(data2, header2);
        jsp2 = new JScrollPane(table2);
        jsp2.setBounds(350, 0, 350, 900);
        this.add(jsp2);
    }

}
