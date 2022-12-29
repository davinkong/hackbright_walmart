package com.ems.employeesystem.entities;


import com.ems.employeesystem.dtos.InformationDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * Lombok and looks at the member variables and can generate all of our getters and setters for us,
 * as well as the constructors all through 3 annotations
 */

@Entity
@Table(name = "information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {

    /**
     * create two private member variables called “id” of type “Long”
     * and “street” of type “String” and give each member the corresponding annotations
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private Long zipCode;
    @Column
    private Long phoneNumber;
    @OneToOne
    @JsonBackReference
    private Employee employee;


    public Information(InformationDto informationDto) {
        if(informationDto.getStreet() != null){
            this.street = informationDto.getStreet();
        }
        if(informationDto.getCity() != null){
            this.city = informationDto.getCity();
        }
        if(informationDto.getState() != null){
            this.state = informationDto.getCity();
        }
        if(informationDto.getZipCode() != null){
            this.zipCode = informationDto.getZipCode();
        }
        if(informationDto.getPhoneNumber() != null){
            this.phoneNumber = informationDto.getPhoneNumber();
        }

    }

}
