/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.employeeloginui;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JFrame Acc = new JFrame("Employee Management System");
    private JLabel label1, label2;
    private JPanel panel1;
    private JButton BTN1,BTN2,BTN3,BTN4;
    
    MainMenu(){
        //frame
        Acc.setSize(900, 600);
        Acc.setLayout(null);
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          //label
        label1 = new JLabel("MAIN MENU");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD,60));
        label1.setBounds(270, 55, 500, 100);
       
        // Create four buttons
        
        BTN1 = new JButton("Employee List");
        BTN1.setBounds(300,180,300,50);
        BTN1.setBackground(Color.WHITE);
        BTN1.setFont(new Font("Arial", Font.BOLD,20));
        BTN1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Acc.dispose();
                new Listtt();
                
            }
        });
        
        BTN2 = new JButton("Employee Dashboard");
        BTN2.setBounds(300,260,300,50);
        BTN2.setBackground(Color.WHITE);
        BTN2.setFont(new Font("Arial", Font.BOLD,20));
        BTN2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Acc.dispose();
                new EmployeeList();
                
            }
        });
        
        BTN3 = new JButton("Report and Analytics");
        BTN3.setBounds(300,340,300,50);
        BTN3.setBackground(Color.WHITE);
        BTN3.setFont(new Font("Arial", Font.BOLD,20));
        
        BTN3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Acc.dispose();
                new ReportandAnalyticsUI();
                
            }
        });
        
        BTN4 = new JButton("Log out");
        BTN4.setBounds(700,500,150,50);
        BTN4.setBackground(Color.decode("#333333"));
        BTN4.setForeground(Color.WHITE);
        BTN4.setFont(new Font("Arial", Font.BOLD,20));
        BTN4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(Acc, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    Acc.dispose();
                    }
                }
            });
        
        ImageIcon img = new ImageIcon("Images/bg3.png");
        Image img1 = img.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(img1);

        label2 = new JLabel (img2);
        
        panel1 = new JPanel();
        panel1.setBounds (0,-10,900,600);
        panel1.setBackground(Color.BLACK);
        panel1.add(label2);
                
        Acc.add(label1);
        Acc.add(BTN1);
        Acc.add(BTN2);
        Acc.add(BTN3);
        Acc.add(BTN4);
        Acc.add(panel1);
        
       
        Acc.setVisible(true);
        
    }
    
}
