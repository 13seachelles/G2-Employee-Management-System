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




public class MainMenu {
    private JFrame Acc;
    private ImageIcon BgColor;
    private JLabel label1;
    private JPanel panel1;
  
    private JButton BTN1,BTN2,BTN3,BTN4,BTN5,BTN6;
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
          label1 = new JLabel("MAIN MENU");
               
          label1.setFont(new Font("Courier New", Font.BOLD,80));
          
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
      panel.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns

        // Create four buttons
        
       JButton BTN1 = new JButton("Employee List");
       BTN1.setBounds(10,10,100,100);
       panel.add(BTN1);
        
        JButton BTN2 = new JButton("Employee Dashboard");
        BTN2.setBounds(10,10,100,100);
     //   BTN1.SetHorizontalAlignment(JButton.CENTER);
        panel.add(BTN2);
        JButton BTN3 = new JButton("Report");
        BTN3.setBounds(10,10,100,100);
        panel.add(BTN3);
        JButton BTN4 = new JButton("Analytics");
        BTN4.setBounds(10,10,100,100);
        panel.add(BTN4);
          JButton BTN5 = new JButton("Option");
       BTN1.setBounds(10,10,100,100);
       panel.add(BTN5);
        JButton BTN6 = new JButton("");
       BTN1.setBounds(10,10,100,100);
        panel.add(BTN6);
        
        panel.add(BTN1);
        panel.add(BTN2);
        panel.add(BTN3);
        panel.add(BTN4);
        panel.add(BTN5);
        panel.add(BTN6);
        
       

        Acc.add(panel);
        Acc.setVisible(true);
        Acc.setLayout(null);
           
        
    }
    
}