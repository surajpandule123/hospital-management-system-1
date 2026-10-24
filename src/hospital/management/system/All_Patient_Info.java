package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {

    All_Patient_Info(){

        JPanel panel=new JPanel();
        panel.setBounds(5,4,1280,670);
        panel.setBackground(new Color(17, 194, 153));
        panel.setLayout(null);
         add(panel);

         JTable table=new JTable();
         table.setBounds(20,60,1200,300);
         table.setBackground(new Color(17, 194, 153));
         panel.add(table);

         JLabel label=new JLabel("Cards ");
         label.setBounds(22,20,200,40);
         label.setFont(new Font("Tahoma",Font.BOLD,17));
         label.setBackground(Color.black);
         panel.add(label);

        JLabel label2=new JLabel("Card No ");
        label2.setBounds(170,20,200,40);
        label2.setFont(new Font("Tahoma",Font.BOLD,17));
        label2.setBackground(Color.black);
        panel.add(label2);

        JLabel label3=new JLabel("Name ");
        label3.setBounds(320,20,200,40);
        label3.setFont(new Font("Tahoma",Font.BOLD,17));
        label3.setBackground(Color.black);
        panel.add(label3);

        JLabel label4=new JLabel("Gender ");
        label4.setBounds(470,20,200,40);
        label4.setFont(new Font("Tahoma",Font.BOLD,17));
        label4.setBackground(Color.black);
        panel.add(label4);

        JLabel label5=new JLabel("Disease ");
        label5.setBounds(620,20,200,40);
        label5.setFont(new Font("Tahoma",Font.BOLD,17));
        label5.setBackground(Color.black);
        panel.add(label5);

        JLabel label6=new JLabel("Room No ");
        label6.setBounds(770,20,200,40);
        label6.setFont(new Font("Tahoma",Font.BOLD,17));
        label6.setBackground(Color.black);
        panel.add(label6);

        JLabel label7=new JLabel("Time ");
        label7.setBounds(920,20,200,40);
        label7.setFont(new Font("Tahoma",Font.BOLD,17));
        label7.setBackground(Color.black);
        panel.add(label7);

        JLabel label8=new JLabel("Deposite ");
        label8.setBounds(1070,20,200,40);
        label8.setFont(new Font("Tahoma",Font.BOLD,17));
        label8.setBackground(Color.black);
        panel.add(label8);

        JButton b1=new JButton("Back ");
        b1.setBounds(90,440,130,30);
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
             String q="Select * from Patient_Info";
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

        new All_Patient_Info();

    }
}
