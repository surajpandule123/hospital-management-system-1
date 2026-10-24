package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,4,1300,670);
        panel.setBackground(new Color(63, 224, 211));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/update.png.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label =new JLabel(imageIcon1);
        label.setBounds(630,60,700,500);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(180,17,330,80);
        label1.setFont(new Font("Tahoma",Font.BOLD,27));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2=new JLabel("Name       :");
        label2.setBounds(97,68,100,143);
        label2.setFont(new Font("Tahoma",Font.PLAIN,19));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice= new Choice();
        choice.setBounds(370,129,180,147);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("name"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel label3=new JLabel("Room no  :");
        label3.setBounds(93,106,100,150);
        label3.setFont(new Font("Tahoma",Font.PLAIN,19));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textField=new JTextField();
        textField.setBounds(370,170,180,22);
        panel.add(textField);

        JLabel label4=new JLabel("In-Time    :");
        label4.setBounds(93,149,100,150);
        label4.setFont(new Font("Tahoma",Font.PLAIN,19));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textField1=new JTextField();
        textField1.setBounds(370,213,180,22);
        panel.add(textField1);

        JLabel label5=new JLabel("Amount Paid :");
        label5.setBounds(92,190,160,150);
        label5.setFont(new Font("Tahoma",Font.PLAIN,19));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textField2=new JTextField();
        textField2.setBounds(370,256,180,22);
        panel.add(textField2);

        JLabel label6=new JLabel("Pending  Rs  :");
        label6.setBounds(92,232,160,150);
        label6.setFont(new Font("Tahoma",Font.PLAIN,19));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textField3=new JTextField();
        textField3.setBounds(370,298,180,22);
        panel.add(textField3);

        JButton check=new JButton("Check");
        check.setBounds(95,398,100,24);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q= "select * from patient_info where Name='"+id+"'";
                try{
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField.setText(resultSet.getString("Room_Number"));
                        textField1.setText(resultSet.getString("Time"));
                        textField2.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1=c.statement.executeQuery("select * from room where room_no= '"+textField.getText()+"'");
                    while(resultSet1.next()){
                        String price=resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textField2.getText());
                        textField3.setText(""+amountPaid);
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update=new JButton("Update");
        update.setBounds(260,398,100,24);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c=new conn();
                    String q=choice.getSelectedItem();
                    String room=textField.getText();
                    String time=textField1.getText();
                    String amount=textField2.getText();
                    c.statement.executeUpdate("update patient_info set Room_number='"+room+"', Time='"+time+"', Deposite='"+amount+"' where name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Update Successfully");
                    setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(425,398,100,24);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(880,550);
        setLayout(null);
        setLocation(250,132);
        setVisible(true);
    }

    public static void main(String[]args){
        new update_patient_details();
    }
}
