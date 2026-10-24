package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info(){

         JPanel panel=new JPanel();
         panel.setBounds(5,5,1300,700);
         panel.setBackground(new Color(17, 194, 153));
         panel.setLayout(null);
         add(panel);

         JTable table=new JTable();
         table.setBounds(42,90,1100,100);
         table.setBackground(new Color(17, 194, 153));
         table.setFont(new Font("Tahoma",Font.BOLD,14));
         panel.add(table);

         JLabel label1=new JLabel("Name  ");
         label1.setBounds(41,27,200,80);
         label1.setBackground(Color.WHITE);
         label1.setFont(new Font("Tahoma",Font.BOLD,18));
         panel.add(label1);

        JLabel label2=new JLabel("Age  ");
        label2.setBounds(225,27,200,80);
        label2.setBackground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label2);

        JLabel label3=new JLabel("Phone No ");
        label3.setBounds(405,27,200,80);
        label3.setBackground(Color.WHITE);
        label3.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label3);

        JLabel label4=new JLabel("Salary ");
        label4.setBounds(590,27,200,80);
        label4.setBackground(Color.WHITE);
        label4.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label4);

        JLabel label5=new JLabel("Gmail ");
        label5.setBounds(775,27,200,80);
        label5.setBackground(Color.WHITE);
        label5.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label5);

        JLabel label6=new JLabel("Aadhar No ");
        label6.setBounds(960,27,200,80);
        label6.setBackground(Color.WHITE);
        label6.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label6);

        JButton b1=new JButton("Back ");
        b1.setBounds(100,350,130,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        try{
             conn c=new conn();
             String q="select * from EMP_INFO";
             ResultSet resultSet=c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));

         }catch(Exception e){
             e.printStackTrace();
         }

        setSize(880,550);
        setLayout(null);
        setLocation(250,134);
        setVisible(true);

    }

    public static void main(String[]args){

        new Employee_info();
    }

}
