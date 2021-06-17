package com.payroll.service;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.data.repository.EmployeeRepo;
import com.payroll.service.util.EmployeeMapper;
import com.payroll.web.exceptions.EmployeeCantBeNullException;
import com.payroll.web.exceptions.EmployeeDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.internal.model.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    EmployeeMapper employeeMapper;

    EmployeeServiceImpl(){
        employeeMapper = Mappers.getMapper(EmployeeMapper.class);
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Employee save(EmployeeDto employeedto) throws EmployeeCantBeNullException {

         Employee employee = new Employee();
         modelMapper.map(employeedto, employee);
         log.info("employee after mapping -->{}", employee);

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

    @Override
    public Employee update(EmployeeDto employeeDto, int id) throws EmployeeDoesNotExistException {
        Employee employee = employeeRepo.findById(id).orElse(null);
        if (employee == null){
            throw new EmployeeDoesNotExistException("Employee not found!");
        }

        employeeMapper.updateEmployeeFromDto(employeeDto, employee);
        log.info("employee after mapping -->{}", employee);

        return employeeRepo.save(employee);


    }
}
