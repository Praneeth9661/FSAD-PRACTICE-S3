package com.klu.app;


import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.klu.model.Department;
import com.klu.model.Employee;
import com.klu.util.HibernateUtil;

public class MainApp {

 static SessionFactory factory = HibernateUtil.getSessionFactory();
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int choice;
  
  do {
   System.out.println("\n======Employee Menu======\n");
   System.out.println("1. Insert Employee");
   System.out.println("2. View Employee");
   System.out.println("3. Update Employee Salary");
   System.out.println("4. Delete Employee");
   System.out.println("5. Exit");
   System.out.println("Enter Choice: ");
   
   choice = sc.nextInt();
   
   switch(choice) {
   
   case 1: insertEmployee(sc); break;
   case 2: viewEmployee(sc); break;
   case 3: updateEmployee(sc);break;
   case 4: deleteEmployee(sc);break;
   case 5: System.out.println("Thank You!");break;
   default: System.out.println("Invalid choice");break;
   }
  }while(choice!=5);
        factory.close();
  sc.close();
 }
 
 
 
 private static void insertEmployee(Scanner sc) {
  Session session = factory.openSession();
     Transaction tx = session.beginTransaction();
    
     System.out.print("Enter the Dept Name: ");
     String deptName=sc.next();
     
     Department dept = new Department();
     dept.setDeptName(deptName);
     
     System.out.print("Enter the Emp name: ");
     String empName = sc.next();
     
     System.out.print("Enter the salary: ");
     double salary= sc.nextDouble();
     
     
     Employee emp = new Employee();
     emp.setEmpName(empName);
     emp.setEmpSalary(salary);
     emp.setDepartment(dept);
     
     session.persist(emp); 
     session.persist(dept);
     
     tx.commit();
     session.close();
     
     System.out.println("Employee inserted successfully");
     
 }
 
 
 
 private static void viewEmployee(Scanner sc) {
  Session session = factory.openSession();
  
  System.out.println("Enter the Employee ID: ");
  int id = sc.nextInt();
  
  Employee emp = session.get(Employee.class ,id);
  
  if(emp!=null) {
   System.out.println("Name: "+emp.getEmpName());
   System.out.println("Salary: "+emp.getEmpSalary());
   System.out.println("Dept: "+emp.getDepartment().getDeptName());
  }else {
   System.out.println("Employee not found!");
  }
  session.close();
 }
 
  
 private static void updateEmployee(Scanner sc) {
  Session session = factory.openSession();
     Transaction tx = session.beginTransaction();
      System.out.print("Enter the Employee ID: ");
       int id = sc.nextInt();
      Employee emp =  session.get(Employee.class, id);
      if(emp!=null) {
       System.out.print("Enter New Salary: ");
       emp.setEmpSalary(sc.nextDouble());
       tx.commit();
       System.out.println("Salary Updated");
      }else {
       System.out.println("Employee not found");
       tx.rollback();
      }
     
      session.close();
      
      
 } 
 

 
 private static void deleteEmployee(Scanner sc) {
  Session session = factory.openSession();
     Transaction tx = session.beginTransaction();
      System.out.print("Enter the Employee ID: ");
       int id = sc.nextInt();
      Employee emp = session.get(Employee.class, id);
      
      if(emp!=null) {
       session.remove(emp);
       tx.commit();
       System.out.println("Employee deleted");
      }else {
       System.out.println("Employee not found");
       tx.rollback();
      }
     
      session.close();
 }

}