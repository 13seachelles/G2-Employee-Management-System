package main.java.com.mycompany.employeeloginui;

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
        
        title = new JLabel ("Nice to see you again ");
        title.setBounds (200, 95,500,100);
        title.setFont (new Font("Arial", Font.PLAIN , 20));
        
        title1 = new JLabel ("WELCOME BACK  ");
        title1.setBounds (100, 130,500,100);
        title1.setFont (new Font("Arial", Font.PLAIN , 50));
        
        lblEmployeeID = new JLabel("Employee ID:");
        lblEmployeeID.setBounds(125, 220, 500, 100);
        lblEmployeeID.setFont(new Font("Arial",Font.PLAIN ,20));
        
        txtfldEmployeeID = new JTextField();
        txtfldEmployeeID.setBounds(250, 245, 250, 50);
        addPlaceholderBehavior(txtfldEmployeeID, "Enter employee ID");
        
        lblUsername = new JLabel ("Username:");
        lblUsername.setBounds(125, 275, 500, 100);
        lblUsername.setFont(new Font("Arial",Font.PLAIN,20));
        
        txtfldUsername = new JTextField();
        txtfldUsername.setBounds(250, 300, 250, 50);
        addPlaceholderBehavior(txtfldUsername, "Enter username");
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(125, 330, 500, 100);
        lblPassword.setFont(new Font("Arial",Font.PLAIN,20));
        
        txtfldPassword = new JPasswordField();
        txtfldPassword.setBounds(250, 355, 250, 50);
        addPlaceholderBehavior(txtfldPassword, "Enter password");
        
        btnLogin = new JButton("Log In");
        btnLogin.setBounds(250, 420, 250, 50);
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Lato",Font.BOLD,25));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtfldUsername.getText();
                String employeeid = txtfldEmployeeID.getText();
                String password = txtfldPassword.getText();
                if (name.equals("admin")||name.equals("staff")
                    && employeeid.equals("admin")||employeeid.equals("staff")
                        && password.equals("admin")||password.equals("staff")) {
                    f.dispose();
                    new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(btnLogin, "Invalid Type", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ImageIcon image = new ImageIcon("Images/bg1.jpg");
        Image image1 = image.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon image2 = new ImageIcon(image1);
        labelimg = new JLabel(image2);
        
        panel1 = new JPanel();
        panel1.setBounds(0,-10,900,600);
        panel1.setBackground(Color.BLACK);
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

        f.setVisible(true);
    }
     private void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.setForeground(Color.GRAY);
        textField.setText(placeholder);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
    }

    
    private void addPlaceholderBehavior(JPasswordField passwordField, String placeholder) {
        passwordField.setEchoChar((char) 0);  
        passwordField.setForeground(Color.GRAY);
        passwordField.setText(placeholder);

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(placeholder)) {
                    passwordField.setText("");
                    passwordField.setEchoChar('\u2022'); 
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setEchoChar((char) 0); 
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText(placeholder);
                }
            }
        });
    }
}