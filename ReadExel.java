/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examseatallotment;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.WorkspaceInformationRecord;

/**
 *
 * @author Priyam Kumar
 */
public class ReadExel {

    /**
     @param args the command line arguments
     */
   public static String getRollNo(String branch_name,String semester,long sno) throws Exception{
   // String serial=sno+"";
      File f=new File("C:\\Users\\Priyam Kumar\\Desktop\\"+branch_name+"-"+semester+".xls");
        Workbook wb=Workbook.getWorkbook(f);
        Sheet s=wb.getSheet(0);
        int row=s.getRows();
        int col=s.getColumns();
       for(int i=0;i<row;i++){
           Cell c=s.getCell(0, i);
           
            if(Long.parseLong(c.getContents())==sno){
              c=s.getCell(1,i);
            return c.getContents();}
             }
       return null;
    }
    public static String getSNo(String branch_name,String semester,String rollno) throws Exception{
   // String serial=sno+"";
      File f=new File("C:\\Users\\Priyam Kumar\\Desktop\\"+branch_name+"-"+semester+".xls");
        Workbook wb=Workbook.getWorkbook(f);
        Sheet s=wb.getSheet(0);
        int row=s.getRows();
        int col=s.getColumns();
       for(int i=0;i<row;i++){
           Cell c=s.getCell(1, i);
           
            if((c.getContents()).equals(rollno)){
              c=s.getCell(0,i);
            return c.getContents();}
             }
       return null;
    }
    public static void main(String[] args) throws Exception{
        
      /*File f=new File("C:\\Users\\Priyam Kumar\\Desktop\\data.xls");
        Workbook wb=Workbook.getWorkbook(f);
        Sheet s=wb.getSheet(0);
        int row=s.getRows();
        int col=s.getColumns();
       for(int i=0;i<row;i++){
         for(int j=0;j<col;j++)
         {
         
             Cell c=s.getCell(j, i);
             System.out.print(c.getContents()+"  ");
             
         
         }
           System.out.println("");       
       
       }*/
     String rollno=getRollNo("it","1",5);
        System.out.println(rollno); 
        String sno=getSNo("it","1","14118004");
        System.out.println(sno); 
    }
    
}
