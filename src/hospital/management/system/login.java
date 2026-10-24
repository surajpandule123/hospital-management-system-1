package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;

    JPasswordField jPasswordField;
    JButton b1,b2;


    login(){

      JLabel namelabel=new JLabel("Username   : ");
      namelabel.setBounds(95,280,170,50);
      namelabel.setFont(new Font("Tahoma", Font.BOLD,22));
       add(namelabel);

        JLabel password =new JLabel("Password    : ");
        password.setBounds(95,335,170,50);
        password.setFont(new Font("Tahoma", Font.BOLD,22));
        add(password);

        JLabel label1=new JLabel("Hospital Management System");
        label1.setBounds(220,18,850,190);
        label1.setFont(new Font("Arial",Font.BOLD,57));
        label1.setForeground(Color.black);
        add(label1);

        textField =new JTextField();
        textField.setBounds(295,295,150,25);
        textField.setFont(new Font("Tahoma",Font.BOLD,15));
        textField.setBackground(new Color(252, 61, 3));
        add(textField);

        jPasswordField =new JPasswordField();
        jPasswordField.setBounds(295,350,150,25);
        jPasswordField.setFont(new Font("Tahoma",Font.BOLD,15));
        jPasswordField.setBackground(new Color(252, 61, 3));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/hosptal.png"));
        Image i1= imageIcon.getImage().getScaledInstance(740,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1= new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(560,135,740,600);
         add(label);

         b1=new JButton("login");
         b1.setBounds(108,450,110,24);
         b1.setBackground(Color.black);
         b1.setForeground(Color.white);
         b1.addActionListener(this);
         add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(295,450,110,24);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(3, 173, 252));
        setSize(880,550);
        setLayout(null);
        setLocation(250,132);
        setVisible(true);
    }

    public static void main(String[] args){

        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q="select * from login where ID='"+user+"' and PW='"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()){
                   new reception();
                   setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }


            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
          System.exit(20);

        }
    }
}