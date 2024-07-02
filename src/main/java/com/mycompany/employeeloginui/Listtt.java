package main.java.com.mycompany.employeeloginui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Listtt {
    
        Listtt() {
        
        JFrame frame = new JFrame();
        JTable table = new JTable();
        
        
       
        Object[] columns = {"Employee Name", "Age","Birthdate", "Address","Email","Contact Number"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.gray);
        table.setForeground(Color.white);
        Font font = new Font ("Time new roman",1,24);
        table.setRowHeight(40);
        
        JTextField textEmployeeName = new JTextField();
        JTextField textAge = new JTextField();
        JTextField textBirthdate = new JTextField();
        JTextField textAddress= new JTextField();         
        JTextField textEmail = new JTextField();
        JTextField textContactNumber = new JTextField();
       
        
        textEmployeeName.setBounds(250,220,200,25);
        textEmployeeName.setFont(new Font("Time new roman",Font.BOLD,14));
        
        textAge.setBounds(250,250,200,25);
        textAge.setFont(new Font("Time new roman",Font.BOLD,14));
        
        textBirthdate.setBounds(250,280,200,25);
        textBirthdate.setFont(new Font("Time new roman",Font.BOLD,14));
        
        textAddress.setBounds(600,220,200,25);
        textAddress.setFont(new Font("Time new roman",Font.BOLD,14));
        
        textEmail.setBounds(600,250,200,25);
        textEmail.setFont(new Font("Time new roman",Font.BOLD,14));
        
        textContactNumber.setBounds(600,280,200,25);
        textContactNumber.setFont(new Font("Time new roman",Font.BOLD,14));
        
        
       
         JLabel lblEmployeeName = new JLabel("EmployeeName");
         lblEmployeeName.setBounds(20,220,100,25);
         lblEmployeeName.setFont(new Font ("Time new  roman",Font.BOLD,50));
         
         JLabel lblAge = new JLabel("Age");
         lblAge.setBounds(20,250,100,25);
         lblAge.setFont(new Font ("Time new  roman",Font.BOLD,50));
         
         JLabel lblBirthdate = new JLabel("Birthdate");
         lblBirthdate.setBounds(20,280,100,25);
         lblBirthdate.setFont(new Font ("Time new  roman",Font.BOLD,50));
         
         JLabel lblAddress = new JLabel("Address");
         lblAddress.setBounds(50,220,100,25);
         lblAddress.setFont(new Font ("Time new  roman",Font.BOLD,50));
         
         JLabel lblEmail = new JLabel("Email");
         lblEmail.setBounds(50,250,100,25);
         lblEmail.setFont(new Font ("Time new  roman",Font.BOLD,50));
         
         JLabel lblContactNumber = new JLabel("ContactNumber");
         lblContactNumber.setBounds(50,280,100,25);
         lblContactNumber.setFont(new Font ("Time new  roman",Font.BOLD,50));
          
         
           
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnBack = new JButton("Back");
        JButton btnNext = new JButton("Next");
        
        btnAdd.setBounds(50,355,100,25);
        btnDelete.setBounds(225,355,100,25);
        btnUpdate.setBounds(400,355,100,25);
        btnBack.setBounds(650,355,100,25);
        btnNext.setBounds(750,355,100,25);
       
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0,880,200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        frame.add(textEmployeeName);
        frame.add(textAge);
        frame.add(textBirthdate);
        frame.add(textAddress);
        frame.add(textEmail);
        frame.add(textContactNumber);
         
        
        frame.setSize(900,600);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Employee List Record");
        
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnBack);
        frame.add(btnNext);
       

        
        
        Object[] row = new Object[6];
        btnAdd.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
               
        row[0] = textEmployeeName.getText();
        row[1] = textAge.getText();
        row[2] = textBirthdate.getText();
        row[3] = textAddress.getText();
        row[4] = textEmail.getText();
        row[5] = textContactNumber.getText();
        
               
        model.addRow(row);
                
            }
        });
        
            btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int i = table.getSelectedRow();
                if(i >=0) {
                model.removeRow(i);
                }
                else {
                System.out.println("Deleted!!");
                }
            }
        }); 
            btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
            
            }); 
                frame.setSize(900,430);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }                   
}