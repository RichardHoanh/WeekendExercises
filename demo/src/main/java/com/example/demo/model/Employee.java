package com.example.demo.model;

import javax.persistence.*;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idEmployee;
    private String code;
    private String name;
    private int age;
    private double salary;
    @ManyToOne
    private Branch branch;

    public Employee() {
    }

    public Employee(int idEmployee, String code, String name, int age, double salary, Branch branch) {
        this.idEmployee = idEmployee;
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}

