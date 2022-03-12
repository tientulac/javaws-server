package com.components.javawsserver.entities;

import com.components.javawsserver.annotations.Column;
import com.components.javawsserver.annotations.Entity;
import com.components.javawsserver.annotations.Id;
import com.components.javawsserver.utils.SQLDataTypes;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "employee")
public class Employee {
    @Id(autoIncrement = true)
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    private int id;
    @Column(columnName = "full_name", columnType = SQLDataTypes.VARCHAR255)
    private String full_name;
    @Column(columnName = "age", columnType = SQLDataTypes.INTEGER)
    private int age;
    @Column(columnName = "birth", columnType = SQLDataTypes.DATE)
    private Date birth;
    @Column(columnName = "gender", columnType = SQLDataTypes.INTEGER)
    private int gender;
    @Column(columnName = "department_id", columnType = SQLDataTypes.INTEGER)
    private int department_id;

    public Employee() {
    }

    public Employee(int id, String full_name, int age, Date birth, int gender, int department_id) {
        this.id = id;
        this.full_name = full_name;
        this.age = age;
        this.birth = birth;
        this.gender = gender;
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
