package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.UserRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//annotate the class with the @Service annotation
@Service
public class UserServiceImpl implements UserService {
    /**
     * Spring is able to find the corresponding dependency and inject it
     * where it is needed throughout the application by using the @Autowired annotation
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * creating a public method that returns a “List<String>” called “addUser” that accepts
     * a UserDto called “userDto” as an argument and annotate the method with the @Transactional annotation
     * (any time you are saving something to the database you should include the @Transactional annotation
     * which ensures that the transaction that gets opened with your datasource gets resolved)
     */
    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        //initialize a new member variable of type “List<String>” called “response” and set it equal to a new ArrayList
        List<String> response = new ArrayList<>();

        //Create a new method variable of type “User” (your User class from the “com.devmountain.noteApp” package)
        // called “user” and set that equal to a new User() and pass in the “userDto” from the method’s arguments
        User user = new User(userDto);

        //Now invoke the “saveAndFlush()” method available in the “userRepository” and pass in the “user” object
        // you just created, this step is where a user is actually people persisted***
        userRepository.saveAndFlush(user);

        //After the user object has been persisted add a String to “response” with a success message and return
        // the “response” method variable.
        response.add("http://localhost:8080/login.html");
        return response;
    }

    /**
     * Let’s create the second method now, create a public method that returns “List<String>”
     * called “userLogin” that accepts a UserDto called “userDto” as an argument
     */
    @Override
    public List<String> userLogin(UserDto userDto){
        //Initiate a new method variable called “response” of type “List<String>” and set it equal to a new ArrayList
        List<String> response = new ArrayList<>();

        //Create a new method variable called “userOptional” of type “Optional<User>” and set it equal to
        // the “findByUsername” method we are about to create in the “userRepository” and pass in the username field
        // from the “userDto” argument.
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());

        /**
         * Create two conditional statements, the first to see if “userOptional.isPresent()”
         * and the second to see if “passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())”
         * and if both those are true add a success message to the response list.
         * If not, add a message notifying the person that either the Username or the Password is incorrect.
         */

        if(userOptional.isPresent()){
            if(passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("http://localhost:8080/home.html");
                //If the “userOptional” is present we can also add the user’s Id to the response List
                // so that the front end can use the Id if they need to
                response.add(String.valueOf(userOptional.get().getId()));
            }else {
                response.add("Username or Password is incorrect");
            }
        }else {
            response.add("Username or Password is incorrect");
        }
        return response;
    }
    /**
     * Now that our implementation is complete, we can use the magic of IntelliJ to extract an interface for us!
     * Right click on any whitespace within the UserServiceImpl class and go to “Refactor” then to “Extract Interface”.
     * Name your service UserService and be sure to check the checkboxes next to the two member methods we’ve created and click “Refactor”
     */
}
