
package my_electricity_billing_system;

import DataBase.Customer_Database;
import DataBase.Users_Database;
import Images.Image2;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Signup_Page extends JFrame implements ActionListener {
    //---------------Variables----------------------------------------
    JCheckBox check ; 
    Image2 ii = new Image2();
    JLabel user , pass ,log_as,num,add , meter , random , i ,emal,cit,att;
    JTextField user_name ,password ,number,address ,id,email,city,attach;
    JButton save , back ,button;
    Choice choose;
    //---------------Constractor--------------------------------------
    public Signup_Page (){
        
    }
    //---------------Method--------------------------------------
    public void show_signup_screen (){
        
        //---------------Initializaion Labels-----------------------
        user = new JLabel("Username");
        pass = new JLabel("Password");
        log_as = new JLabel("Log AS");
        i = new JLabel("National ID");
        num = new JLabel("Phone Number");
        add = new JLabel("Address");
        emal = new JLabel("Email");
        cit = new JLabel("City");
        att = new JLabel("Attach Contract");
        meter = new JLabel("Meter No");
        random = new JLabel();
        user.setBounds(50, 30, 150, 30);
        pass.setBounds(50,80, 150, 30);
        log_as.setBounds(50,130, 100, 30);
        i.setBounds(50, 230, 150, 30);
        num.setBounds(50, 280, 150, 30);
        add.setBounds(50, 330, 200, 30);
        emal.setBounds(50, 380, 150, 30);
        cit.setBounds(50, 430, 150, 30);
        att.setBounds(50, 480, 150, 30);
        meter.setBounds(50, 180, 200, 30);
        random.setBounds(150, 180, 150, 30);
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        random.setText(""+Math.abs(first));
        ii.add(num);  ii.add(user); ii.add(pass); ii.add(i);
        ii.add(add);  ii.add(add);ii.add(meter);ii.add(random);
        ii.add(log_as);ii.add(emal);ii.add(cit);ii.add(att);
        //--------------Initializaion TextFields---------------------
        user_name = new JTextField();
        user_name.setBounds(150, 30, 250, 30);
        password = new JTextField();
        password.setBounds(150, 80, 250, 30);
        id = new JTextField();
        id.setBounds(150, 230, 250, 30);
        number = new JTextField();
        number.setBounds(150, 280, 250, 30);
        address = new JTextField();
        address.setBounds(150, 330, 250, 30);
        email = new JTextField();
        email.setBounds(150, 380, 250, 30);
        city = new JTextField();
        city.setBounds(150,430, 250, 30);
        attach= new JTextField();
        attach.setBounds(150,480, 250, 30);        
        ii.add(user_name);ii.add(password);   
        ii.add(id);ii.add(number);
        ii.add(address);ii.add(email);
        ii.add(city);ii.add(attach);
    
        
       //------------attatch button ---------------------------------------------------
        
                button = new JButton("Select File");
		button.addActionListener(this);
		button.setBounds(450, 480, 100, 30);
		ii.add(button);
		this.pack();
                
                
                
                
		
//      //--------------Initializaion Choice---------------------
        choose = new Choice();
        choose.add("SELECT");
        choose.add("Admin");
        choose.add("Customer");
        choose.add("Operator");
        choose.setBounds(150, 130, 250,30);
        ii.add(choose);
        //---------------Initializaion Buttons-----------------------
        save = new JButton("Register");
        save.setBounds(150,550, 100, 50);
        save.setBackground(Color.GREEN);
        back = new JButton("Back");
        back.setBounds(300,550, 100, 50);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.CYAN);
        ii.add(save);
        ii.add(back);
        save.addActionListener(this);
        back.addActionListener(this);
        //---------------Frame Component------------------------------
        setTitle("SignUp Page");
        setSize(600, 755);
        setLocation(700, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(ii); 
        //--------Default Un Visable-----------------------------------------------
        i.setVisible(false);id.setVisible(false);
        meter.setVisible(false); random.setVisible(false);
        num.setVisible(false); number.setVisible(false);
        add.setVisible(false);address.setVisible(false);
        emal.setVisible(false);email.setVisible(false);
        cit.setVisible(false);city.setVisible(false);
        att.setVisible(false);attach.setVisible(false);
        button.setVisible(false); 
        //---------Choice Check-----------------------------------------------------
        choose.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ae){
               String user = choose.getSelectedItem();
               if(user.equals("Customer")){
                   meter.setVisible(true);random.setVisible(true);
                   num.setVisible(true);number.setVisible(true);
                   add.setVisible(true); address.setVisible(true);
                   i.setVisible(true);id.setVisible(true);
                   emal.setVisible(true);email.setVisible(true);
                   cit.setVisible(true);city.setVisible(true);
                   att.setVisible(true);attach.setVisible(true);
                   button.setVisible(true); button.setVisible(true);
               }else if(user.equals("Admin")){
                   i.setVisible(true);id.setVisible(true);
                   meter.setVisible(false); random.setVisible(false);
                   num.setVisible(false); number.setVisible(false);
                   add.setVisible(false);address.setVisible(false);
                   emal.setVisible(false);email.setVisible(false);
                   cit.setVisible(false);city.setVisible(false);
                   att.setVisible(false);attach.setVisible(false);
                   button.setVisible(false); 
               }
               else if(user.equals("Operator")){
                   i.setVisible(true);id.setVisible(true);
                   meter.setVisible(false); random.setVisible(false);
                   num.setVisible(false); number.setVisible(false);
                   add.setVisible(false);address.setVisible(false);
                   emal.setVisible(false);email.setVisible(false);
                   cit.setVisible(false);city.setVisible(false);
                   att.setVisible(false);attach.setVisible(false);
                   button.setVisible(false);                    
               }
               else{
                   meter.setVisible(false); random.setVisible(false);
                   num.setVisible(false);number.setVisible(false);
                   add.setVisible(false);address.setVisible(false); 
                   i.setVisible(false);id.setVisible(false);
                   emal.setVisible(false);email.setVisible(false);
                   cit.setVisible(false);city.setVisible(false);
                   att.setVisible(false); attach.setVisible(false);
                   button.setVisible(false); button.setVisible(false);
               }
           } 
        });
    }
