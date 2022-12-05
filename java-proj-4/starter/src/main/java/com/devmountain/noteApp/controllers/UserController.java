package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.services.UserService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * annotate it with the @RestController annotation as well as the @RequestMapping annotation.
 * The RequestMapping annotation can accept a String as an option and that is where you can designate
 * a class level path that all further endpoints will begin at
 */
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    /**
     * First we need to Autowire in our Dependencies, which are the UserService because Controllers interact with ServiceLayers
     * and the PasswordEncoder so that we can have incoming passwords
     */
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
    //create a method that will handle POST requests to be able to register a User.
    //Create a public method that returns a List<String> called addUser that accepts an argument of type UserDto called “userDto”

     * annotate this method with the @PostMapping annotation and within parentheses
     * add a string routing this method to get triggered at the “/register” endpoint.
     * We also need to annotate the UserDto argument with the @RequestBody annotation
     * so that the JSON body object on the request gets mapped to our DTO and becomes usable
     */
    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto){
        /**
         * hash the incoming password so that we don’t unintentionally save a raw password to our database.
         * Create a member variable of type “String” called “passHash” and set it equal to the method available
         * on the “passwordEncoder” called “encode()” and pass in the “password” field from the “userDto” argument
         */
        String passHash = passwordEncoder.encode(userDto.getPassword());

        //Invoke the “setPassword()” method available on the “userDto” argument and pass in the “passHash” variable.
        userDto.setPassword(passHash);

        //return the “addUser()” method available on the “userService” dependency and pass in the “userDto” argument.
        return userService.addUser(userDto);
    }

    /**
     * create the next method that will take care of Logging a User in. It will be another POST request,
     * so create a public method that returns a “List<String>” called “userLogin” and have it accept a UserDto argument called “userDto”

     * Annotate the method with the @PostMapping annotation and give it the endpoint “/login”.
     * Annotate the UserDto argument with @RequestBody so that the JSON request body becomes usable to us
     */
    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto){
        //Return the “userLogin()” method available on “userService” and pass in the “userDto” argument
        return userService.userLogin(userDto);
    }

}
