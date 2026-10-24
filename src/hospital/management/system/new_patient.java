package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class new_patient extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField textFieldNumber,textName,TextFieldDisease,TextFieldDeposite;

    JRadioButton r1,r2;

    Choice c1;

    JLabel date;
    JButton b1,b2;



    new_patient(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,1290,800);
        panel.setBackground(new Color(52, 133, 158));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageicon= new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageicon.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1= new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(820,150,350,300);
        panel.add(label);


        JLabel labelName= new JLabel("NEW PATIENT FORM");
        labelName.setBounds(140,8,600,80);
        labelName.setFont(new Font("tahoma",Font.BOLD,25));
        panel.add(labelName);


        JLabel labelId= new JLabel("ID :");
        labelId.setBounds(72,65,400,50);
        labelId.setFont(new Font("Tahoma",Font.BOLD,17));
        labelId.setForeground(Color.CYAN);
        panel.add(labelId);

       comboBox = new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving License"});
       comboBox.setBounds(380,81,150,20);
       comboBox.setBackground(new Color(60, 214, 99));
       comboBox.setForeground(Color.white);
       comboBox.setFont(new Font("Tahoma",Font.BOLD,17));
       panel.add(comboBox);

       JLabel labelNumber=new JLabel("Number :");
       labelNumber.setBounds(68,84,300,100);
       labelNumber.setFont(new Font("Tahoma",Font.BOLD,17));
       labelNumber.setForeground(Color.CYAN);
       panel.add(labelNumber);

       textFieldNumber=new JTextField();
       textFieldNumber.setBounds(380,124,150,20);
       panel.add(textFieldNumber);

       JLabel labelName1=new JLabel("Name   :");
       labelName1.setBounds(68,120,300,100);
       labelName1.setFont(new Font("Tahoma",Font.BOLD,17));
       labelName1.setForeground(Color.CYAN);
       panel.add(labelName1);

       textName=new JTextField();
       textName.setBounds(380,161,150,20);
       panel.add(textName);

       JLabel labelGender=new JLabel("Gender :");
       labelGender.setBounds(68,158,300,100);
       labelGender.setForeground(Color.CYAN);
       labelGender.setFont(new Font("Tahoma",Font.BOLD,17));
       panel.add(labelGender);

       r1=new JRadioButton("Male");
       r1.setFont(new Font("Tahoma",Font.BOLD,17));
       r1.setForeground(Color.white);
       r1.setBackground(new Color(22, 59, 77));
       r1.setBounds(378,200,70,18);
       panel.add(r1);


       r2=new JRadioButton("Female");
       r2.setFont(new Font("Tahoma",Font.BOLD,17));
       r2.setBackground(new Color(22, 59, 77));
       r2.setForeground(Color.white);
       r2.setBounds(460,200,100,18);
       panel.add(r2);

        JLabel labelDisease=new JLabel("Disease :");
        labelDisease.setBounds(68,194,300,100);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,17));
        labelDisease.setForeground(Color.CYAN);
        panel.add(labelDisease);

        TextFieldDisease=new JTextField();
        TextFieldDisease.setBounds(380,235,150,20);
        panel.add(TextFieldDisease);

        JLabel labelRoom=new JLabel("Room   :");
        labelRoom.setBounds(68,230,300,100);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,17));
        labelRoom.setForeground(Color.CYAN);
        panel.add(labelRoom);

        c1 =new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        c1.setBounds(380,269,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,16));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(245, 44, 225));
        panel.add(c1);

        JLabel labelDate=new JLabel("Time    :");
        labelDate.setBounds(68,263,300,100);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,17));
        labelDate.setForeground(Color.CYAN);
        panel.add(labelDate);

        Date date1=new Date();

        date=new JLabel(""+date1);
        date.setBounds(380,307,260,16);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposite=new JLabel("Deposite :");
        labelDeposite.setBounds(68,299,300,100);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,17));
        labelDeposite.setForeground(Color.CYAN);
        panel.add(labelDeposite);

        TextFieldDeposite=new JTextField();
        TextFieldDeposite.setBounds(380,339,150,20);
        panel.add(TextFieldDeposite);


        b1=new JButton("Add");
        b1.setBounds(150,415,110,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        panel.add(b1);
        b1.addActionListener(this);

        b2=new JButton("Back");
        b2.setBounds(315,415,110,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);


//         setUndercorated(true);
        setSize(880,550);
        setLayout(null);
        setLocation(250,134);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){
            conn c=new conn();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN ="Male";
            }else if (r2.isSelected()){
                radioBTN="Female";
            }
           String s1=(String)comboBox.getSelectedItem();
            String s2= textFieldNumber.getText();
            String s3=textName.getText();
            String s4=radioBTN;
            String s5=TextFieldDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=TextFieldDeposite.getText();


            try{
                String q="insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update room set Available = 'Occupied' where room_no = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
    public static void main(String[]args){

        new new_patient();
    }
}
