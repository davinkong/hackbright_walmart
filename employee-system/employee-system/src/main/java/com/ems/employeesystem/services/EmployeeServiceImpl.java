package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.EmployeeDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addEmployee(EmployeeDto employeeDto){
        List<String> response = new ArrayList<>();
        Employee employee = new Employee(employeeDto);
        employeeRepository.saveAndFlush(employee);
        response.add("http://localhost:8080/html/login.html");
        return response;
    }

    @Override
    public List<String> employeeLogin(EmployeeDto employeeDto){
        List<String> response = new ArrayList<>();
        Optional<Employee> employeeOptional = employeeRepository.findByUsername(employeeDto.getUsername());

        if (employeeOptional.isPresent()){
            if (passwordEncoder.matches(employeeDto.getPassword(), employeeOptional.get().getPassword())){
                response.add("http://localhost:8080/html/home.html");
                response.add(String.valueOf(employeeOptional.get().getId()));
            }else {
                response.add("Username or Password is incorrect");
            }
        }else {
            response.add("Username or Password is incorrect");
        }

        return response;
    }
}
