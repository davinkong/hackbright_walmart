package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.User;
import java.io.Serializable;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//implement the Serializable interface to allow this class to be converted
//to a Bytestream and sent outside the application or stored in a log file
public class UserDto implements Serializable {
    /**
     * Create four private member variables: one called “id” of type “Long”,
     * one called “username” of type “String”,
     * one called “password” of type “String”,
     * and one called “noteDtoSet” of type “Set<NoteDto>” and set it equal to a new HashSet.
     * Note that these member variables do not have any annotations associated with them.
     */
    private Long id;
    private String username;
    private String password;
    Set<NoteDto> noteDtoSet = new HashSet<>();

/**
 *  create a custom constructor that accepts a User object as its argument and maps
 *  the DTO object fields accordingly. This step provides an opportunity to include
 *  some conditional logic within the constructor to prevent null pointer exceptions,
 *  you may hear this called “sanity checking” in your career as a software developer
 */

    public UserDto(User user){
        if(user.getId() != null){
            this.id = user.getId();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
        }
        if(user.getPassword() != null){
            this.password = user.getPassword();
        }
    }
}
