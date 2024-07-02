//Added SQL Commands

package main.java.com.mycompany.employeeloginui;

import java.sql.*;
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
        ImageIcon backgroundImage = new ImageIcon("Images/background.jpg"); // Provide the path to your image file
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
        ImageIcon logoImage = new ImageIcon("Images/OBRA.png"); // Provide the path to your logo image file
        Image scaledLogoImage = logoImage.getImage().getScaledInstance(250, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(20, 5, 120, 90);
        backgroundLabel.add(logoLabel);
        
        JButton viewButton = new JButton("<html>View All Employee<br>Information</html>");
        viewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        viewButton.setBounds(620, 470, 160, 45);
        backgroundLabel.add(viewButton);
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        backButton.setBounds(530,470,80,45);
        backgroundLabel.add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                Frame.dispose();
                new MainMenu();    
            }
        });
        
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.dispose();
                new Listtt(); 
            }
        });
        
         try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_oop", "root", "root");
            Statement st = conn.createStatement();
            String query = "SELECT * FROM tbl_employee";
            ResultSet rs = st.executeQuery(query);
           
            while(rs.next()){
                String employeeID = rs.getString("EmployeeID");
                String name = rs.getString("Name");
                String position = rs.getString("Position");
                String department = rs.getString("Department");
               
                addEmployee(employeeID, name, position, department);
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
        }
          

        
        Frame.setVisible(true);
        Frame.setResizable(false);
    }

    private void addEmployee(String employeeID, String name, String position, String department) {
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new BorderLayout());
        employeePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel employeeIDLabel = new JLabel("Employee ID: " + employeeID);
        employeeIDLabel.setFont(new Font("Arial", Font.BOLD, 18));
        employeeIDLabel.setForeground(Color.BLACK);
        
        JLabel nameLabel = new JLabel("Employee Name: " + name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.BLACK);
        
        JLabel positionLabel = new JLabel("Position: "+ position);
        positionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        positionLabel.setForeground(Color.BLACK);
        
        JLabel departmentLabel = new JLabel("Department: " + department);
        departmentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        departmentLabel.setForeground(Color.BLACK);
        
       
        
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(4, 1));
        
        textPanel.add(employeeIDLabel);
        textPanel.add(nameLabel);
        textPanel.add(positionLabel);
        textPanel.add(departmentLabel);
        
        employeePanel.add(textPanel, BorderLayout.WEST);
       
           
        employeeContainer.add(employeePanel);
        employeeContainer.revalidate();
    }



}