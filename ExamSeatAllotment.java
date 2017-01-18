/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examseatallotment;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


/**
 *
 * @author Priyam Kumar
 */
public class ExamSeatAllotment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection connect=new DBConnection();
       // connect.writeAllotment("it room 2","It","3", 5);
     //  int c=connect.checkXlFile("it","1");
     String roomname=connect.getRoomName("it","1","3");
       System.out.println(roomname);
       
         
        
    }
  
}
