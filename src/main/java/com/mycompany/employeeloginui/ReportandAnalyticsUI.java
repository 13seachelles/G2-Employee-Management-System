/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeeloginui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Vanessa
 */
public class ReportandAnalyticsUI {
    
     ReportandAnalyticsUI(){
             //GridLayout for 2 rows and 2 columns
      JFrame frame = new JFrame("Employee Management");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setResizable(false);
             frame.setSize(900, 600);
             frame.setLayout(new GridLayout(2, 2)); 
           Color lightBlue = new Color(204, 204, 255);
        
      JPanel subpanel1 = new JPanel();
             subpanel1.setLayout(new BorderLayout()); 
             subpanel1.setBackground(lightBlue);
     
     JLabel label1 = new JLabel("Report and Analytics", JLabel.CENTER);
            label1.setFont(new Font("Sans Serif", Font.BOLD, 20));
            subpanel1.add(label1, BorderLayout.NORTH);
 
        String[] employeecolumns = {"Name", "Department", "Weekly Task Status", "Ratings"};
            Object[][] employeedata = {
                {"Matthew", "IT", "done early", "100%"},
                {"Rachel", "Marketing", "done early", "100%"},
                {"Vanessa", "Sales", "done early", "100%"},
                {"Jonalyn", "HR", "done early", "100%"},
                {"Enzo", "Finance", "done early", "100%"},
                {"Haleana", "Customer Service", "done early", "100%"},
        };
     JTable employeetable = new JTable(employeedata, employeecolumns);
     JScrollPane tablescrollpane= new JScrollPane(employeetable); 
        subpanel1.add(tablescrollpane, BorderLayout.CENTER);
         employeetable.setBackground(lightBlue);
        JPanel buttonPanel1 = new JPanel();
        JButton addButton = new JButton("Add");
        JButton reviewButton = new JButton("Review");
        JButton deleteButton = new JButton("Delete");
         reviewButton.addActionListener(new ActionListener() {
           
     public void actionPerformed(ActionEvent e) {
                int selectedRow = employeetable.getSelectedRow();
                if (selectedRow >= 0) {
                    String employeename = (String) employeetable.getValueAt(selectedRow, 0);
                    JOptionPane.showMessageDialog(frame, "Opening review window for " + employeename);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select an employee to review.");
                }
            }
        });
        buttonPanel1.add(reviewButton);
        subpanel1.add(buttonPanel1, BorderLayout.SOUTH);

        
        buttonPanel1.add(addButton);
        buttonPanel1.add(reviewButton);
        buttonPanel1.add(deleteButton);
        subpanel1.add(buttonPanel1, BorderLayout.SOUTH);

 
     JPanel subpanel2 = new JPanel();
            subpanel2.setLayout(new BorderLayout());
            subpanel2.setBackground(lightBlue);
        String[] salecolumns = {"Week", "Total Sales", "Average Performance"};
         Object[][] saledata = {
             {"Week1", "Php 100,000", "100%"},
             {"Week2", "Php 98,000", "97%"},
             {"Week3", "Php 105,000", "100%"},
             {"Week4", "Php 110,000", "100%"},
             {"Week5", "Php 95,000", "93%"},
                
  };
    JTable saletable = new JTable(saledata, salecolumns);
    JScrollPane attendancescrollpane = new JScrollPane(saletable);
        subpanel2.add(attendancescrollpane, BorderLayout.CENTER);
        
    JButton viewButtonSubpanel2 = new JButton("View");
    subpanel2.add(viewButtonSubpanel2, BorderLayout.SOUTH);
    saletable.setBackground(lightBlue);
    
    JPanel subpanel3 = new JPanel();
           subpanel3.setLayout(new BorderLayout());
            subpanel3.setBackground(lightBlue);
        String[] einformation = {"Total Employees", "E.Growth Rate", "E.Turnover Rate","E.Average Tenure"};
        Object[][] einformationdata = {
                {"6", "10%", "20%","1 to 3 years"},
                
        };
      JTable einformationtable = new JTable(einformationdata, einformation);
      JScrollPane analysisscrollpane = new JScrollPane(einformationtable);
       subpanel3.add(analysisscrollpane, BorderLayout.CENTER);
     einformationtable.setBackground(lightBlue);
     
        JPanel buttonPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 150,5)); 
        JButton viewButton = new JButton("view details");
        buttonPanel3.add(viewButton);
        subpanel3.add(buttonPanel3, BorderLayout.SOUTH);
             
      JPanel subpanel4 = new JPanel();
           subpanel4.setLayout(new BorderLayout()); 
           subpanel4.setBackground(lightBlue);

         String[] financialperf = {"type","Revenue","Profit","Profit Margin",};
         Object[][] financialperfdata = {
                           {"Monthly","100,000","50,000","50%"},
                           {"Quarterly","100,000","50,000","50%"},
                           {"Annual","100,000","50,000","50%"},
};
      JTable financialperftable = new JTable(financialperfdata, financialperf);
      JScrollPane companyStatusScrollPane = new JScrollPane(financialperftable);
      subpanel4.add(companyStatusScrollPane, BorderLayout.CENTER);
      financialperftable.setBackground(lightBlue);
      
     JPanel buttonpanelsubpanel4 = new JPanel();
            buttonpanelsubpanel4.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 5)); // Adjust spacing as needed

     JButton editButton = new JButton("Edit");
     JButton backButton = new JButton("Back");
             
           
     buttonpanelsubpanel4.add(editButton);
     buttonpanelsubpanel4.add(backButton);
     subpanel4.add(buttonpanelsubpanel4, BorderLayout.SOUTH);

        // Add subpanels to the frame using GridLayout
        frame.add(subpanel1);
        frame.add(subpanel2);
        frame.add(subpanel3);
        frame.add(subpanel4);
        frame.setVisible(true);
    }   

    
}
