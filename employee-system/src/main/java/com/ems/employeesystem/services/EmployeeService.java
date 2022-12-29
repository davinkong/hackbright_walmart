package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.EmployeeDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmployeeService {
    @Transactional
    List<String> addEmployee(EmployeeDto employeeDto);

    List<String> employeeLogin(EmployeeDto employeeDto);
}
