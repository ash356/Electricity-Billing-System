package DataBase;

import Domain.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users_Database {

    //---------------Constractor--------------------------------------

    public Users_Database() {

    }

    //---------------Connection Method--------------------------------------

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/ashour", "root", "");
    }

    //---------------insert_user_data Method--------------------------------------

    public static void insert_user_data(int user_id, String user_name, String password, String role_status) throws SQLException {
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("insert into users values(?,?,?,?)");) {
            p.setInt(1, user_id);
            p.setString(2, user_name);
            p.setString(3, password);
            p.setString(4, role_status);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //---------------get_users Method--------------------------------------

    public static ArrayList<user> get_users() {
        ArrayList<user> list = new ArrayList<user>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select * from users ");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new user(r.getInt("user_id"), r.getString("user_name"), r.getString("password"), r.getString("role_Status")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
//     //---------------Check Method--------------------------------------
//    public static int check_user(String user, String pass,String role_Status) {
//        ArrayList<user> arr = get_users();
//        int x = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i).getUser_name().equals(user)) {
//                if (arr.get(i).getPassword().equals(pass)) {
//                    x = 1;
//                    break;
//                } else {
////                JOptionPane.showMessageDialog(null,"Wrong Password","Error",JOptionPane.ERROR);
//                    x = 2;
//                    break;
//                }
//            } else {
////                JOptionPane.showMessageDialog(null,"User No Found !","Error",JOptionPane.ERROR);
//                x = 0;
//            }
//        }
//        return x;
//    }
    //---------------get_user_id Method--------------------------------------

    public static ArrayList<user> get_user_id(int id) {
        ArrayList<user> list = new ArrayList<user>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select * from  users where user_id =? ");) {
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new user(r.getInt("user_id"), r.getString("user_name"), r.getString("password"), r.getString("role_status")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    //---------------update_user Method--------------------------------------

    public static void update_user(int id, String user_name, String password, String role_status) {
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("update users set  user_name =? , password=? , role_status=? where user_id =?");) {
            p.setString(1, user_name);
            p.setString(2, password);
            p.setString(3, role_status);
            p.setInt(4, id);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //---------------delete_user Method--------------------------------------

    public static void delete_user(int id) {
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("delete from users where user_id =?");) {
            p.setInt(1, id);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//          //---------------update_bill_data Method--------------------------------------
//          public static void update_bill_data( int reading ) throws SQLException {
//        try (
//            Connection c = connect();
//            PreparedStatement p = c.prepareStatement("update monthly_reading set new_reading=? ");){
//            p.setInt(1, reading);
//            p.execute();
//                
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//          }
//          //---------------calculate_bill_data Method--------------------------------------
//         public static void calculate_bill_data( int meter_no ) throws SQLException {
//        try (
//            Connection c = connect();
//            PreparedStatement p = c.prepareStatement("update monthly_reading set old_reading=? ");){
//            p.setInt(1, meter_no);
//            p.execute();
//                
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

}
