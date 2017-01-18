/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examseatallotment;
/**
 *
 * @author Prateet
 */
     
// : c14:FileChooserTest.java
// Demonstration of File dialog boxes.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;

public class FileChooserTest extends JFrame{
  //private JTextField filename = new JTextField(), dir = new JTextField();

  //private JButton open = new JButton("Open");
  //, save = new JButton("Save");

  public FileChooserTest() {
    //JPanel p = new JPanel();
    //open.addActionListener(new OpenL());
    //p.add(open);
    //save.addActionListener(new SaveL());
    //p.add(save);
    //Container cp = getContentPane();
    //cp.add(p, BorderLayout.SOUTH);
    //dir.setEditable(false);
    //filename.setEditable(false);
    //p = new JPanel();
    //p.setLayout(new GridLayout(2, 1));
    //p.add(filename);
    //p.add(dir);
    //cp.add(p, BorderLayout.NORTH);
  }

  /*class OpenL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(FileChooserTest.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        //filename.setText(c.getSelectedFile().getName());
        //dir.setText(c.getCurrentDirectory().toString());
        try {
              Files.copy(new File(""+c.getCurrentDirectory().toString()+"\\"+c.getSelectedFile().getName()).toPath(),new File("C:\\Users\\Prateet Srivastava\\Desktop\\c.xls").toPath(),StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException ex) {
              Logger.getLogger(FileChooserTest.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }*/

  /*class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Save" dialog:
      int rVal = c.showSaveDialog(FileChooserTest.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }*/

  public static void main(String[] args) {
      
    //run(new FileChooserTest(), 250, 110);
    //new File
  }

  /*public void run(JFrame frame, int width, int height) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);
  }*/
  
  public int run(String branchName,String semester) {
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setSize(width, height);
    //frame.setVisible(true);
 int f=0;
    JFileChooser c = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(FileChooserTest.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        //filename.setText(c.getSelectedFile().getName());
        //dir.setText(c.getCurrentDirectory().toString());
        try {
              Files.copy(new File(""+c.getCurrentDirectory().toString()+"\\"+c.getSelectedFile().getName()).toPath(),new File("C:\\Users\\Priyam Kumar\\Desktop\\"+branchName+"-"+semester+".xls").toPath(),StandardCopyOption.REPLACE_EXISTING);
        f=1; 
        } catch (IOException ex) {
              Logger.getLogger(FileChooserTest.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      //if (rVal == JFileChooser.CANCEL_OPTION) {
        //filename.setText("You pressed cancel");
        //dir.setText("");
      //}
 return f; }
} ///:~


  





/*try {
              Files.copy(new File(""+c.getCurrentDirectory().toString()+"\\"+c.getSelectedFile().getName()).toPath(),new File("C:\\Users\\Prateet Srivastava\\Desktop\\b.xls").toPath(),StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException ex) {
              Logger.getLogger(FileChooserTest.class.getName()).log(Level.SEVERE, null, ex);
          }*/