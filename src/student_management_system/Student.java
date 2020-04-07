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
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Student {
    public void insertUpdateDeletStudent(char opration,Integer id, String fname,String lname,String sex,String date,String phone,String address) throws SQLException{
    
    
    Connection con =MyConnection.getConnection();
    PreparedStatement ps;
    if(opration =='i'){
    
    ps = con.prepareStatement("INSERT INTO student( stu_fname, stu_lname, stu_sex, stu_bdate, stu_phone_no, stu_address) VALUES (?,?,?,?,?,?)");
    ps.setString(1, fname);
    ps.setString(2, lname);
    ps.setString(3, sex);
    ps.setString(4,date);
    ps.setString(5,phone);
    ps.setString(6, address);
    if(ps.executeUpdate()>0){
    
        JOptionPane.showMessageDialog(null, "New Student is Added");
        
        Main_Form.jLabel_stu_total.setText(Integer.toString(MyTotalFunction.countData("student")));
    }}
    else if(opration =='u'){
    ps= con.prepareStatement("UPDATE `student` SET `stu_fname`=?,`stu_lname`=?,`stu_sex`=?,`stu_bdate`=?,`stu_phone_no`=?,`stu_address`=? WHERE `stu_id`=?");
    ps.setString(1, fname);
    ps.setString(2, lname);
    ps.setString(3, sex);
    ps.setString(4,date);
    ps.setString(5,phone);
    ps.setString(6, address);
    ps.setInt(7, id);
   
    if(ps.executeUpdate()>0){
    
        JOptionPane.showMessageDialog(null, " Student is Update");
        
        Main_Form.jLabel_stu_total.setText(Integer.toString(MyTotalFunction.countData("student")));
    }
    }
    else if(opration =='d'){
        
        int yesornot =  JOptionPane.showConfirmDialog(null, " The Score is also deleted ","Deleted Student", JOptionPane.OK_CANCEL_OPTION,0);
        if(yesornot==0){
      ps= con.prepareStatement("DELETE FROM `student` WHERE `stu_id`=?");
        ps.setInt(1, id);
      if(ps.executeUpdate()>0){
    
        JOptionPane.showMessageDialog(null, " Student is Deleted");
        
        Main_Form.jLabel_stu_total.setText(Integer.toString(MyTotalFunction.countData("student")));
    }
            }
    } 
    
    
    
    
    
    
    
    }
    

        public void fillStudentJtable(JTable table , String valueToSearch){
        
         Connection con =MyConnection.getConnection();
         PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `student` WHERE CONCAT( `stu_fname`, `stu_lname`,  `stu_bdate`, `stu_phone_no`, `stu_address`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object [] row;
            while(rs.next()){
            row = new Object[7];
            row[0]=rs.getInt(1);
            row[1]=rs.getString(2);
            row[2]=rs.getString(3);
            row[3]=rs.getString(4);
            row[4]=rs.getString(5);
            row[5]=rs.getString(6);
            row[6]=rs.getString(7);
            model.addRow(row);
              
            
            
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}