package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * above the User class declaration, add:
 *  @Entity Annotation (this is annotation is what tells Spring that this class is being mapped to a data source)
 *  @Table annotation (This is where you can set what table you want these objects to be mapped to)
 *  Lombok and looks at the member variables and can generate all of our getters and setters for us,
 *  * as well as the constructors all through 3 annotations
 */
@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Create a new private member variable called “username” of type “String”
     * and annotate it with the @Column annotation with the unique option set to “true”
     */
    @Column(unique = true)
    private String username;

    /**
     * Create a new private member variable called “password” of type “String”
     * and annotate it with the @Column annotation, no options enabled
     */
    @Column
    private String password;

    /**
     * Create a private Set of type Note called “noteSet” and set it equal to a new HashSet,
     * then annotate it with the @OneToMany Annotation with the mappedBy option set to “user”,
     * the fetch option set to the FetchType.LAZY, and the cascade types set to CascadeType.MERGE and CascadeType.PERSIST.
     *
     * @JsonManagedReference to handle the other half of mitigating infinite recursion.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();

    /**
     * create a custom constructor inside of the Entity that accepts a DTO argument.
     * Note that on the Entity side, we do not need to define the “id” member variable
     * when constructing a new object as that value is being generated for us by Hibernate’s @Id and @GeneratedValue annotations
     * @param userDto
     */
    public User(UserDto userDto) {
        if(userDto.getUsername() != null){
            this.username = userDto.getUsername();
        }
        if(userDto.getPassword() != null){
            this.password = userDto.getPassword();
        }
    }


    /**
     * Private member variables are only accessible within the class they reside in,
     * so for us to be able to get these values or set these values, we need to generate getters and setters for each field
     *
     * note: disabling them because added Lombok, which it generates getters and setters
     *      * as well as constructors
     */
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    /**
     * Next we need a way to create this object, and for that we need a constructor.
     * Constructors create Objects inside of Java, and you can overload constructors to be able to handle
     * multiple different scenarios when creating an object, the most common scenarios include
     * a No Argument constructor, and an All Argument constructor
     */
//    public User() {
//    }
//
//    public User(Long id, String username, String password) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//    }
}
