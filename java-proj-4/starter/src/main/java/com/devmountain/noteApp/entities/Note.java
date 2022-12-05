package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Lombok and looks at the member variables and can generate all of our getters and setters for us,
 * as well as the constructors all through 3 annotations
 */

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    /**
     * create two private member variables called “id” of type “Long”
     * and “body” of type “String” and give each member the corresponding annotations
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;


    //created and create a private member variable named “user” of Type “User”
    /**
     * @ManyToOne creates the association within Hibernate
     * @JsonBackReference prevents infinite recursion when you deliver the resource up as JSON through
     * the RESTful API endpoint you will create
     */
    @ManyToOne
    @JsonBackReference
    private User user;

    /**
     * create a custom constructor inside of the Entity that accepts a DTO argument.
     * Note that on the Entity side, we do not need to define the “id” member variable
     * when constructing a new object as that value is being generated for us by Hibernate’s @Id and @GeneratedValue annotations
     * @param noteDto
     */
    public Note(NoteDto noteDto) {
        if(noteDto.getBody() != null){
            this.body = noteDto.getBody();
        }
    }

    /**
     * generate the Getters and Setters,
     * generate All Arguments Constructor and the No Arguments Constructors
     *
     * note: disabling them because added Lombok, which it generates getters and setters
     * as well as constructors
     */

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }

//    public Note() {
//    }
//
//    public Note(Long id, String body) {
//        this.id = id;
//        this.body = body;
//    }
}
