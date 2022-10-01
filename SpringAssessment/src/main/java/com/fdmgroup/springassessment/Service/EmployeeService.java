package com.fdmgroup.springassessment.Service;

import com.fdmgroup.springassessment.Model.Employee;
import com.fdmgroup.springassessment.Repository.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // to check the user-name and password has at least 8 character and no spaces
    public boolean usernameAndPasswordValid (Employee employee){
        if (!(employee.getUsername ().length () >=8 && employee.getPassword ().length () >=8)){
            return false;
        }

        if (employee.getUsername ().contains (" ") && employee.getPassword ().contains (" ")) {
            return false;
        }
        return true;
    }

    // To check Existence of User in Database
    public boolean checkForExistence(Employee employee){
        if (!employeeRepository.existsByUsernameIgnoreCase (employee.getUsername ())){
                return true;
            }
        return false;
    }

    // Validation of both the conditions
    public boolean validToRegister(Employee employee){
        if (checkForExistence (employee) && usernameAndPasswordValid (employee)){
            employeeRepository.save (employee);
            return true;
        }
        return false;
    }

    //Authentication service
    public boolean authenticated( Employee employee){
        Employee employeeFromDatabase = employeeRepository.findByUsername (employee.getUsername ());

        if (employeeFromDatabase != null
                && (employee.getUsername ().equals (employeeFromDatabase.getUsername ())
                && employee.getPassword ().equals (employeeFromDatabase.getPassword ()))){
            return true;
        }
        return false;
    }
}
