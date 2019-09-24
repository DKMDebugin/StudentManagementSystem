
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ~~~waves~~~
 */
public class LoginClass {
  private int count;
  Connection connection= null;//manage connection
  Statement statement= null;//manage statement
  ResultSet resultSet= null;//manage query execution 
    //create a URL
  private final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
  
 public int Login(String usernm, String pword) throws SQLException{
     if(count==1){
         count=0;        
     }
  //establish connection
  connection = DriverManager.getConnection(DATABASE_URL,"root","");
  
  //create query
  String query = "select * from details where username = '"+usernm+"' and password ='"+pword+"' ";
  //execute query
  statement = connection.createStatement();
  resultSet = statement.executeQuery(query);
 
  while(resultSet.next()){
  count++;
  }//end while loop
 //System.out.println(count);
  
  return count;
 }//END LOGIN DETAILS   

//public static void main(String[]args) throws SQLException{
//LoginClass test = new LoginClass();
//test.Login("shile","olashila");
//}

}//end of login class
