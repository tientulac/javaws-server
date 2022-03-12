package com.components.javawsserver.service;

import com.components.javawsserver.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean insertOne(Employee employee);
    boolean updateOne(Employee employee);
    boolean deleteOne(int id);
    Employee findById (int id);
}
