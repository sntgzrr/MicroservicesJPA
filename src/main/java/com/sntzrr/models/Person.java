package com.sntzrr.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Person")
@Table(name = "\"Persons\"", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;
}
