package com.payroll.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.payroll.data.model.Employee;

@Repository // THIS IS A REPO
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
