package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {

    patient_discharge(){

        JPanel panel=new JPanel();
        panel.setBounds(5,4,1300,670);
        panel.setBackground(new Color(63, 224, 211));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("Check Out ");
        label.setBounds(220,40,240,60);
        label.setFont(new Font("Tahoma",Font.BOLD,28));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label1=new JLabel("Customer Id :");
        label1.setBounds(80,115,200,50);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label1);

        Choice choice=new Choice();
        choice.setBounds(330,130,160,50);
        panel.add(choice);
         try{
             conn c=new conn();
             ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
             while(resultSet.next()){
                 choice.add(resultSet.getString("number"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }

        JLabel label2=new JLabel("Room No     :");
        label2.setBounds(80,170,200,50);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label2);

        JLabel RNo=new JLabel("");
        RNo.setBounds(328,172,200,50);
        RNo.setForeground(Color.white);
        RNo.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(RNo);

        JLabel label3=new JLabel("In  Time      :");
        label3.setBounds(80,230,200,50);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label3);

        JLabel intime=new JLabel("");
        intime.setBounds(328,220,250,50);
        intime.setForeground(Color.white);
        intime.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(intime);

        JLabel label4=new JLabel("Out Time     :");
        label4.setBounds(80,285,200,50);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label4);

        Date date=new Date();

        JLabel ot=new JLabel(""+date);
        ot.setBounds(330,285,250,50);
        ot.setForeground(Color.white);
        ot.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(ot);

        JButton b1=new JButton("Discharge");
        b1.setBounds(70,400,110,25);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{
                 c.statement.executeUpdate("delete from patient_info where number='"+choice.getSelectedItem()+"'");
                 c.statement.executeUpdate("update room set Available='available' where room_no='"+RNo.getText()+"'");
                 JOptionPane.showMessageDialog(null,"Done");
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b2=new JButton("Check");
        b2.setBounds(240,400,110,25);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{
                   ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number= '"+choice.getSelectedItem()+"'");
                   while(resultSet.next()){
                       RNo.setText(resultSet.getString("Room_number"));
                       intime.setText(resultSet.getString("Time"));
                   }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b3=new JButton("Back");
        b3.setBounds(400,400,110,25);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
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
        new patient_discharge();
    }
}
