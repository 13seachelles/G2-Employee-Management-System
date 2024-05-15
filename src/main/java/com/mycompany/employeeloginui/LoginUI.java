package com.mycompany.employeeloginui;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends Frame{
    LoginUI(){
        JFrame f = new JFrame();
        f.setSize(900,600);
        f.setLayout(null);
        f.setTitle("Employee Management System");
        f.getContentPane().setBackground(new java.awt.Color(204,204,255));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        TextField txtfldUsername = new TextField();
        TextField txtfldEmployeeID = new TextField();
        JPasswordField txtfldPassword = new JPasswordField();
        Label lblUsername = new Label("Username:");
        lblUsername.setFont(new Font("Arial",Font.PLAIN ,20));
        Label lblEmployeeID = new Label ("Employee ID:");
        lblEmployeeID.setFont(new Font("Arial",Font.PLAIN,20));
        Label lblPassword = new Label("Password:");
        lblPassword.setFont(new Font("Arial",Font.PLAIN,20));
        Button btnLogin = new Button("Log In");
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Lato",Font.BOLD,25));
        
        f.add(txtfldUsername);
        f.add(txtfldEmployeeID);
        f.add(txtfldPassword);
        f.add(lblUsername);
        f.add(lblEmployeeID);
        f.add(lblPassword);
        f.add(btnLogin);
         
        txtfldUsername.setBounds(340, 240, 250, 25);
        txtfldEmployeeID.setBounds(340, 300, 250, 25);
        txtfldPassword.setBounds(340, 360, 250, 25);
        lblUsername.setBounds(200, 205, 500, 100);
        lblEmployeeID.setBounds(200, 265, 500, 100);
        lblPassword.setBounds(200, 325, 500, 100);
        btnLogin.setBounds(340, 410, 250, 55);
        
        //Visible to True
        f.setVisible(true);
    }
    
}
