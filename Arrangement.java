/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examseatallotment;

import java.awt.BorderLayout;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Priyam Kumar
 */
class room
{
    int j,rid,row,col;
    String[] gridbnm;
    String[] gridsnm;
    long[] gridsno;
    long[] grid;
    String rnm;
    Set<Integer> myset=new TreeSet<>();
    void ab(int a,int b)
    {
        gridbnm=new String[a*b];
        gridsnm=new String[a*b];
        gridsno=new long[a*b];
        grid=new long[a*b];
        for(j=0;j<a*b;j++)
        {
            myset.add(j);
            gridsno[j]=0;
            grid[j]=-1;
        }
    }
};
class type
{
    int cid,strength,roll;
    String bnm,snm;
    type()
    {
        roll=1;
    }
};
public class Arrangement extends javax.swing.JFrame {

    /**
     * Creates new form Arrangement
     */
    AddClass addclass;
    AddRoom addroom;
     DefaultTableModel arrangeRoom; 
     DefaultTableModel arrangeclass; 
     DefaultTableModel dt; 
     room[] rr;
       
    public Arrangement(AddClass addclass,AddRoom addroom) {
        initComponents();
        //jTextField1.setVisible(false);
         jTextField1.setText("Loading....");
         jTextField1.setVisible(false);
          arrangeRoom=(DefaultTableModel) atable.getModel();
        this.addclass=addclass;
        this.addroom=addroom;
         DBConnection connect=new DBConnection();
                             connect.deleteAllotmentQuery();
      /*  JButton[] j=new JButton[r.modelRoom.getRowCount()];
        for(int i=0;i<r.modelRoom.getRowCount();i++)
        {  j[i]=new JButton(String.valueOf( r.modelRoom.getValueAt(i, 1)));
           j[i].setBounds(50,(i+1)*50 , 100, 20);
            add(j[i]);
        }
        */
       int temp,index,f,g,i,j,k;
        String str,str1;
        long seat,stu;
        seat=0;
        stu=0;
        Set<Integer> my=new TreeSet<>();
       // System.out.println("Enter no. of rooms : ");
      int m=addroom.modelRoom.getRowCount();
        
        rr=new room[m];
      int n=addclass.classRoom.getRowCount();;

        type[] tt=new type[n];
        int[] st=new int[n];
        int[] nm=new int[n];
         
        for(i=0;i<m;i++)
        {
            rr[i]=new room();
            my.add(i);
        //    System.out.println("Enter name of room and no. of row & column in room "+(i+1)+" : ");
            //String[] s1=inp.readLine().split(" ");
            
            rr[i].rnm=String.valueOf(addroom.modelRoom.getValueAt(i, 1));
            rr[i].row=Integer.parseInt(String.valueOf(addroom.modelRoom.getValueAt(i, 2)));
            rr[i].col=Integer.parseInt(String.valueOf(addroom.modelRoom.getValueAt(i, 3)));
            rr[i].ab(rr[i].row,rr[i].col);
            seat+=rr[i].row*rr[i].col;
            rr[i].rid=i;
        }
        
       // System.out.println("Enter no. of student types : ");
       
        for(i=0;i<n;i++)
        {
            tt[i]=new type();
           // System.out.println("Enter name of branch, semester and strength of class"+(i+1)+" : ");
           // String[] s1=inp.readLine().split(" ");
            tt[i].bnm=String.valueOf(addclass.classRoom.getValueAt(i, 1));
            tt[i].snm=String.valueOf(addclass.classRoom.getValueAt(i, 2));
            tt[i].strength=Integer.parseInt(String.valueOf(addclass.classRoom.getValueAt(i, 3)));
            stu+=tt[i].strength;
            tt[i].cid=i;
            st[i]=tt[i].strength;
            nm[i]=i;
        }
        
        if(seat<stu)
        {
           // System.out.println("No possible Arrangement(Seats are less than no. of students)!!");
            //Dialog d=new Dialog("No possible Arrangement(Seats are less than no. of students)!!");
            //d.setVisible(true);
            //this.dispose();
            JOptionPane.showMessageDialog(null,"No possible Arrangement(Seats are less than no. of students)!!");
            
            
        }
        else
        {
            for(i=0;i<n-1;i++)
            {
                for(j=0;j<n-1;j++)
                {
                    if(st[j]<st[j+1])
                    {
                        temp=st[j];
                        st[j]=st[j+1];
                        st[j+1]=temp;
                        temp=nm[j];
                        nm[j]=nm[j+1];
                        nm[j+1]=temp;
                    }
                }
            }
            g=0;
            while(stu>0)
            {
                stu--;
                g=0;
                index=nm[0];
                str1=""+(nm[0]+1);
                
                for(Integer it:my)
                {
                    i=it;
                    for(Integer cs:rr[i].myset)
                    {
                        f=1;
                     if(((cs)-1)>=0)
                        {
                            if((cs)%(rr[i].col)!=0)
                                if(rr[i].grid[(cs)-1]==nm[0])
                                    f=0;
                        }
                        if(((cs)+1)<rr[i].row*rr[i].col)
                        {
                            if((cs+1)%(rr[i].col)!=0)
                                if(rr[i].grid[(cs)+1]==nm[0])
                                    f=0;
                        }
                        if(((cs)-rr[i].col)>=0)
                        { 
                            if(rr[i].grid[(cs)-rr[i].col]==nm[0])
                                f=0;
                        }
                        if(((cs)+rr[i].col)<rr[i].row*rr[i].col)
                        {
                            if(rr[i].grid[(cs)+rr[i].col]==nm[0])
                                f=0;
                        }
                        if(f==1)
                        {
                            //str=""+(tt[index].roll);
                            rr[i].gridbnm[(cs)]=tt[index].bnm;
                            rr[i].gridsnm[(cs)]=tt[index].snm;
                            rr[i].gridsno[(cs)]=tt[index].roll;
                            rr[i].grid[(cs)]=nm[0];
                            //rr[i].grid[(cs)]=str1+"-"+tt[index].bnm+"-"+tt[index].snm+"-"+str;
                            tt[index].roll++;
                            rr[i].myset.remove(cs);
                            g=1;
                            
                              connect.writeAllotment(rr[i].rnm,tt[index].bnm,tt[index].snm,tt[index].roll-1);
                            break;
                        }         }
                    if(rr[i].myset.isEmpty())
                        my.remove(i);
                    if(g==1)
                        break;
                }
                
                if(g==1)
                {
                    st[0]--;
                    j=0;
                    while(j<n-1 && st[j]<st[j+1])
                    {
                        temp=st[j];
                        st[j]=st[j+1];
                        st[j+1]=temp;;
                        temp=nm[j];
                        nm[j]=nm[j+1];
                        nm[j+1]=temp;;
                        j++;
                    }
                    if(j<n-1 && st[j]==st[j+1])
                    {
                        temp=st[j];
                        st[j]=st[j+1];
                        st[j+1]=temp;
                        temp=nm[j];
                        nm[j]=nm[j+1];
                        nm[j+1]=temp;
                    }
                }
                else
                    break;    
            }
            
            if(g==0)
            {
               // System.out.println("Arrangement not possible!!");
               // Dialog d=new Dialog("Arrangement not possible!!");
                //d.setVisible(true);
                
                JOptionPane.showMessageDialog(null, "Arrangement not possible!!");
               // this.dispose();
                //.setVisible(false);
                
            }
            else
            {
                this.setVisible(true);
            }
           
        }
    for(i=0;i<addroom.modelRoom.getRowCount();i++)
    {arrangeRoom.insertRow(arrangeRoom.getRowCount(), new Object[]{arrangeRoom.getRowCount()+1,String.valueOf( addroom.modelRoom.getValueAt(i, 1))});
    
    }
       // table.setVisible(true);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        atable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true), "Arrangement\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Garamond", 1, 48), new java.awt.Color(255, 102, 102))); // NOI18N

        atable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.no", "Room Name"
            }
        ));
        jScrollPane1.setViewportView(atable);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examseatallotment/Slide-Show-icon (1).png"))); // NOI18N
        jButton1.setText("SHOW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search By Roll No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(107, 107, 107)
                .addComponent(jButton2)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};*/
        //sp2.repaint();
        //jLabel1.setText("Loading....");
        
        jTextField1.setVisible(true);
        String column=String.valueOf( addroom.modelRoom.getValueAt(atable.getSelectedRow(), 3));
        int columnSize=Integer.parseInt(column);
          String row=String.valueOf( addroom.modelRoom.getValueAt(atable.getSelectedRow(), 2));
         // System.out.println(atable.getSelectedRow()+" selected row");
        int rowSize=Integer.parseInt(row);
        String[] columnNames=new String[columnSize];
        //System.out.println(columnSize+ " column size");
      //  System.out.println(rowSize+ "row size");
        for(int i=0;i<columnSize;i++)
        {
        columnNames[i]=(i+1)+"";
       // System.out.println(columnNames[i]);
        }
       /* int k=0;
        Object[][] data =new Object[rowSize][columnSize];
        for(int i=0;i<rowSize;i++){
        
        for(int j=0;j<columnSize;j++){
        data[i][j]=rr[atable.getSelectedRow()].grid[k++];
        System.out.println(data[i][j]);
        }
        
        
        }System.out.println("kch hi");*/
      
       /* JTable table = new JTable(data, columnNames);
        data=null;
        System.gc();
       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0;i<columnSize;i++){
        table.getColumnModel().getColumn(i).setMinWidth(100);
        
        }
         JScrollPane scrollPane=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
       
      //  scrollPane.setBounds(100, 300, 300, 300);
        // add(scrollPane);*/
          Result r;
        try {
            
            r = new Result(rr[atable.getSelectedRow()].gridbnm,rr[atable.getSelectedRow()].gridsnm,rr[atable.getSelectedRow()].gridsno, columnNames, columnSize, rowSize, atable.getSelectedRow(),rr[atable.getSelectedRow()].rnm);
            
            r.setTitle("Automatic Seating Arrangement");
            
          r.setVisible(true);
       } catch (Exception ex) {
            Logger.getLogger(Arrangement.class.getName()).log(Level.SEVERE, null, ex);
        }
         //jLabel1.setText("");
         //jTextField1.setVisible(false);
   
        //table.revalidate();

//container.add(table, BorderLayout.CENTER);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SearchByRollNo s=new SearchByRollNo(addclass);
        s.setVisible(true);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Arrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
       
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Arrangement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable atable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
