package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Domain.operator;

public class Operator_Database {

    //---------------Connection Method--------------------------------------

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/ashour", "root", "");
    }

    //---------------get_operator Method--------------------------------------
    public static ArrayList<operator> get_operator() {
        ArrayList<operator> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select * from  users where role_status = 'Operator'");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new operator(r.getString("user_name"), r.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //---------------check_operator Method--------------------------------------

    public static int check_operator(String user, String pass) {

        ArrayList<operator> arr = get_operator();

        int x = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getUser().equals(user)) {
                if (arr.get(i).getPass().equals(pass)) {
                    //pass is correct
                    x = 1;
                    break;
                } else {
                    //username is correct
                    x = 2;
                    break;
                }
            } else {
                //wrong
                x = 0;
            }
        }
        return x;
    }

    //---------------get_bill_print Method--------------------------------------
    public static ArrayList<operator> get_bill_print() {
        ArrayList<operator> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("SELECT customers.user_name, customers.meter_no, customer_pay.payment\n"
                        + "FROM customers,customer_pay\n"
                        + "WHERE customers.meter_no=customer_pay.meter_no");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new operator(r.getString("user_name") + "", r.getInt("meter_no"), r.getInt("payment")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //---------------get_bill_tariff Method--------------------------------------

    public static ArrayList<operator> get_bill_tariff() {
        ArrayList<operator> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("SELECT customers.user_name, customers.meter_no, customer_pay.payment,customer_pay.tariff\n"
                        + "FROM customers,customer_pay\n"
                        + "WHERE customers.meter_no=customer_pay.meter_no");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new operator(r.getString("user_name"), r.getInt("meter_no"), r.getInt("payment"), r.getString("tariff")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
