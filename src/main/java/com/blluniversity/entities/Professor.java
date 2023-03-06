package com.blluniversity.entities;


import jakarta.persistence.*;

@Entity(name = "Professor")
@Table(
        name = "Professor",
        uniqueConstraints =@UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        ) )
public class Professor {

    @Id
    @SequenceGenerator(
            name = "professor_sequence",
            sequenceName = "professor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            length = 11,
            updatable = false,
            unique = true
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            length = 255,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            length = 255,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            length = 255,
            columnDefinition = "TEXT"
    )
    private String email;

}
