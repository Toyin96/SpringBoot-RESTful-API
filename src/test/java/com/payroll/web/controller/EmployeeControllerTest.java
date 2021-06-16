package com.payroll.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payroll.data.model.Employee;
import com.payroll.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:db/insert.sql") // we want it to run this scripts
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllEmployeeTest() throws Exception{
        mockMvc.perform(get("/employee")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void saveNewEmployeeTest() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Janet");
        employee.setLastName("Hams");
        employee.setRole("CTO");

        /*
        Here, we need to pass the java object to postman but we can't do it directly.
        To achieve this, we'll need to bring in the ObjectMapper from Jackson which
        converts java object to json and vice versa.
        */
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/employee").contentType("application/json").content(mapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findByEmployeeIdTest() throws Exception {
        mockMvc.perform(get("/employee/11")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteByEmployeeIdTest() throws Exception {
        mockMvc.perform(delete("/employee/11")).andDo(print()).andExpect(status().isOk());
    }
}