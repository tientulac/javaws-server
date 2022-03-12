package com.components.javawsserver.service;

import com.components.javawsserver.entities.Employee;
import com.components.javawsserver.repository.JpaRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    JpaRepository<Employee> jpaEmployee = new JpaRepository<Employee>(Employee.class);

    @Override
    public List<Employee> findAll() {
        return jpaEmployee.findAll();
    }

    @Override
    public boolean insertOne(Employee employee) {
        return jpaEmployee.save(employee);
    }

    @Override
    public boolean updateOne(Employee employee) {
        return jpaEmployee.update(employee);
    }

    @Override
    public boolean deleteOne(int id) {
        return jpaEmployee.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return (Employee) jpaEmployee.findById(id);
    }
}
