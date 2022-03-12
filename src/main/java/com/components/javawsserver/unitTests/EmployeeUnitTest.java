package com.components.javawsserver.unitTests;

import com.components.javawsserver.config.DatabaseConnection;
import com.components.javawsserver.entities.Employee;
import com.components.javawsserver.repository.JpaRepository;
import org.testng.annotations.Test;

import java.sql.Connection;

public class EmployeeUnitTest {
    @Test
    public void getConnection() {
        Connection conn = DatabaseConnection.getConnection();
        JpaRepository<Employee> jpaEmployee = new JpaRepository<Employee>(Employee.class);
        for (Employee e : jpaEmployee.findAll())
        {
            System.out.println(e.getFull_name());
        }
    }
}
