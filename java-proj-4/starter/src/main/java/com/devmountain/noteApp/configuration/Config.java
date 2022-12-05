package com.devmountain.noteApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {
    /**
     * Create a new public member variable of type “PasswordEncoder” called “passwordEncoder” annotated with
     * the @Bean annotation and invoke it, open up a set of curly brackets and within the curly brackets
     * return a new BCryptPasswordEncoder().
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
