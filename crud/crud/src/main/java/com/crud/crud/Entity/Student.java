package com.crud.crud.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Students")

public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "email")
    private  String email;

    @Column(name = " contact")
    private int contact;


}
