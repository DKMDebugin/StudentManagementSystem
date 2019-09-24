import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @~~~waves~~~
 */
public class RegisterClass {
    int count;
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    public void add(String first_name,String second_name,String college, String department,String semester,String level,String phone_no,String guardian_no, String email) throws SQLException, IOException{
      
        //create connection
        Connection con = DriverManager.getConnection(DATABASE_URL, "root","");
        
        int constant =0;
        // to record the time n day the user regsitered 
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        //check for duplicates
        //set query with the primary key
        String query= " select * from new_student where phone_no='"+phone_no+"' ";
        
        //execute query
        Statement q = con.createStatement();
        ResultSet set = q.executeQuery(query);
        
         while(set.next()){
             count++;
            }//end while loop
       
        if(count==0){
       
         //sql statement
        String sql ="insert into new_student(first_name,second_name,college,department,semester,level,phone_no,guardian_no,email,reg_time)values "
                + "('"+first_name+"','"+second_name+"','"+college+"','"+department+"','"+semester+"','"+level+"','"+phone_no+"','"+guardian_no+"','"+email+"', '"+date+"')";
    
        //prepared statement
        Statement s = con.createStatement();
        s.execute(sql);
        
        //TO TEST 
        JOptionPane.showMessageDialog(null, "INFO SUCCESSFULLY INSERTED INTO THE DATABASE");
        
        }
        else JOptionPane.showMessageDialog(null, "RECORD ALREADY EXIST");
    }
    
    //testing if the info goes into the db
    
//    public static void main(String[]args) throws SQLException{
//     RegisterClass test = new RegisterClass();
//     test.add("Salimon","Jamiu", "COPAS", "COMPUTER_SCIENCE" ,"2nd","300level", "08055434629","0365546353", "salimonjamiu@yahoo.com");
//    }
    
}
