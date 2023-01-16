package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {
    //    Tiêm một đối tượng studentDAO của class StudentDAO để thao tác
    @Autowired
    EmployeeDAO employeeDAO;


    public static List<Employee> employees = new ArrayList<>();


    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public void create(Employee employee) {
        employeeDAO.create(employee);

    }

    public void edit(Employee employee) {
        employeeDAO.edit(employee);
    }

    public void delete(String code) {
        employeeDAO.delete(employeeDAO.findEmployeeByCode(code));
    }

    public Employee findEmployeeByCode(String code) {
        return employeeDAO.findEmployeeByCode(code);
    }


    public  List<Employee> searchEmployee(String str) {
        List<Employee> listSearch = employeeDAO.getSearchEmployee(str);
        return listSearch;
    }




}








