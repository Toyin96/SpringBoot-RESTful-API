package com.payroll.service;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.web.exceptions.EmployeeCantBeNullException;
import com.payroll.web.exceptions.EmployeeDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
        Employee save(EmployeeDto employeeDto) throws EmployeeCantBeNullException, EmployeeCantBeNullException;
        Employee findById(Integer id) throws EmployeeDoesNotExistException;
        List<Employee> findAll();
        void deleteById(Integer id) throws EmployeeDoesNotExistException;
        Employee update(EmployeeDto employeeDto, int id) throws EmployeeDoesNotExistException;
}
