package com.ems.employeesystem.entities;


import com.ems.employeesystem.dtos.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String email;


    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Information information;
    public Employee(EmployeeDto employeeDto){
        if(employeeDto.getUsername() != null){
            this.username = employeeDto.getUsername();
        }
        if(employeeDto.getPassword() != null){
            this.password = employeeDto.getPassword();
        }
        if(employeeDto.getFirstName() != null){
            this.firstName = employeeDto.getFirstName();
        }
        if(employeeDto.getLastName() != null){
            this.lastName = employeeDto.getLastName();
        }
        if(employeeDto.getEmail() != null){
            this.email = employeeDto.getEmail();
        }

    }
}
