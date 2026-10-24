package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ambulance extends JFrame {
    ambulance(){
        JPanel panel=new JPanel();
        panel.setBounds(5,4,1280,670);
        panel.setBackground(new Color(17, 194, 153));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(20,60,1200,300);
        table.setBackground(new Color(17, 194, 153));
        panel.add(table);

        JLabel label=new JLabel("name ");
        label.setBounds(35,20,200,40);
        label.setFont(new Font("Tahoma",Font.BOLD,17));
        label.setBackground(Color.black);
        panel.add(label);

        JLabel label2=new JLabel("gender ");
        label2.setBounds(277,20,200,40);
        label2.setFont(new Font("Tahoma",Font.BOLD,17));
        label2.setBackground(Color.black);
        panel.add(label2);

        JLabel label3=new JLabel("car name");
        label3.setBounds(515,20,200,40);
        label3.setFont(new Font("Tahoma",Font.BOLD,17));
        label3.setBackground(Color.black);
        panel.add(label3);

        JLabel label4=new JLabel("available");
        label4.setBounds(757,20,200,40);
        label4.setFont(new Font("Tahoma",Font.BOLD,17));
        label4.setBackground(Color.black);
        panel.add(label4);

        JLabel label5=new JLabel("location");
        label5.setBounds(997,20,200,40);
        label5.setFont(new Font("Tahoma",Font.BOLD,17));
        label5.setBackground(Color.black);
        panel.add(label5);

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
            String q="Select * from ambulance";
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
        new ambulance();
    }
}
