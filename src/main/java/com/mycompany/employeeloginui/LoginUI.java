package com.mycompany.employeeloginui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI {
    private JFrame f = new JFrame("Employee Management System");
    private JLabel lblUsername, lblEmployeeID, lblPassword, labelimg;
    private JButton btnLogin;
    private JTextField txtfldUsername, txtfldEmployeeID;
    private JPasswordField txtfldPassword;
    private JPanel panel1;
    
    LoginUI(){
        f.setSize(900,600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txtfldUsername = new JTextField();
        txtfldUsername.setBounds(340, 240, 250, 25);
        
        txtfldEmployeeID = new JTextField();
        txtfldUsername.setBounds(340, 300, 250, 25);
        
        txtfldPassword = new JPasswordField();
        
        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(200, 205, 500, 100);
        lblUsername.setFont(new Font("Arial",Font.PLAIN ,20));
        
        lblEmployeeID = new JLabel ("Employee ID:");
        lblEmployeeID.setBounds(200, 265, 500, 100);
        lblEmployeeID.setFont(new Font("Arial",Font.PLAIN,20));
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(200, 325, 500, 100);
        lblPassword.setFont(new Font("Arial",Font.PLAIN,20));
        
        btnLogin = new JButton("Log In");
        btnLogin.setBounds(340, 410, 250, 55);
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Lato",Font.BOLD,25));
        
        ImageIcon i1 = new ImageIcon("Images/bg.png");
        Image i2 = i1.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        
        //label for the pic
        labelimg = new JLabel(i3);
        
        //panel for image on the ui and it setttings
        panel1 = new JPanel();
        panel1.setBounds(0,-10,900,600);
        panel1.setBackground(Color.BLACK);
        
        //will add the label to the panel
        panel1.add(labelimg);
        
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