
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Customer_Database {
     //---------------Constractor--------------------------------------
    public Customer_Database(){
        
    }
    //---------------Connection Method--------------------------------------
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/ashour", "root", "");
    }
    //---------------Insert Method--------------------------------------
    public static void insert_customer_data(int meter_no ,String user, String pass, int national_id ,int phone , String addr, String email ,String city ,String attach) throws SQLException {
        try (
            Connection c = connect();
            PreparedStatement p = c.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?,?)");){
            p.setInt(1, meter_no);
            p.setString(2, user);
            p.setString(3, pass);
            p.setInt(4, national_id);
            p.setInt(5, phone);
            p.setString(6, addr);
            p.setString(7, email);
            p.setString(8, city);
            p.setString(9, attach);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //---------------add_reading Method--------------------------------------
    public static void add_reading(int meter_no ,int new_reading,String month) throws SQLException {
        try (
            Connection c = connect();
            PreparedStatement p = c.prepareStatement("update monthly_reading set new_reading = ? , month = ? where meter_no= ? ");){
            p.setInt(3, meter_no);
            p.setInt(1, new_reading);
            p.setString(2, month);
            
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //---------------add_fiest_reading Method--------------------------------------
    public static void add_fiest_reading(int meter_no) throws SQLException {
        try (
            Connection c = connect();
            PreparedStatement p = c.prepareStatement("insert into  monthly_reading (meter_no) values(?) ");){
            p.setInt(1, meter_no);
            
            
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //---------------send complain--------------------------------------
    public static void send_complain(int meter_no ,String complain) throws SQLException {
        try (
            Connection c = connect();
            PreparedStatement p = c.prepareStatement("insert into complains values(?,?)");){
            p.setInt(1, meter_no);
            p.setString(2, complain);          
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //---------------Insert bill status--------------------------------------
    public static void insert_bill_status(int meter_no, String date) throws SQLException {
        try (
            Connection c = connect();
            PreparedStatement p = c.prepareStatement("insert into  bills (meter_no,first_date) values (?,?) ");){ 
             p.setInt(1, meter_no);
             p.setString(2, date);
           
             
            
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //---------------update bill status--------------------------------------
    public static void update_bill_status(int meter_no ,String month) throws SQLException {
        try (
            Connection c = connect();
            PreparedStatement p = c.prepareStatement("update bills set month = ? , status = 'Paid' where meter_no= ? ");){ 
             p.setInt(2, meter_no);
            p.setString(1, month);
           
             
            
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //---------------Get Customers--------------------------------------
//    public static ArrayList<Domain.admin> get_customers()
//    {
//        ArrayList<Domain.admin> list=new ArrayList<>();
//        try      
//        (
//           Connection c = connect();
//           PreparedStatement p=c.prepareStatement("SELECT customerasas.user_name, customerasas.bill_status, customertany.address,customertany.city\n" +
//"FROM customerasas,customertany where customerasas.user_name=customertany.user_name");
//        )
//        {
//           ResultSet r=p.executeQuery();
//           while(r.next())
//           {
//               list.add(new Domain.admin(r.getString("user_name"),r.getString("bill_status"),r.getString("address"),r.getString("city")));
//           } 
//        }
//        catch(SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }
    
    //---------------Get Customers--------------------------------------
    public static ArrayList<Domain.customer> get_customer() {
        ArrayList<Domain.customer> list = new ArrayList<>();
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select * from  users where role_status='Customer'");
                )
        {
            ResultSet r = p.executeQuery();
            while (r.next()) 
            {
                list.add(new Domain.customer(r.getString("user_name"), r.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    //---------------Check Customers--------------------------------------
    public static int check_customer(String user, String pass) {

        ArrayList<Domain.customer> arr = get_customer();

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
     //---------------select_month_bill--------------------------------------
    public static String select_month_bill(int meter_no) throws SQLException {

      String result = "" ;
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select month from  monthly_reading where meter_no= ?");
                )
        {
            p.setInt(1, meter_no); 
            ResultSet r = p.executeQuery();
            while(r.next()) {
             String str = r.getString("month");
             result = str ;
            }
                      
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ;    
    }
    //---------------select_new_reading--------------------------------------
    public static int select_new_reading(int meter_no) throws SQLException {

      int result = 0 ;
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select new_reading from  monthly_reading where meter_no= ?");
                )
        {
            p.setInt(1, meter_no); 
            ResultSet r = p.executeQuery();
            while(r.next()) {
             String str = r.getString("new_reading");
             result = Integer.parseInt(str);
            }
                      
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ;    
    }
     //---------------select_old_reading--------------------------------------
    public static int select_old_reading(int meter_no) throws SQLException {

      int result = 0 ;
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select old_reading from  monthly_reading where meter_no= ?");
                )
        {
            p.setInt(1, meter_no); 
            ResultSet r = p.executeQuery();
            while(r.next()) {
             String str = r.getString("old_reading");
             result = Integer.parseInt(str);
            }
                      
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ;    
    }
    //---------------update_new_reading--------------------------------------
       public static void update_new_reading(int meter_no ){
        try(
        Connection c = connect();
        PreparedStatement p = c.prepareStatement("update monthly_reading set new_reading = '0' where meter_no= ? ");){
        p.setInt(1, meter_no);
        p.execute();
        }
        catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }   
    }
    //---------------update_old_reading--------------------------------------
       public static void update_old_reading(int meter_no , int reading ){
        try(
        Connection c = connect();
        PreparedStatement p = c.prepareStatement("update monthly_reading set old_reading = ? where meter_no= ? ");){
        p.setInt(1, reading);
        p.setInt(2, meter_no);
        p.execute();
        }
        catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }   
    }   
//---------------select_meter_no--------------------------------------
    public static int select_meter_no(String user_name , String password) throws SQLException {

      int result = 0 ;
        try (
                Connection c = connect();
                PreparedStatement p = c.prepareStatement("select meter_no from customers where ( user_name= ?  and password = ? ) ");
                )
        {
            p.setString(1, user_name); 
            p.setString(2, password);
            ResultSet r = p.executeQuery();
            while(r.next()) {
             String str = r.getString("meter_no");
             result = Integer.parseInt(str);
            }
                      
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ;    
    }
    
}
