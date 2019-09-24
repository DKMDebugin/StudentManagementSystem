
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author HP
 */
public class EditClass {
   String DB_URL = "jdbc:mysql://localhost:3306/users";
   String username="root";
   String password="";
   
   //retrieve
   public DefaultTableModel getData(int matric_no){
   
       DefaultTableModel dm= new DefaultTableModel();
       dm.addColumn("Matric No");
       dm.addColumn("First Name");
       dm.addColumn("Second Name");
       dm.addColumn("College");
       dm.addColumn("Department");
       dm.addColumn("Semester");
       dm.addColumn("Level");
       dm.addColumn("Phone No");
       dm.addColumn("Guardian Phone No");
       dm.addColumn("Email");
       
       String sql="select * from new_student where matric_no='"+matric_no+"'";
      
       try {
           Connection con=DriverManager.getConnection(DB_URL, username, password);
         
           Statement s=con.prepareStatement(sql);
           ResultSet rs = s.executeQuery(sql);
           
           while(rs.next() ){
               matric_no= rs.getInt(1);
               String first_name= rs.getString(2);
               String second_name= rs.getString(3);
               String college= rs.getString(4);
               String department= rs.getString(5);
               String semester= rs.getString(6);
               String level= rs.getString(7);
               String phone_no= rs.getString(8);
               String guardian_no= rs.getString(9);
               String email= rs.getString(10);
              
               
               dm.addRow(new Object[]{matric_no,first_name,second_name,college,department,semester,level,phone_no,guardian_no,email});
   
     
           }
           return dm;
           
        } catch (SQLException ex) {
           Logger.getLogger(EditClass.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "UNSUCCESFUL");
        }
        return null;
    }
   
   
   public Boolean update(int matric_no,String first_name,String second_name,String college,String department, String semester, String level,String phone_no,String guardian_no,String email){
   //System.out.println(matric_no +first_name+ second_name+college+department+level+semester+phone_no+guardian_no);
       //sql statement
       String sql="update new_student set first_name='"+first_name+"', second_name='"+second_name+"',college='"+college+"',department='"+department+"', semester='"+semester+"',level='"+level+"',phone_no='"+phone_no+"',guardian_no='"+guardian_no+"',email='"+email+"' where matric_no='"+matric_no+"'";
       
       try{
           Connection con= DriverManager.getConnection(DB_URL,username,password);
           
           Statement s1= con.createStatement();
         
           s1.execute(sql);
         
           return true;
       
       }
       catch(SQLException ex){
       return false;
       }
   }
   
   public boolean del(int matric_no){
   
       String sql ="delete from profile where id='"+matric_no+"'";
       
       try{
           Connection con= DriverManager.getConnection(DB_URL,username,password);
           Statement s2=con.prepareStatement(sql);
           s2.execute(sql); 
           
           return true;
       
       }
       catch(SQLException ex){
       return false;
       }
    }
//   public static void main(String []args){
//    EditClass ex= new EditClass();
//    ex.update(1, "shile", "babatunde", "copas", "csc", "1st", "300l", "64773838", "5464737", "gdh@yahoo.com");
//   }
}
