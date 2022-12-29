package com.ems.employeesystem.dtos;


import com.ems.employeesystem.entities.Information;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto implements Serializable {
    private Long id;
    private String street;
    private String city;
    private String state;
    private Long zipCode;
    private Long phoneNumber;


    private EmployeeDto employeeDto;

    public InformationDto(Information information) {
        if(information.getId() != null){
            this.id = information.getId();
        }
        if(information.getStreet() != null){
            this.street = information.getStreet();
        }
        if(information.getCity() != null){
            this.city = information.getCity();
        }
        if(information.getState() != null){
            this.state = information.getCity();
        }
        if(information.getZipCode() != null){
            this.zipCode = information.getZipCode();
        }
        if(information.getPhoneNumber() != null){
            this.phoneNumber = information.getPhoneNumber();
        }
    }
}
