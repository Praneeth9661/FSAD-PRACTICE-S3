package com.klu.model;

import javax.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    private String empname;

    private double salary;

    @ManyToOne
    @JoinColumn(name = "deptid")   // foreign key column
    private Department department;

    // 🔹 Required no-arg constructor
    public Employee() {
    }

    public int getEmpId() {
        return empid;
    }

    public void setEmpId(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empname;
    }

    public void setEmpName(String empname) {
        this.empname = empname;
    }

    public double getEmpSalary() {
        return salary;
    }

    public void setEmpSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
