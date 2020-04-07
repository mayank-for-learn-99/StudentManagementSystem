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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Course {
   
    public void insertUpdateDeletCourse(char opration , Integer id , String label,Integer houre){
        
        Connection con  = MyConnection.getConnection();
        PreparedStatement ps;
        if(opration =='i'){
        
            try {
                ps = con.prepareStatement("INSERT INTO `course`(`course_lable`, `course_hours`) VALUES (?,?)");
                ps.setString(1, label);
                ps.setString(2, Integer.toString(houre));
                if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null, "New Course is Added");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       }
      if(opration =='u'){
      
           try {
                ps = con.prepareStatement("UPDATE `course` SET`course_lable`=?,`course_hours`=? WHERE `course_id`=?");
                ps.setString(1, label);
                ps.setString(2, Integer.toString(houre));
                ps.setInt(3, id);
                if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null, " Course is Updated");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
      if(opration =='d'){
           int yesornot =  JOptionPane.showConfirmDialog(null, " The Score is also deleted ","Deleted Course", JOptionPane.OK_CANCEL_OPTION,0);
        if(yesornot==0){
           try {
                ps = con.prepareStatement("DELETE FROM `course` WHERE `course_id`=?");
                ps.setInt(1, id);
                
                if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null, "Course is deleted");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
      }
     }
    
    public boolean isExist(String courseName){
    
        boolean exist = false;
        Connection con  = MyConnection.getConnection();
        PreparedStatement ps;
          try {
             
              ps = con.prepareStatement("SELECT * FROM `course` WHERE `course_lable`= ?");
              ps.setString(1, courseName);
              
              ResultSet rs=ps.executeQuery();
              if(rs.next()){
              
                    exist = true;
              
              }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        return exist;
    }
    
      public void fillCourseJtable(JTable table){
        
         Connection con =MyConnection.getConnection();
         PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `course` ");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object [] row;
            while(rs.next()){
            row = new Object[3];
            row[0]=rs.getInt(1);
            row[1]=rs.getString(2);
            row[2]=rs.getInt(3);
    
            model.addRow(row);
              
            
            
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     
      
      public  int getCourseId(String courseName){
      
      int courseId = 0;
      
      
       Connection con  = MyConnection.getConnection();
        PreparedStatement ps;
          try {
             
              ps = con.prepareStatement("SELECT * FROM `course` WHERE `course_lable`= ?");
              ps.setString(1, courseName);
              
              ResultSet rs=ps.executeQuery();
              if(rs.next()){
              
                  courseId = rs.getInt("course_id");
              
              }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      
      
      
      
      return courseId;
      }
       public void fillCourseComboBox(JComboBox combo){
        
         Connection con =MyConnection.getConnection();
         PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `course` ");
            ResultSet rs = ps.executeQuery();
         
            
            while(rs.next()){
                combo.addItem(rs.getString(2));
              
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     
    
}
