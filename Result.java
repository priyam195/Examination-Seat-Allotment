/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examseatallotment;

import java.awt.Component;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.MessageFormat;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Priyam Kumar
 */
public class Result extends javax.swing.JFrame {
    /*String[] enter=new String[3];
    JTable table1;
    public class MultiLineTableCellRenderer extends JList<String> implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //make multi line where the cell value is String[]
        if (value instanceof String[]) {
            setListData((String[]) value);
        }

        //cell backgroud color when selected
        if (isSelected) {
            setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            setBackground(UIManager.getColor("Table.background"));
        }

        return this;
    }
}
*/
    /**
     * Creates new form Result
     * @param table
     */
    public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 100; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
           
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
       // if(width > 300)
           // width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}
       public  String getRollNo(String branch_name,String semester,long sno) throws Exception{
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
    
    String[] columnNames;
    long[] grid;
    int columnSize;
    int rowSize;
    int selectedRow;
    JTable resultTable;
    String[] bnm;
    String[] snm;
    String roomName;
    String[] Grid;
    public Result(String[] branchName,String[] semseter, long grids[] ,String[] s,int cs,int rs, int selrow,String roomname) throws Exception {
        initComponents();
        bnm=branchName;
        snm=semseter;
        columnNames=s;
        columnSize=cs;
        rowSize=rs;
        selectedRow=selrow;
        roomName=roomname;
         DBConnection connect=new DBConnection();
         grid=grids;
         jButton1.setText("Room - "+roomname);
       
         Object[][] data =new Object[rowSize][columnSize];
            int k=0;
        for(int i=0;i<rowSize;i++){
     
        for(int j=0;j<columnSize;j++){
            if(grid[k]!=0)
            {   
                //enter[0]=bnm[k];
                //enter[1]=snm[k];
                if(connect.checkXlFile(bnm[k],snm[k])!=0)
                {
                   // enter[2]=getRollNo(bnm[k],snm[k],grid[k]);
                data[i][j]=bnm[k]+"-"+snm[k]+"-"+getRollNo(bnm[k],snm[k],grid[k]);
                //data[i][j]=enter;
                }
            else
                //{
                //    enter[2]=""+grid[k];
                  //  data[i][j]=enter;
                //}
                    data[i][j]=bnm[k]+"-"+snm[k]+"-"+grid[k];  
            
            }
            
            else
                data[i][j]="*";
            k++;
        //System.out.println(data[i][j]);
        }
        }
         JTable table1 = new JTable(data, columnNames);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       // for(int i=0;i<columnSize;i++){
        //table1.getColumnModel().getColumn(i).setPreferredWidth(100);
        
        //}
          //  MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();

    //set TableCellRenderer into a specified JTable column class
    //table1.setDefaultRenderer(String[].class, renderer);

    //or, set TableCellRenderer into a specified JTable column
   // for (int column = 0; column < table1.getColumnCount(); column++) {
        //t width = 100; // Min width
        //for (int row = 0; row < table1.getRowCount(); row++) {
           // TableCellRenderer renderer = table.getCellRenderer(row, column);
           
           // Component comp = table.prepareRenderer(renderer, row, column);
           // width = Math.max(comp.getPreferredSize().width +1 , width);
           
        //}
        //table1.getColumnModel().getColumn(column).setCellRenderer(renderer);
       // if(width > 300)
           // width=300;
            //table1.getColumnModel().getColumn(column).setCellRenderer(renderer);
           //columnModel.getColumn(column).setPreferredWidth(width);
    //}
    
    
        
        resizeColumnWidth(table1);
         JScrollPane scrollPane1=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
       
        scrollPane1.setBounds(40, 100, 600, 400);
        jPanel1.add(scrollPane1);
        //add();
         //System.out.println("result working");
       resultTable=table1;
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(print)
                        .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(print)
                .addContainerGap(389, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
           MessageFormat header = new MessageFormat(roomName);
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
    try {
        resultTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    } catch (java.awt.print.PrinterAbortException e) {
    } catch (PrinterException ex) {
        //Logger.getLogger(employee_info.class.getName()).log(Level.SEVERE, null, ex);
           System.err.println("Error printing: " + ex.getMessage());
    }
    }//GEN-LAST:event_printActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
