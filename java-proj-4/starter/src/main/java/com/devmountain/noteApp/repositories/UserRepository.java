package com.devmountain.noteApp.repositories;


import com.devmountain.noteApp.entities.User;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//annotate the interface with the @Repository annotation
// (this is what clues Spring Boot in to keep track of this resource for Dependency Injection)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
