package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

      JPanel panel=new JPanel();
      panel.setBounds(5,0,1300,670);
      panel.setLayout(null);
      panel.setBackground(new Color(17, 194, 153));
      add(panel);

      JTable table=new JTable();
      table.setBounds(200,90,600,90);
      table.setFont(new Font("Tahoma",Font.BOLD,13));
      table.setBackground(new Color(17, 194, 153));
      panel.add(table);

      try{
          conn c=new conn();
          String q="select * from department";
          ResultSet resultSet=c.statement.executeQuery(q);
          table.setModel(DbUtils.resultSetToTableModel(resultSet));

      }catch(Exception e){
          e.printStackTrace();

        }

      JLabel label1=new JLabel("Dept_Name ");
      label1.setBounds(200,28,200,50);
      label1.setFont(new Font("Tahoma",Font.BOLD,16));
      label1.setForeground(Color.black);
      panel.add(label1);

        JLabel label2=new JLabel("Phone_No ");
        label2.setBounds(500,28,200,50);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.black);
        panel.add(label2);

        JButton b1=new JButton("Back");
        b1.setBounds(300,250,125,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(880,550);
        setLayout(null);
        setLocation(250,134);
        setVisible(true);
    }

    public static void main(String[]args){

        new Department();

    }

}
