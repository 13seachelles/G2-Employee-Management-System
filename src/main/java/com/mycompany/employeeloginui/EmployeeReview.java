package main.java.com.mycompany.employeeloginui;


/**
 *
 * @author Jonalyn Ramos
 */




import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EmployeeReview {
    

    public EmployeeReview(){
        
        JFrame f = new JFrame("Review Employee");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        
       
        
        String[] columnNames = {"Name", "Department", "Weekly Task Status", "Rating"};
        Object[][] employeeData = {
            {"Matthew", "IT", "Done Early", "100%"},
            {"Rachelle", "Marketing", "Done Early", "100%"},
            {"Vanessa", "Sales", "Done Early", "100%"},
            {"Jonalyn", "HR", "Done Early", "100%"},
            {"Enzo", "Finance", "Done Early", "100%"},
            {"Helaena", "Customer Service", "Done Early", "100%"},
        };

        DefaultTableModel tablemodel = new DefaultTableModel(employeeData, columnNames);
        JTable employeeTable = new JTable(tablemodel);
        JScrollPane tableScrollPane  = new JScrollPane(employeeTable);
        
        f.getContentPane().setBackground(Color.DARK_GRAY);
        tableScrollPane.getViewport().setBackground(Color.LIGHT_GRAY);
        employeeTable.setBackground(Color.LIGHT_GRAY);
         

        JButton reviewButton = new JButton("Review");
        reviewButton.setBackground(Color.BLUE);
        reviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    Object[] rowData = new Object[employeeTable.getColumnCount()];
                    for (int i = 0; i < employeeTable.getColumnCount(); i++) {
                        rowData[i] = employeeTable.getValueAt(selectedRow, i);
                    }
                    openReviewFrame(tablemodel, selectedRow, rowData);
                } else {
                    JOptionPane.showMessageDialog(f, "Please select a row first.");
                }
            }
        });

        f.add(tableScrollPane, BorderLayout.CENTER);
        f.add(reviewButton, BorderLayout.SOUTH);
        f.setVisible(true);
    }

    private static void openReviewFrame(DefaultTableModel model, int rowIndex, Object[] rowData) {
        JFrame reviewFrame = new JFrame("Review and Edit");
        reviewFrame.setSize(300, 200);

        JPanel reviewpanel = new JPanel(new GridLayout(rowData.length + 1, 2));
        reviewpanel.setBackground(Color.WHITE);
        JTextField[] textFields = new JTextField[rowData.length];

        for (int i = 0; i < rowData.length; i++) {
            reviewpanel.add(new JLabel(model.getColumnName(i)));
            textFields[i] = new JTextField(rowData[i].toString());
            reviewpanel.add(textFields[i]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLUE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < textFields.length; i++) {
                    model.setValueAt(textFields[i].getText(), rowIndex, i);
                }
                reviewFrame.dispose();
            }
        });

        reviewpanel.add(submitButton);
        reviewFrame.add(reviewpanel);
        reviewFrame.setVisible(true);
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}