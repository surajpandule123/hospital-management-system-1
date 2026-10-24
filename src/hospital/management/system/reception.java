package hospital.management.system;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

public class reception extends JFrame {

    reception(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,215,1525,670);
        panel.setBackground(new Color(73, 80, 110));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,450);
        panel1.setBackground(new Color(103, 111, 145));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image= i1.getImage().getScaledInstance(310,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel (i2);
        label.setBounds(1050,4,210,230);
        panel1.add(label);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1= i11.getImage().getScaledInstance(320,190,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel (i22);
        label1.setBounds(715,29,300,190);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,28,160,24);
        btn1.setBackground(Color.CYAN);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//               new login();
                new new_patient();
            }
        });

        JButton btn2= new JButton("Room");
        btn2.setBounds(30,79,160,24);
        btn2.setBackground(Color.cyan);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new room();

            }
        });

        JButton btn3=new JButton("Department");
        btn3.setBounds(30,126,160,24);
        btn3.setBackground(Color.cyan);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new Department();
            }
        });

        JButton btn4=new JButton("All Employee Info");
        btn4.setBounds(30,173,160,24);
        btn4.setBackground(Color.CYAN);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new Employee_info();
            }
        });

        JButton btn5=new JButton("Patient info");
        btn5.setBounds(235,28,160,24);
        btn5.setBackground(Color.CYAN);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new All_Patient_Info();
            }
        });

        JButton btn6= new JButton("Patient Discharge");
        btn6.setBounds(235,79,160,24);
        btn6.setBackground(Color.CYAN);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        JButton btn7=new JButton("Update Patient Details");
        btn7.setBounds(235,126,160,24);
        btn7.setBackground(Color.CYAN);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton btn8=new JButton("Hospital Ambulance");
        btn8.setBounds(235,173,160,24);
        btn8.setBackground(Color.CYAN);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ambulance ();
            }
        });

        JButton btn9=new JButton("Search Room");
        btn9.setBounds(445,28,160,24);
        btn9.setBackground(Color.CYAN);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_room();
            }
        });

        JButton btn10=new JButton("logout");
        btn10.setBounds(445,79,160,24);
        btn10.setBackground(Color.CYAN);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();
            }
        });



        getContentPane().setBackground(Color.WHITE);
        setSize(1900 ,1000);
        setVisible(true);
        setLayout(null);
    }

    public static void main(String[]args){
        new reception();
    }

}
