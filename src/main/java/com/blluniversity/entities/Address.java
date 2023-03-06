package com.blluniversity.entities;


import jakarta.persistence.*;

@Entity(name = "Address")
@Table(name = "Address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            length = 5,
            updatable = false,
            unique = true
    )
    private Long id;
    @Column(
            name = "addres",
            nullable = false,
            length = 255,
            columnDefinition = "TEXT"
    )
    private String addres;
}
