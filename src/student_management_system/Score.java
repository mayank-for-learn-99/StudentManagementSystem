/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RISING STAR MAYANK
 */
public class Score {
    
        public void insertUpdateDeletScore(char opration , int sid ,int cid , Double score , String descrp){
        
        Connection con  = MyConnection.getConnection();
        PreparedStatement ps;
        if(opration =='i'){
       try {
                ps = con.prepareStatement("INSERT INTO `score`(`stu_id`, `course_id`, `stu_score`, `description`) VALUES (?,?,?,?)");
                ps.setInt(1, sid);
                ps.setInt(2, cid);
                ps.setDouble(3, score);
                ps.setString(4, descrp);
                if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null, "Score is Updated");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       }
          if(opration =='u'){
               
               
                
           try {
               
                
                ps = con.prepareStatement("UPDATE `score` SET `stu_score`=?,`description`=? WHERE `stu_id`=? AND`course_id`=?");
                ps.setDouble(1, score);
                ps.setString(2, descrp);
                ps.setInt(3, sid);
                ps.setInt(4, cid);
               
                if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null, " score of student  is Updated");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
      if(opration =='d'){
           try {
                ps = con.prepareStatement("DELETE FROM `score` WHERE `stu_id`=? AND `course_id`=?");
                ps.setInt(1, sid);
                ps.setInt(2, cid);
                
                if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null, "score of studen is  deleted");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      
      }
      
     }
        
           public void fillScoreJtable(JTable table){
        
         Connection con =MyConnection.getConnection();
         PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM  `score` ");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object [] row;
            while(rs.next()){
            row = new Object[4];
            row[0]=rs.getInt(1);
            row[1]=rs.getInt(2);
            row[2]=rs.getDouble(3);
            row[3]=rs.getString(4);
    
            model.addRow(row);
              
            
            
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
           
         public void fillAllScoreJtable(JTable table){
         Connection con =MyConnection.getConnection();
         PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT score.stu_id,stu_fname,stu_lname ,course_lable,`stu_score` from score INNER JOIN student as stab on stab.stu_id=score.stu_id INNER JOIN course as ctab on ctab.course_id=score.course_id");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object [] row;
            while(rs.next()){
            row = new Object[5];
            row[0]=rs.getInt(1);
            row[1]=rs.getString(2);
            row[2]=rs.getString(3);
            row[3]=rs.getString(4);
            row[4]=rs.getDouble(5);
    
            model.addRow(row);
              
            
            
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
        }



    
    

