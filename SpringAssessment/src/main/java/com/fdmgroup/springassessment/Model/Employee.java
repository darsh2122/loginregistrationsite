package com.fdmgroup.springassessment.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String job_Title;
    private long salary;

    public Employee (int id, String username, String password, String job_Title, long salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.job_Title = job_Title;
        this.salary = salary;
    }

    public Employee () {
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getJob_Title () {
        return job_Title;
    }

    public void setJob_Title (String job_Title) {
        this.job_Title = job_Title;
    }

    public long getSalary () {
        return salary;
    }

    public void setSalary (long salary) {
        this.salary = salary;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", job_Title='" + job_Title + '\'' +
                ", salary=" + salary +
                '}';
    }
}
