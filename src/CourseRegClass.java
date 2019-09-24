
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
public class CourseRegClass {
   
   String DB_URL = "jdbc:mysql://localhost:3306/users";
   String username="root";
   String password="";
   
   
   public Boolean Reg( int matric_no, String first_name, String second_name, String semester, String level, String college, String department, String c1,String c2,String c3,String c4,String c5){
   
       try {
           //create connection
           Connection con = DriverManager.getConnection(DB_URL, username,password);
           
           // to record the time n day the user regsitered
           java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
           
           
           //sql statement
           String sql ="insert into course_reg(matric_no,first_name,second_name,semester,level,college,department,c1,c2,c3,c4,c5,reg_time)values ('"+matric_no+"','"+first_name+"','"+second_name+"','"+semester+"','"+level+"','"+college+"','"+department+"','"+c1+"','"+c2+"','"+c3+"','"+c4+"','"+c5+"','"+date+"')";
           
           Statement s= con.createStatement();
           s.execute(sql);
           return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(CourseRegClass.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       }
   }
   
   
   public DefaultTableModel searchCourse(int matric_no,String first_name){
   DefaultTableModel reg= new DefaultTableModel();
       reg.addColumn("Matric No");
       reg.addColumn("First Name");
       reg.addColumn("Second Name");
       reg.addColumn("Semester");
       reg.addColumn("Level");
       reg.addColumn("College");
       reg.addColumn("Department");
       reg.addColumn("Course1");
       reg.addColumn("Course2");
       reg.addColumn("Course3");
       reg.addColumn("Course4");
       reg.addColumn("Course5");
       reg.addColumn("Reg. Time");
       
       String sql="select * from course_reg where matric_no='"+matric_no+"' and first_name='"+first_name+"'";
     
       try {
           Connection con=DriverManager.getConnection(DB_URL, username, password);
         
           Statement s1=con.prepareStatement(sql);
           ResultSet rs1 = s1.executeQuery(sql);
           
           while(rs1.next() ){
               matric_no= rs1.getInt(1);
               first_name= rs1.getString(2);
               String second_name= rs1.getString(3);
               String semester= rs1.getString(4);
               String level= rs1.getString(5);
               String college= rs1.getString(6);
               String department= rs1.getString(7);
               String course1= rs1.getString(8);
               String course2= rs1.getString(9);
               String course3= rs1.getString(10);
               String course4= rs1.getString(11);
               String course5= rs1.getString(12);
               Date reg_time= rs1.getDate(13);
              
               
               reg.addRow(new Object[]{matric_no,first_name,second_name,semester,level,college,department,course1,course2,course3,course4,course5,reg_time});
            }
           return reg;
        } catch (SQLException ex) {
           Logger.getLogger(EditClass.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "UNSUCCESSFUL");
        }
       
       return null;
    }
   
   
    public DefaultTableModel ResultChck(int matric_no){
   
       DefaultTableModel result= new DefaultTableModel();
       result.addColumn("COURSE");
       result.addColumn("SCORE");
       result.addColumn("GRADE");
       
       String sql="select course,score,grade from result where matric_no='"+matric_no+"'";
     
       try {
           Connection con=DriverManager.getConnection(DB_URL, username, password);
         
           Statement s1=con.prepareStatement(sql);
           ResultSet rs1 = s1.executeQuery(sql);
           
           while(rs1.next() ){
               String course= rs1.getString(1);
               String score= rs1.getString(2);
               String grade= rs1.getString(3);
              
               
              result.addRow(new Object[]{course,score,grade});
            }
           return result;
        } catch (SQLException ex) {
           Logger.getLogger(EditClass.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return null;
    }
    public void RecordResult(int matric_no,String course,int score,String grade){
        int count=0;
       try {
           Connection con=DriverManager.getConnection(DB_URL, username, password);
           String query= " select * from result where matric_no='"+matric_no+"' and course='"+course+"' ";
           
           //execute query
           Statement q = con.createStatement();
           ResultSet set = q.executeQuery(query);
           
           while(set.next()){
               count++;
           }//end while loop
           
           if(count==0){
               
               String sql="insert into result(matric_no,course,score,grade) values('"+matric_no+"','"+course+"','"+score+"','"+grade+"')";
              
                Statement s1=con.createStatement();
                s1.execute(sql);
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY ");
            }else JOptionPane.showMessageDialog(null, "UNSUCCESSFULLY ");
       } catch (SQLException ex) {
           Logger.getLogger(CourseRegClass.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
