
package Domain;


public class customer {
    String user,pass;
    int meter,reading;
    String fname,lname,address,city;

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

    public int getMeter() {
        return meter;
    }

    public int setMeter(int meter) {
        this.meter = meter;
        return meter;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public customer(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public customer(String fname, String lname, String address, String city) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;

    }
    
    public customer(String user, String pass,int meter) {
        this.user = user;
        this.pass = pass;
        this.meter = meter;
    }

    public customer(int reading) {
        this.reading = reading;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }
    
    
}
