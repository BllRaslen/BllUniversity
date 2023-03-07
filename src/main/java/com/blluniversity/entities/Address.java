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
            name = "address",
            nullable = false,
            length = 255,
            columnDefinition = "TEXT"
    )
    private String address;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne(/*cascade = CascadeType.ALL*/)
    @JoinColumn(
            name = "student_id_fk",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student _ address_id_fk"
            )


    )
    private Student student;


    public Address(String address) {
        this.address = address;
    }
    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
