package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame {

    JTable table;

    room(){

        JPanel panel=new JPanel();
        panel.setBounds(0,0,1300,900);
        panel.setBackground(new Color(17, 194, 153));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/room1.jpg"));
        Image image =imageIcon.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(420,160,1100,340);
        panel.add(label);

        JLabel label1=new JLabel("Room No");
        label1.setBounds(29,7,350,110);
        label1.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label1);

        JLabel label2=new JLabel("Availability");
        label2.setBounds(165,7,350,110);
        label2.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label2);

        JLabel label3=new JLabel("Price ");
        label3.setBounds(300,7,350,110);
        label3.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label3);

        JLabel label4=new JLabel("Bed Type ");
        label4.setBounds(440,7,350,110);
        label4.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label4);

        JButton back=new JButton("back");
        back.setBounds(220,420,130,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);

            }
        });


        table = new JTable();
        table.setBounds(25,80,550,250);
        table.setBackground(new Color(17, 194, 153));
        panel.add(table);

        try{

            conn c=new conn();
            String q="select * from room";
            ResultSet resultSet= c.statement.executeQuery(q);
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
      new room();
    }
}
