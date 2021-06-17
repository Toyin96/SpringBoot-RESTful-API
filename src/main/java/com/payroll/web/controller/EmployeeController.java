package com.payroll.web.controller;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.service.EmployeeService;
import com.payroll.web.exceptions.EmployeeCantBeNullException;
import com.payroll.web.exceptions.EmployeeDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping
    public Employee save(@Valid @RequestBody EmployeeDto employee) throws EmployeeCantBeNullException {

        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Integer id) throws EmployeeDoesNotExistException {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) throws EmployeeDoesNotExistException {
        employeeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @Valid @RequestBody EmployeeDto employeeDto){

        return null;
    }
}
