
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

/**
 *
 * @author HP
 */
public class ImageClass {
 private String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
 PreparedStatement ps;     
  
 //insert img in to db
 public Boolean add(File img, FileInputStream fis){
     try {
    
         //query
         String sql ="insert into profile(picture) values(?)";
         
         //create connection
         Connection con = DriverManager.getConnection(DATABASE_URL, "root","");
         
         //prepared statements
         ps=con.prepareStatement(sql);
         
         //giving a value to statement
         ps.setBinaryStream(1, fis, (int)img.length());
         
         //execute
         ps.executeUpdate();
         
         return true;
     } catch (SQLException ex) {
         Logger.getLogger(ImageClass.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     }
    }
 public int retrieve() throws SQLException, IOException{
     try {
         FileOutputStream fos=null;
         
         //query to be use on the db
         String sql ="select * from profile";
         
         //create connection
         Connection con = DriverManager.getConnection(DATABASE_URL, "root","");
         ps=con.prepareStatement(sql);
         
         //create a result set
         ResultSet rs = ps.executeQuery(sql);
         rs.last();
         
         //get cell values per row
         Blob b=rs.getBlob("picture");
         int id =rs.getInt("id");
         
         //write file to our machine
         fos= new FileOutputStream("C:\\Users\\HP\\Pictures\\"+id+".JPG");
         
         int len=(int)b.length();
         byte[] buf=b.getBytes(1, len);
         
         fos.write(buf,0, len);
         return id;
         
     } catch (FileNotFoundException ex) {
         Logger.getLogger(ImageClass.class.getName()).log(Level.SEVERE, null, ex);
         //return -1;
     }
      return -1;
    }
}
