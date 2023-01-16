package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;
@Component
public class EmployeeDAO {
    @Autowired
    EntityManager entityManager;

    public List<Employee> getAll(){
        String sql = "Select p from Employee p";
        List<Employee> employees =  entityManager.createQuery(sql).getResultList();
        return employees;
    }

    public void create(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(employee);
        txn.commit();
    }

    public void delete(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(employee);
        txn.commit();
    }

    public void edit(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(employee);
        txn.commit();
    }

    public Employee findEmployeeByCode(String code){
        String sql = "Select p from Employee p where p.code = " + code;
        Employee employee = (Employee) entityManager.createQuery(sql).getSingleResult();
        return employee;
    }
    public List<Employee> getSearchEmployee(String search) {
        String sql = "Select p from Employee p where upper(p.name) like '%"+search.toUpperCase()+"%' ";
        List<Employee> employees = entityManager.createQuery(sql).getResultList();
        return employees;

    }






}