// -------------------------------------------------------------
   
    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime currentDate ;
         if (e.getSource() == save ) {
              if (id.getText().isEmpty()||user_name.getText().isEmpty()||password.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "You haven't entered anything", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
              else{
                  String user = choose.getSelectedItem();
            if(user.equals("Admin")){
                try { 
                    
                    Users_Database.insert_user_data(Integer.parseInt(id.getText()),user_name.getText(), password.getText(), choose.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "Account Created Successfully * "+user_name.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Login_Page().show_first_screen();
                } catch (SQLException ex) {
                   System.out.println(ex.getMessage()); 
            }
            }   
            else if(user.equals("Customer")){
                    try {
                Customer_Database.insert_customer_data(Integer.parseInt(random.getText()), user_name.getText(), password.getText(), Integer.parseInt(id.getText()), Integer.parseInt(number.getText()), address.getText(), email.getText(), city.getText(), attach.getText());
                Users_Database.insert_user_data(Integer.parseInt(id.getText()),user_name.getText(), password.getText(), choose.getSelectedItem());
                //Customer_Database.add_fiest_reading(Integer.parseInt(random.getText()));
                currentDate = LocalDateTime.now();
                Customer_Database.insert_bill_status(Integer.parseInt(random.getText()),""+currentDate);
                 Customer_Database.add_fiest_reading(Integer.parseInt(random.getText()));
                JOptionPane.showMessageDialog(null, "Account Created Successfully * "+user_name.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new Login_Page().show_first_screen();
            }
            
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
                }else if(user.equals("Operator")) {
                    try { 
                    
                    Users_Database.insert_user_data(Integer.parseInt(id.getText()),user_name.getText(), password.getText(), choose.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "Account Created Successfully * "+user_name.getText(), "Successfully", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Login_Page().show_first_screen();
                } catch (SQLException ex) {
                   System.out.println(ex.getMessage()); 
            }
                }
                else{
                   JOptionPane.showMessageDialog(null," Select A Valid User !","Error",JOptionPane.ERROR_MESSAGE);
                }
              }
                             
    }
         if (e.getSource() == back) {
            this.dispose();
            new Login_Page().show_first_screen();
        }
         if(e.getSource()==button) {
			
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				attach.setText(""+file);
                                System.out.println(file);
			}
		}   
}   
}