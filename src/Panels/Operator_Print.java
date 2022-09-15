package Panels;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public final class Operator_Print extends JPanel implements ActionListener {

    //---------------Variables--------------------------------------
    JButton print;
    JTable table;
    JScrollPane jsp;
    String data[][];
    String header[] = {"User_Name", "Bill_Amount", "Cash"};
    ArrayList<Domain.operator> arr;
//---------------Constractor--------------------------------------

    public Operator_Print() {

        this.setLayout(null);
        dipalay();
    }
//---------------Display Method--------------------------------------

    public void dipalay() {
        arr = DataBase.Operator_Database.get_bill_print();
        data = new String[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i).getUser_name();
            data[i][1] = "" + arr.get(i).getMeter_number();
            data[i][2] = "" + arr.get(i).getPayment();
        }

        table = new JTable(data, header);
        jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 350, 900);
        add(jsp);

        print = new JButton("Print");
        print.setBounds(410, 200, 250, 80);
        add(print);
        print.setBackground(Color.GREEN);
        print.setForeground(Color.BLUE);
        print.addActionListener(this);

        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        MessageFormat m = new MessageFormat("Customer Bill");
        MessageFormat f = new MessageFormat("page[1]");

        try {
            table.print(JTable.PrintMode.NORMAL, m, f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
