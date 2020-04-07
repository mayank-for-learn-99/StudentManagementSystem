/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_management_system;

/**
 *
 * @author RISING STAR MAYANK
 */
import java.sql.*;
 
public class MyConnection {
    public static Connection getConnection(){
    
    Connection con =null ; 
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_student_management_system?zeroDateTimeBehavior=convertToNull","root","");
    
    }catch(Exception ex){
    
    System.out.println(ex.getMessage());
    }
    
    
    
    
    return con;
    }
  //  Strint co="jdbc:mysql://localhost:3307/java_student_management_system?zeroDateTimeBehavior=convertToNull [root on Default schema]";
    
}
