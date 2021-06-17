package com.payroll.service;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.web.exceptions.EmployeeDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:db/insert.sql")
class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenUpdateEmployeeIsCalledThenUpdateNotNullValues() throws EmployeeDoesNotExistException {
        Employee existingEmployee = employeeService.findById(10);
        assertThat(existingEmployee.getFirstName()).isEqualTo("Bob");
        assertThat(existingEmployee.getLastName()).isEqualTo("Dan");
        assertThat(existingEmployee.getRole()).isEqualTo("HR");

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setRole("Accountant");

        Employee updatedEmployee = employeeService.update(employeeDto, 10);
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Bob");
        assertThat(updatedEmployee.getLastName()).isEqualTo("Dan");
        assertThat(updatedEmployee.getRole()).isEqualTo("Accountant");

    }
}