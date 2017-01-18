/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examseatallotment;
import java.sql.*;
import javax.management.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Priyam Kumar
 */
public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
     
    public DBConnection(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");
            st=con.createStatement();
            
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }
    void roomResult(DefaultTableModel tableModel){
    
        try {
            String qry="select * from room";
           rs=st.executeQuery(qry);
            //System.out.println("Result from database");
            while(rs.next()){
          
            
        tableModel.insertRow(tableModel.getRowCount(), new Object[]{tableModel.getRowCount()+1,rs.getString("room_name"),rs.getString("no_of_rows"),rs.getString("no_of_columns")});
            
            }
            
        } catch (Exception e) {
              System.out.println("error in result"+e);
        }
     }
    
     int checkXlFile(String branchName,String semester){
    
        try {
            String qry="select * from classes where branch_name='"+branchName+"' and semester="+Integer.parseInt(semester)+"";
           rs=st.executeQuery(qry);
            //System.out.println("Result from database");
            if(rs.next()){
          
            return rs.getInt("xlfile");
       
            
            }
            
            
        } catch (Exception e) {
              System.out.println("error in result"+e);
        }
        return 0;
     }
    
     String getRoomName(String branchName,String semester,String sno){
           int s=Integer.parseInt(sno);
        try {
            String qry="select * from allotment where class_name='"+branchName+"' and semester="+Integer.parseInt(semester)+" and start_no<="+s+" and end_no>="+s+"";
           rs=st.executeQuery(qry);
            //System.out.println("Result from database");
            if(rs.next()){
          
            return rs.getString("room_name");
       
            
            }
            
            
        } catch (Exception e) {
              System.out.println("error in result"+e);
        }
        return null;
     }
    
    
     void classResult(DefaultTableModel tableModel){
    
        try {
            String qry="select * from classes";
           rs=st.executeQuery(qry);
            //System.out.println("Result from database");
            while(rs.next()){
          
            
        tableModel.insertRow(tableModel.getRowCount(), new Object[]{tableModel.getRowCount()+1,rs.getString("branch_name"),rs.getString("semester"),rs.getString("strength"),rs.getInt("xlfile")});
            
            }
            
        } catch (Exception e) {
              System.out.println("error in result"+e);
        }
        
    
    
    }
    
    
    
    
    
    void theQuery(String Query){
        try {
            st.executeUpdate(Query);
            //JOptionPane.showMessageDialog(null,"query executed");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    
    
    }
    
    void deleteRoomQuery(){
    
    
     try {
        String Query="delete from room";
                
            st.executeUpdate(Query);
           // JOptionPane.showMessageDialog(null,"delete room  executed");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
    
    }
    
    
    
    
    
    
   void deleteClassQuery(){
    
    
     try {
        String Query="delete from classes";
                
            st.executeUpdate(Query);
         //   JOptionPane.showMessageDialog(null,"delete   executed");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
    
    }
   void writeAllotment(String roomName,String className,String semester,long sno){
   
   
   
        try {
             String qry="select * from allotment where room_name='"+roomName+"' and class_name='"+className+"' and semester='"+semester+"'";
           rs=st.executeQuery(qry);
           if(!rs.next())
           { String Query="insert into allotment (class_name,semester,room_name,start_no,end_no) values('"+className+"','"+semester+"','"+roomName+"',"+sno+","+sno+")";
                
            st.executeUpdate(Query);}
           else{
           
           String Query="update allotment set end_no=end_no+1 where room_name='"+roomName+"' and class_name='"+className+"' and semester='"+semester+"' ";
                
            st.executeUpdate(Query);
           }
               
         //   JOptionPane.showMessageDialog(null,"allotment  executed");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
   
   
   
   }
   void deleteAllotmentQuery(){
    
    
     try {
        String Query="delete from allotment";
                
            st.executeUpdate(Query);
            //JOptionPane.showMessageDialog(null,"allotment delete   executed");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
    
    }
}
