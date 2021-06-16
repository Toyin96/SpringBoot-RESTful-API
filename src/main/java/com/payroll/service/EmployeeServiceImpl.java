package com.payroll.service;

import com.payroll.data.model.Employee;
import com.payroll.data.repository.EmployeeRepo;
import com.payroll.web.exceptions.EmployeeCantBeNullException;
import com.payroll.web.exceptions.EmployeeDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee save(Employee employee) throws EmployeeCantBeNullException {
         if (employee.getFirstName().isBlank()){
             throw new EmployeeCantBeNullException("Name section can't be empty");
         }

         return employeeRepo.save(employee);
    }

    @Override
    public Employee findById(Integer id) throws EmployeeDoesNotExistException {

        Optional<Employee> employee = employeeRepo.findById(id);

        if (employee.isPresent()){
            return employee.get();
        }else{
            throw new EmployeeDoesNotExistException("No employee exist by that ID");
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepo.findAll();

        return employees;
    }

    @Override
    public void deleteById(Integer id) throws EmployeeDoesNotExistException {
        Optional<Employee> employee = employeeRepo.findById(id);

        if (employee.isPresent()){
            employeeRepo.deleteById(id);
        }else{
            throw new EmployeeDoesNotExistException("No employee was found with that ID hence nothing to delete");
        }
    }
}
