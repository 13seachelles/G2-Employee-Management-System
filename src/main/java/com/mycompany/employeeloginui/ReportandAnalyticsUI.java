/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.employeeloginui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ReportandAnalyticsUI {

    private Connection connection;

    public ReportandAnalyticsUI() {
        // Establish the database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_oop", "root", "root");           
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }

        // Create the main frame
        JFrame frame = new JFrame("Report and Analytics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(900, 600);

        Color lightBlue = new Color(204, 204, 255);

        // Create the panel that will contain the tabbed pane
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(lightBlue);

        JLabel label1 = new JLabel("Report and Analytics", JLabel.CENTER);
        label1.setFont(new Font("Sans Serif", Font.BOLD, 20));
        mainPanel.add(label1, BorderLayout.NORTH);

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create the Financial Performance tab
        String[] finperfcolumns = {"Type", "Revenue", "Profit", "ProfitMargin"};
        DefaultTableModel finperfModel = new DefaultTableModel(null, finperfcolumns);
        JTable financialperftable = new JTable(finperfModel);
        JScrollPane finperfScrollPane = new JScrollPane(financialperftable);

        JPanel finperfPanel = new JPanel(new BorderLayout());
        finperfPanel.add(finperfScrollPane, BorderLayout.CENTER);

        JPanel finperfButtonPanel = new JPanel();
        JButton finperfAddButton = new JButton("Add");
        JButton finperfDeleteButton = new JButton("Delete");
        finperfButtonPanel.add(finperfAddButton);
        finperfButtonPanel.add(finperfDeleteButton);

        finperfPanel.add(finperfButtonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Financial Performance", finperfPanel);

        // Load financial performance data from the database
        loadFinancialPerformanceData(finperfModel);

        // Add action listeners for Financial Performance buttons
        finperfAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] newData = new String[finperfcolumns.length];
                for (int i = 0; i < finperfcolumns.length; i++) {
                    String value = JOptionPane.showInputDialog(frame, "Enter " + finperfcolumns[i]);
                    if (value != null && !value.trim().isEmpty()) {
                        newData[i] = value;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter a value for " + finperfcolumns[i]);
                        return;
                    }
                }
                finperfModel.addRow(newData); // Add row to JTable
                insertFinancialPerformanceData(newData); // Insert into database
            }
        });

        finperfDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = financialperftable.getSelectedRow();
                if (selectedRow != -1) {
                    String typeValue = (String) financialperftable.getValueAt(selectedRow, 0);
                    deleteFinancialPerformanceData(typeValue);
                    finperfModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
                }
            }
        });

        // Create the Sales tab
        String[] salesColumns = {"Week", "TotalSales", "AveragePerf"};
        DefaultTableModel salesModel = new DefaultTableModel(null, salesColumns);
        JTable salesTable = new JTable(salesModel);
        JScrollPane salesScrollPane = new JScrollPane(salesTable);

        JPanel salesPanel = new JPanel(new BorderLayout());
        salesPanel.add(salesScrollPane, BorderLayout.CENTER);

        JPanel salesButtonPanel = new JPanel();
        JButton salesAddButton = new JButton("Add");
        JButton salesDeleteButton = new JButton("Delete");
        salesButtonPanel.add(salesAddButton);
        salesButtonPanel.add(salesDeleteButton);

        salesPanel.add(salesButtonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Sales", salesPanel);

        // Load sales data from the database
        loadSalesData(salesModel);

        // Add action listeners for Sales buttons
        salesAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] newData = new String[salesColumns.length];
                for (int i = 0; i < salesColumns.length; i++) {
                    String value = JOptionPane.showInputDialog(frame, "Enter " + salesColumns[i]);
                    if (value != null && !value.trim().isEmpty()) {
                        newData[i] = value;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter a value for " + salesColumns[i]);
                        return;
                    }
                }
                salesModel.addRow(newData); // Add row to JTable
                insertSalesData(newData); // Insert into database
            }
        });

        salesDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = salesTable.getSelectedRow();
                if (selectedRow != -1) {
                    String weekValue = (String) salesTable.getValueAt(selectedRow, 0);
                    deleteSalesData(weekValue);
                    salesModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
                }
            }
        });

        // Create the Employee Information tab
        String[] empInfoColumns = {"TotalEmployees", "EGrowthRate", "ETurnoverRate", "EAverageTenure"};
        DefaultTableModel empInfoModel = new DefaultTableModel(null, empInfoColumns);
        JTable empInfoTable = new JTable(empInfoModel);
        JScrollPane empInfoScrollPane = new JScrollPane(empInfoTable);

        JPanel empInfoPanel = new JPanel(new BorderLayout());
        empInfoPanel.add(empInfoScrollPane, BorderLayout.CENTER);

        JPanel empInfoButtonPanel = new JPanel();
        JButton empInfoAddButton = new JButton("Add");
        JButton empInfoDeleteButton = new JButton("Delete");
        empInfoButtonPanel.add(empInfoAddButton);
        empInfoButtonPanel.add(empInfoDeleteButton);

        empInfoPanel.add(empInfoButtonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Employee Information", empInfoPanel);

        // Load employee information data from the database
        loadEmployeeInfoData(empInfoModel);

        // Add action listeners for Employee Information buttons
        empInfoAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] newData = new String[empInfoColumns.length];
                for (int i = 0; i < empInfoColumns.length; i++) {
                    String value = JOptionPane.showInputDialog(frame, "Enter " + empInfoColumns[i]);
                    if (value != null && !value.trim().isEmpty()) {
                        newData[i] = value;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter a value for " + empInfoColumns[i]);
                        return;
                    }
                }
                empInfoModel.addRow(newData); // Add row to JTable
                insertEmployeeInfoData(newData); // Insert into database
            }
        });

        empInfoDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = empInfoTable.getSelectedRow();
                if (selectedRow != -1) {
                    String totalEmployeesValue = (String) empInfoTable.getValueAt(selectedRow, 0);
                    deleteEmployeeInfoData(totalEmployeesValue);
                    empInfoModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
                }
            }
        });

        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    // Load financial performance data from the database into the JTable
    private void loadFinancialPerformanceData(DefaultTableModel model) {
        String query = "SELECT * FROM financialperformance_tbl";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String type = resultSet.getString("Type");
                String revenue = resultSet.getString("Revenue");
                String profit = resultSet.getString("Profit");
                String profitMargin = resultSet.getString("ProfitMargin");
                model.addRow(new String[]{type, revenue, profit, profitMargin});
            }
        } catch (SQLException e) {
            System.out.println("Error while loading Financial Performance data: " + e.getMessage());
        }
    }

    // Method to insert new data into the FinancialPerformance table
    private void insertFinancialPerformanceData(String[] data) {
        String query = "INSERT INTO financialperformance_tbl (Type, Revenue, Profit, ProfitMargin) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < data.length; i++) {
                statement.setString(i + 1, data[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while inserting Financial Performance data: " + e.getMessage());
        }
    }

    // Method to delete a row from the FinancialPerformance table based on Type
    private void deleteFinancialPerformanceData(String type) {
        String query = "DELETE FROM financialperformance_tbl WHERE Type = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, type);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting Financial Performance data: " + e.getMessage());
        }
    }

    // Load sales data from the database into the JTable
    private void loadSalesData(DefaultTableModel model) {
        String query = "SELECT * FROM sales_tbl";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String week = resultSet.getString("Week");
                String totalSales = resultSet.getString("TotalSales");
                String averagePerf = resultSet.getString("AveragePerf");
                model.addRow(new String[]{week, totalSales, averagePerf});
            }
        } catch (SQLException e) {
            System.out.println("Error while loading Sales data: " + e.getMessage());
        }
    }

    // Method to insert new data into the Sales table
    private void insertSalesData(String[] data) {
        String query = "INSERT INTO sales_tbl (Week, TotalSales, AveragePerf) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < data.length; i++) {
                statement.setString(i + 1, data[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while inserting Sales data: " + e.getMessage());
        }
    }

    // Method to delete a row from the Sales table based on Week
    private void deleteSalesData(String week) {
        String query = "DELETE FROM sales_tbl WHERE Week = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, week);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting Sales data: " + e.getMessage());
        }
    }

    // Load employee information data from the database into the JTable
    private void loadEmployeeInfoData(DefaultTableModel model) {
        String query = "SELECT * FROM employeeinfo_tbl";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String totalEmployees = resultSet.getString("TotalEmployees");
                String eGrowthRate = resultSet.getString("EGrowthRate");
                String eTurnoverRate = resultSet.getString("ETurnoverRate");
                String eAverageTenure = resultSet.getString("EAverageTenure");
                model.addRow(new String[]{totalEmployees, eGrowthRate, eTurnoverRate, eAverageTenure});
            }
        } catch (SQLException e) {
            System.out.println("Error while loading Employee Information data: " + e.getMessage());
        }
    }

    // Method to insert new data into the EmployeeInfo table
    private void insertEmployeeInfoData(String[] data) {
        String query = "INSERT INTO employeeinfo_tbl (TotalEmployees, EGrowthRate, ETurnoverRate, EAverageTenure) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < data.length; i++) {
                statement.setString(i + 1, data[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while inserting Employee Information data: " + e.getMessage());
        }
    }

    // Method to delete a row from the EmployeeInfo table based on TotalEmployees
    private void deleteEmployeeInfoData(String totalEmployees) {
        String query = "DELETE FROM employeeinfo_tbl WHERE TotalEmployees = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, totalEmployees);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting Employee Information data: " + e.getMessage());
        }
    }

    
}
