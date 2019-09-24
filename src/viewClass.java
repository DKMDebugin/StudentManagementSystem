
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
 * @author HP
 */
public class viewClass {
   String DB_URL = "jdbc:mysql://localhost:3306/users";
   String username="root";
   String password="";
   
    public DefaultTableModel viewData(){
   
       DefaultTableModel dm1= new DefaultTableModel();
       dm1.addColumn("Matric No");
       dm1.addColumn("First Name");
       dm1.addColumn("Second Name");
       dm1.addColumn("College");
       dm1.addColumn("Department");
       dm1.addColumn("Semester");
       dm1.addColumn("Level");
       dm1.addColumn("Phone No");
       dm1.addColumn("Guardian Phone No");
       dm1.addColumn("Email");
       dm1.addColumn("Reg. Time");
       
       String sql="select * from new_student";
      
       try {
           Connection con=DriverManager.getConnection(DB_URL, username, password);
         
           Statement s=con.prepareStatement(sql);
           ResultSet rs = s.executeQuery(sql);
           
           while(rs.next() ){
               int matric_no= rs.getInt(1);
               String first_name= rs.getString(2);
               String second_name= rs.getString(3);
               String college= rs.getString(4);
               String department= rs.getString(5);
               String semester= rs.getString(6);
               String level= rs.getString(7);
               String phone_no= rs.getString(8);
               String guardian_no= rs.getString(9);
               String email= rs.getString(10);
               Date reg_time= rs.getDate(11);
              
               
               dm1.addRow(new Object[]{matric_no,first_name,second_name,college,department,semester,level,phone_no,guardian_no,email,reg_time});
   
     
           }
           return dm1;
           
       } catch (SQLException ex) {
           Logger.getLogger(EditClass.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return null;
   }
    
   
    public DefaultTableModel searchData(int matric_no,String first_name){
   
       DefaultTableModel dm2= new DefaultTableModel();
       dm2.addColumn("Matric No");
       dm2.addColumn("First Name");
       dm2.addColumn("Second Name");
       dm2.addColumn("College");
       dm2.addColumn("Department");
       dm2.addColumn("Semester");
       dm2.addColumn("Level");
       dm2.addColumn("Phone No");
       dm2.addColumn("Guardian Phone No");
       dm2.addColumn("Email");
       dm2.addColumn("Reg. Time");
       
       String sql="select * from new_student where matric_no='"+matric_no+"' and first_name='"+first_name+"'";
     
       try {
           Connection con=DriverManager.getConnection(DB_URL, username, password);
         
           Statement s1=con.prepareStatement(sql);
           ResultSet rs1 = s1.executeQuery(sql);
           
           while(rs1.next() ){
               matric_no= rs1.getInt(1);
               first_name= rs1.getString(2);
               String second_name= rs1.getString(3);
               String college= rs1.getString(4);
               String department= rs1.getString(5);
               String semester= rs1.getString(6);
               String level= rs1.getString(7);
               String phone_no= rs1.getString(8);
               String guardian_no= rs1.getString(9);
               String email= rs1.getString(10);
               Date reg_time= rs1.getDate(11);
              
               
               dm2.addRow(new Object[]{matric_no,first_name,second_name,college,department,semester,level,phone_no,guardian_no,email,reg_time});
            }
           return dm2;
        } catch (SQLException ex) {
           Logger.getLogger(EditClass.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "UNSUCCESSFUL");
        }
       
       return null;
    }
}
