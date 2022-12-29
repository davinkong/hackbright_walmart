package com.ems.employeesystem.dtos;

import com.ems.employeesystem.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(Employee employee){
        if(employee.getId() != null){
            this.id = employee.getId();
        }
        if(employee.getUsername() != null){
            this.username = employee.getUsername();
        }
        if(employee.getPassword() != null){
            this.password = employee.getPassword();
        }
        if(employee.getFirstName() != null){
            this.firstName = employee.getFirstName();
        }
        if(employee.getLastName() != null){
            this.lastName = employee.getLastName();
        }
        if(employee.getEmail() != null){
            this.email = employee.getEmail();
        }

    }
}

