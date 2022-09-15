
package Domain;


public class operator {
    String user,pass;
    String user_name,tar,dis;
    int meter_number,cons_rat,pric;
    int payment;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTar() {
        return tar;
    }

    public void setTar(String tar) {
        this.tar = tar;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public int getMeter_number() {
        return meter_number;
    }

    public void setMeter_number(int meter_number) {
        this.meter_number = meter_number;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getCons_rat() {
        return cons_rat;
    }

    public void setCons_rat(int cons_rat) {
        this.cons_rat = cons_rat;
    }

    public int getPric() {
        return pric;
    }

    public void setPric(int pric) {
        this.pric = pric;
    }

    public operator(String user_name, int meter_number, int payment,String tar) {
        this.user_name = user_name;
        this.meter_number = meter_number;
        this.payment = payment;
        this.tar = tar;
    }

    public operator(String user_name, int meter_number, int payment) {
        this.user_name = user_name;
        this.meter_number = meter_number;
        this.payment = payment;
   }


   
    

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

    public operator(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    
}
