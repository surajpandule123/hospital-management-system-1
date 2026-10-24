package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_room extends JFrame {

    Search_room(){

        JPanel panel=new JPanel();
        panel.setBounds(5,4,1300,650);
        panel.setBackground(new Color(63, 224, 211));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("Search For Room");
        label.setBounds(260,28,350,50);
        label.setForeground(Color.white);
        label.setFont(new Font("tahoma",Font.BOLD,29));
        panel.add(label);

        JLabel status=new JLabel("Status  :");
        status.setBounds(175,65,200,100);
        status.setForeground(Color.black);
        status.setFont(new Font("tahoma",Font.BOLD,20));
        panel.add(status);

        Choice choice=new Choice();
        choice.setBounds(495,108,130,140);
        choice.add("   Available");
        choice.add("   Occupied");
        panel.add(choice);

        JTable table=new JTable();
        table.setBounds(65,255,900,250);
        table.setBackground(new Color(63, 224, 211));
        table.setForeground(Color.white);
        panel.add(table);

        try{
          conn c=new conn();
          String q="select * from room";
          ResultSet resultSet=c.statement.executeQuery(q);
          table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel rno=new JLabel("Room No");
        rno.setBounds(70,220,200,25);
        rno.setFont(new Font("Tahoma",Font.BOLD,16));
        rno.setForeground(Color.black);
        panel.add(rno);

        JLabel available=new JLabel("Availability");
        available.setBounds(290,220,200,25);
        available.setFont(new Font("Tahoma",Font.BOLD,16));
        available.setForeground(Color.black);
        panel.add(available);

        JLabel price=new JLabel("Price");
        price.setBounds(515,220,200,25);
        price.setFont(new Font("Tahoma",Font.BOLD,16));
        price.setForeground(Color.black);
        panel.add(price);

        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(740,220,200,25);
        bed.setFont(new Font("Tahoma",Font.BOLD,16));
        bed.setForeground(Color.black);
        panel.add(bed);

        JButton search=new JButton("Search");
        search.setBounds(180,550,130,25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from Room where Availability ='"+choice.getSelectedItem()+"'";
                try{
                    conn c=new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(420,550,130,25);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(880,550);
        setLayout(null);
        setLocation(250,0);
        setVisible(true);
    }

    public static void main(String[]args){
        new Search_room();
    }
}
