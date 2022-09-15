package Domain;

public class admin {

    String user_name, address, bill_status, city;

    String district;
    int cons_rate, price;
    
    String user,pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public admin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBill_status() {
        return bill_status;
    }

    public void setBill_status(String bill_status) {
        this.bill_status = bill_status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCons_rate() {
        return cons_rate;
    }

    public void setCons_rate(int cons_rate) {
        this.cons_rate = cons_rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public admin(String user_name, String bill_status, String address, String city) {

        this.user_name = user_name;
        this.bill_status = bill_status;
        this.address = address;
        this.city = city;
    }

    public admin(String district, int cons_rate, int price) {
        this.district = district;
        this.cons_rate = cons_rate;
        this.price = price;
    }

}
