package Panels;

import Domain.admin;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.*;

public final class Operator_Details extends JPanel {

    //---------------Variables--------------------------------------
    JTable table1, table2;
    JScrollPane jsp1, jsp2;
    String data[][];
    String data2[][];
    String header1[] = {"User_Name", "Bill_Amount", "Cash", "Tariff "};
    String header2[] = {"District", "Consumption_Rate", "Price"};

    ArrayList<Domain.operator> arr = DataBase.Operator_Database.get_bill_tariff();
    ArrayList<admin> arr2 = DataBase.Admin_Database.get_stat();

    //---------------Constractor--------------------------------------
    public Operator_Details() {
        this.setLayout(null);
        dipalay();
    }

    //---------------Display Method--------------------------------------
    public void dipalay() {

        this.setSize(710, 710);
        this.setLocation(100, 100);
        this.setVisible(true);

        data = new String[arr.size()][4];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i).getUser_name();
            data[i][1] = "" + arr.get(i).getMeter_number();
            data[i][2] = "" + arr.get(i).getPayment();
            data[i][3] = arr.get(i).getTar();
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
