package com.blluniversity.entities;


import jakarta.persistence.*;

@Entity(name = "Student")
@Table(
        name = "student"/*,
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )*/)
public class Student {


    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1,initialValue = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
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
    @Column(
            name = "age",
            length = 3,
            columnDefinition = "Integer"
    )
    private Integer age;
    @ManyToOne
    @JoinColumn(
            name = "faculty_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "student_faculty_fk"
            )
    )
    public Faculty faculty;


    public Student(Long id, String firstName, String lastName, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;

    }

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lastName;
    }

    public void setLasttName(String lasttName) {
        this.lastName = lasttName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
