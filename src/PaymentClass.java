

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @~~~waves~~~
 */
public class PaymentClass {
   
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    public void pay(String first_name,String second_name,int matric_no, String amount, String payment_type,String description) throws SQLException{
      
        //create connection
        Connection con = DriverManager.getConnection(DATABASE_URL, "root","");
        
       
        // to record the time n day the user regsitered 
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
       
         //sql statement
        String sql ="insert into payment(first_name,second_name,matric_no,amount,payment_type,description,date_of_payment)values "
                + "('"+first_name+"','"+second_name+"','"+matric_no+"','"+amount+"','"+payment_type+"','"+description+"','"+date+"')";
    
        //prepared statement
        Statement s = con.createStatement();
        s.execute(sql);
        
        //TO TEST 
        JOptionPane.showMessageDialog(null, "INFO SUCCESSFULLY INSERTED INTO THE DATABASE");
        
      
    }
        

    public DefaultTableModel searchPayData(String first_name, String second_name){
   
       DefaultTableModel pay= new DefaultTableModel();
       pay.addColumn("FIRST NAME");
       pay.addColumn("SECOND Name");
       pay.addColumn("MATRIC NO");
       pay.addColumn("AMOUNT");
       pay.addColumn("PAYMENT TYPE");
       pay.addColumn("DESCRIPTION");
       pay.addColumn("DATE OF PAYMENT");
       
       String sql="select * from payment where first_name='"+first_name+"'and second_name='"+second_name+"'";
     
       try {
            Connection con = DriverManager.getConnection(DATABASE_URL, "root","");
         
           Statement s1=con.prepareStatement(sql);
           ResultSet rs1 = s1.executeQuery(sql);
           
           while(rs1.next() ){
               first_name= rs1.getString(1);
               second_name= rs1.getString(2);
               int matric_no= rs1.getInt(3);
               String amount= rs1.getString(7);
               String payment_type= rs1.getString(4);
               String description= rs1.getString(5);
               Date dop= rs1.getDate(7);
              
               
               pay.addRow(new Object[]{first_name,second_name,matric_no,amount,payment_type,description,dop});
            }
           return pay;
        } catch (SQLException ex) {
           Logger.getLogger(EditClass.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
        }
       return null;
    }
//     public static void main(String[]args) throws SQLException{
//     PaymentClass test = new PaymentClass();
//     test.pay("salimon","jamiu",1,"5000","Cash","medicals");
//    }

}
 

