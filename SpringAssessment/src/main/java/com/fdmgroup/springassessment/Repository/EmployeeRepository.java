package com.fdmgroup.springassessment.Repository;

import com.fdmgroup.springassessment.Model.Employee;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByUsernameIgnoreCase (String username);

    Employee findByUsername(String username);

}
