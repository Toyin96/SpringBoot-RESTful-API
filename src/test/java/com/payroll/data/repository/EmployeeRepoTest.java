package com.payroll.data.repository;

import com.payroll.data.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class EmployeeRepoTest {

    @Autowired
    EmployeeRepo employeeRepo;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void updateEmployeeRecordTest(){
        Employee employee = employeeRepo.findById(10).orElse(null);
        assertThat(employee).isNotNull();
        assertThat(employee.getFirstName()).isEqualTo("Bob");

        log.info("employee before save --> {}", employee);
        employee.setFirstName("John");

        employeeRepo.save(employee);
        assertThat(employee.getFirstName()).isEqualTo("John");
        assertThat(employee.getLastName()).isEqualTo("Dan");
        assertThat(employee.getRole()).isEqualTo("HR");

        log.info("employee after save --> {}", employee);
    }
}