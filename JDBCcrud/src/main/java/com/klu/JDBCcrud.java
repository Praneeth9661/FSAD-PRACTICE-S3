package com.klu;

import java.sql.*;
import java.util.Scanner;

public class JDBCcrud {

    static final String URL = "jdbc:mysql://localhost:3306/fsad1";
    static final String USER = "root";
    static final String PASSWORD = "Anjan@7254";   // change if needed

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database Connected");

            int choice;
            do {
                System.out.println("\n----- JDBC CRUD MENU -----");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee();
                        break;

                    case 2:
                        viewEmployees();
                        break;

                    case 3:
                        updateEmployee();
                        break;

                    case 4:
                        deleteEmployee();
                        break;

                    case 5:
                        System.out.println("👋 Exiting...");
                        break;

                    default:
                        System.out.println("❌ Invalid choice");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // INSERT
    static void insertEmployee() throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employee (emp_name, salary) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setDouble(2, salary);

        ps.executeUpdate();
        System.out.println("✅ Employee Inserted");
    }

    // READ
    static void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM employee";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\nID\tName\tSalary");
        System.out.println("------------------------");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("emp_id") + "\t" +
                    rs.getString("emp_name") + "\t" +
                    rs.getDouble("salary")
            );
        }
    }

    // UPDATE
    static void updateEmployee() throws SQLException {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("✅ Employee Updated");
        else
            System.out.println("❌ Employee Not Found");
    }

    // DELETE
    static void deleteEmployee() throws SQLException {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employee WHERE emp_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("✅ Employee Deleted");
        else
            System.out.println("❌ Employee Not Found");
    }
}