
package Domain;


public class user {
    
    private String user_name , password  ;
    private String role_status;
    private int user_id ; 
//-----------------------constractor------------------------------------
    public user(int user_id ,String user_name, String password, String role_status) {
        this.user_id= user_id;
        this.user_name = user_name;
        this.password = password;
        this.role_status = role_status;
    }
    public user( String role_status) {
       
        this.role_status = role_status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_id() {
        return role_status;
    }

    public void setRole_id(int role_id) {
        this.role_status = role_status;
    }

    public String getRole_status() {
        return role_status;
    }

    public void setRole_status(String role_status) {
        this.role_status = role_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
    
}
