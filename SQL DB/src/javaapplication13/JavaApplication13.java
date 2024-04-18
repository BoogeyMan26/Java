package javaapplication13;

import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class JavaApplication13 {

  static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
  static final String CONN_STRING      = "jdbc:mysql://localhost: 3306/?user=root&password=root";
  Enumeration<Driver> drivers=DriverManager.getDrivers();

  Connection conn = null;
  Statement  st   = null;

  JTextField name;
  JTextField age;
  JButton    proceed;

  public JavaApplication13()
  {
    JFrame useradd = new JFrame("Add user to db");
    name = new JTextField(10);
    age = new JTextField(10);
    useradd.setLayout(new GridLayout(0, 1));
    JPanel pane = new JPanel(new GridLayout(0, 1));
    useradd.add(pane);
    pane.add(new JLabel("name: "));
    pane.add(name);
    pane.add(new JLabel("age: "));
    pane.add(age);
    proceed = new JButton("Add that user");
    pane.add(proceed);
    proceed.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          conn= DriverManager.getConnection(CONN_STRING);
          st = (Statement) conn.createStatement();
          st.execute("insert into user (name) values('"+name.getText()+"')");
          st.executeUpdate("insert into user (age) values('"+age.getText()+"')");
          JOptionPane.showMessageDialog(null, "Inserted Successfully!");
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
      }});
    useradd.pack();
    useradd.setSize(300,200);
    useradd.setVisible(true);
  }

  public static void main(String[] args)
  {
    new JavaApplication13();
  }
}