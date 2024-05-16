package com.mycompany.employeeloginui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class EmployeeList extends JFrame {
    
    JFrame Frame = new JFrame("Employee Management System");
    JLabel Label = new JLabel("Employee Dashboard");
    JScrollPane scrollmenu;
    JPanel employeeContainer; // Panel to contain employee records
    
    EmployeeList(){  
        
        // Frame
        Frame.setSize(900, 580);
        Frame.setLayout(null);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        
        // Background Image
        ImageIcon backgroundImage = new ImageIcon("background.jpg"); // Provide the path to your image file
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 900, 555);
        Frame.add(backgroundLabel);
        
        
        // Employee Dashboard Label
        Label.setFont(new Font("Bookman Old Style", Font.BOLD, 28));
        Label.setForeground(Color.BLACK);
        Label.setBounds(300, 20, 350, 40);
        backgroundLabel.add(Label);
        
        // Scroll Panel
        employeeContainer = new JPanel();
        employeeContainer.setLayout(new BoxLayout(employeeContainer, BoxLayout.Y_AXIS));
        
        scrollmenu = new JScrollPane(employeeContainer);
        scrollmenu.setBounds(80, 100, 700, 340);
        backgroundLabel.add(scrollmenu);
        
        // Adding logo
        ImageIcon logoImage = new ImageIcon("OBRA.png"); // Provide the path to your logo image file
        Image scaledLogoImage = logoImage.getImage().getScaledInstance(250, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(20, 5, 120, 90);
        backgroundLabel.add(logoLabel);
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 12));
        backButton.setBounds(700,470,80,45);
        backgroundLabel.add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
//            new MainMenu;    
            }
        });
          
        // Adding sample employee records
        addEmployee("John K. Makulit", "Tech Specialist", "IT");
        addEmployee("John Doe", "Designer", "Operations");
        
        Frame.setVisible(true);
        Frame.setResizable(false);
    }

    private void addEmployee(String name, String position, String department) {
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new BorderLayout());
        employeePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel nameLabel = new JLabel("Employee Name: " + name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.BLACK);
        
        JLabel positionLabel = new JLabel("Position: "+ position);
        positionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        positionLabel.setForeground(Color.BLACK);
        
        JLabel departmentLabel = new JLabel("Department: " + department);
        departmentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        departmentLabel.setForeground(Color.BLACK);
        
        JButton viewButton = new JButton("View Information");
        viewButton.setFont(new Font("Arial", Font.BOLD, 12));
        
        // TBD, would probs change JOptionPane to a new frame soon instead of a dialog box
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Frame, "Job Description for: " + name ); 
            }
        });      
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 1));
     
        textPanel.add(nameLabel);
        textPanel.add(positionLabel);
        textPanel.add(departmentLabel);
        
        employeePanel.add(textPanel, BorderLayout.WEST);
        employeePanel.add(viewButton, BorderLayout.EAST);
           
        employeeContainer.add(employeePanel);
        employeeContainer.revalidate();
    }



}