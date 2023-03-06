package com.blluniversity.entities;

import jakarta.persistence.*;

@Entity(name = "Faculty")
@Table(name = "Faculty")
public class Faculty {
    @Id
    @SequenceGenerator(
            name = "faculty_sequence",
            sequenceName = "faculty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "faculty_sequence"
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
            name = "faculty_name",
            nullable = false,
            length = 255,
            columnDefinition = "TEXT"
    )
    private String facultyName;





}
