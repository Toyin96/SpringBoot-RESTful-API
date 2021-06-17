package com.payroll.service.util;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring") // this is for dependency injection
public interface EmployeeMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // when we're mapping the dto, it'll ignore the null values
    void updateEmployeeFromDto(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
