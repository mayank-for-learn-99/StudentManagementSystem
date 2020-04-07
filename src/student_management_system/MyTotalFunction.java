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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyTotalFunction {
    
    
    public static int countData(String tablename){
        
     int total = 0;
    Connection con = MyConnection.getConnection();
    Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total  FROM "+tablename);
            
            while(rs.next()){
                    total = rs.getInt(1);
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyTotalFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    
    return total;
    
    }
    
  
}
