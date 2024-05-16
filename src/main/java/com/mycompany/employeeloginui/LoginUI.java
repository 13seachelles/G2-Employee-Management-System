package com.mycompany.employeeloginui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginUI {
    private JFrame f = new JFrame("Employee Management System");
    private JLabel title, title1,lblUsername, lblEmployeeID, lblPassword, labelimg;
    private JButton btnLogin;
    private JTextField txtfldUsername, txtfldEmployeeID;
    private JPasswordField txtfldPassword;
    private JPanel panel1;
    
    LoginUI(){
        f.setSize(900,600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txtfldEmployeeID = new JTextField();
        txtfldEmployeeID.setBounds(250, 245, 250, 25);
        
        txtfldUsername = new JTextField();
        txtfldUsername.setBounds(250, 290, 250, 25);
        
        txtfldPassword = new JPasswordField();
        txtfldPassword.setBounds(250, 340, 250, 25);
        
        title = new JLabel ("Nice to see you again ");
        title.setBounds (200, 95,500,100);
        title.setFont (new Font("Arial", Font.PLAIN , 20));
        
        title1 = new JLabel ("WELCOME BACK  ");
        title1.setBounds (100, 130,500,100);
        title1.setFont (new Font("Arial", Font.PLAIN , 50));
        
        lblUsername = new JLabel("Employee ID:");
        lblUsername.setBounds(125, 205, 500, 100);
        lblUsername.setFont(new Font("Arial",Font.PLAIN ,20));
        
        lblEmployeeID = new JLabel ("Username:");
        lblEmployeeID.setBounds(125, 250, 500, 100);
        lblEmployeeID.setFont(new Font("Arial",Font.PLAIN,20));
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(125, 300, 500, 100);
        lblPassword.setFont(new Font("Arial",Font.PLAIN,20));
        
        btnLogin = new JButton("Log In");
        btnLogin.setBounds(250, 380, 250, 50);
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Lato",Font.BOLD,25));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtfldUsername.getText();
                String employeeid = txtfldEmployeeID.getText();
                String password = txtfldPassword.getText();
                if (name.equals("admin")||name.equals("staff")||name.equals("manager") 
                    && employeeid.equals("admin")||employeeid.equals("staff")||employeeid.equals("manager")
                        && password.equals("admin")||password.equals("staff")||password.equals("manager")) {
                    f.dispose();
                    new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(btnLogin, "Invalid Name or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ImageIcon i1 = new ImageIcon("Images/bg.png");
        Image i2 = i1.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
       
        labelimg = new JLabel(i3);
        
        panel1 = new JPanel();
        panel1.setBounds(0,-10,900,600);
        panel1.setBackground(Color.BLACK);
        
        //will add the label to the panel
        panel1.add(labelimg);
        
        f.add(title1);
        f.add(title);
        f.add(txtfldUsername);
        f.add(txtfldEmployeeID);
        f.add(txtfldPassword);
        f.add(lblUsername);
        f.add(lblEmployeeID);
        f.add(lblPassword);
        f.add(btnLogin);
        f.add(panel1);

        //Visible to True
        f.setVisible(true);
    }
    
}