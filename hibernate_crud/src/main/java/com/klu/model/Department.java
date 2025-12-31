package com.klu.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptid;

    private String deptname;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    // 🔹 required no-arg constructor
    public Department() {
    }

    public int getDeptId() {
        return deptid;
    }

    public void setDeptId(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptName() {
        return deptname;
    }

    public void setDeptName(String deptname) {
        this.deptname = deptname;
    }
}
