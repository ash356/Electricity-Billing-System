package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admin_Database {

    //---------------Connection Method--------------------------------------
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/ashour", "root", "");
    }

    //---------------get_customers Method--------------------------------------

    public static ArrayList<Domain.admin> get_customers() {
        ArrayList<Domain.admin> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select customers.user_name,bills.status, customers.address,customers.city\n"
                        + "FROM customers,bills where customers.meter_no=bills.meter_no");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new Domain.admin(r.getString("user_name"), r.getString("status"), r.getString("address"), r.getString("city")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //---------------get_stat Method--------------------------------------

    public static ArrayList<Domain.admin> get_stat() {
        ArrayList<Domain.admin> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select * from adminstate");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new Domain.admin(r.getString("district"), r.getInt("cons_rate"), r.getInt("price")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //---------------get_admin Method--------------------------------------

    public static ArrayList<Domain.admin> get_admin() {
        ArrayList<Domain.admin> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select * from  users where role_status='Admin'");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new Domain.admin(r.getString("user_name"), r.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //---------------check_Admin Method--------------------------------------

    public static int check_Admin(String user, String pass) {

        ArrayList<Domain.admin> arr = get_admin();

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
}
