/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeeloginui;


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class MainMenu {
    private JFrame Acc;
    private ImageIcon BgColor;
    private JLabel label1;
    private JPanel panel1;
  
    private JButton BTN1,BTN2,BTN3,BTN4;
    MainMenu(){
        //frame
        Acc = new JFrame();
        Acc.setTitle("MAIN MENU");
        
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(900, 600);
        
        Acc.setLayout(new BorderLayout());
        
        Acc.getContentPane().setBackground(new Color(204,204,255));
        
        
          //label
          label1 = new JLabel("Employee Management System");
               
          label1.setFont(new Font("Courier New", Font.BOLD,40));
          
          label1.setHorizontalAlignment(JLabel.CENTER);
          
          label1.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
          
          Acc.add(label1, BorderLayout.NORTH);
          
          
         //panel at the bg of the icnos
        // panel1 = new JPanel();
         //panel1.setBackground(new Color(204,204,255));
        //panel1.setBounds(250,250,200,250);
          //Acc.add(panel1, BorderLayout.CENTER);
          
         JPanel panel = new JPanel();
         panel.setBackground(new Color(204,204,255));
        panel.setBounds(250,250,200,250);
          //Acc.add(panel1, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(7, 2)); 

        // Create four buttons
        
       JButton BTN1 = new JButton("Employee List");
       BTN1.setBounds(10,10,30,50);
       panel.add(BTN1);
        
        JButton BTN2 = new JButton("Employee Dashboard");
        
        JButton BTN4 = new JButton("Option");
       BTN1.setBounds(10,10,100,100);
       panel.add(BTN4);
       
        panel.add(BTN1);
        panel.add(BTN2);
        panel.add(BTN3);
        panel.add(BTN4);
        
       
        
        Acc.add(panel);
        Acc.setVisible(true);
        Acc.setLayout(null);
        
           
           
        
    }
    
}
