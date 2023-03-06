package com.blluniversity.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",

            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student1_id_fk"
            )
    )
    private Address address;

    @ManyToMany(

    cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "enrolment" ,
            joinColumns = @JoinColumn(
                    name = "student_id_",
                    foreignKey =@ForeignKey(
                            name = "enrolment_student_id_fk" )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id_",
                    foreignKey =@ForeignKey(
                            name = "enrolment_course_id_fk" )
            )

    )
    private List<Course> courses = new ArrayList<>();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public  void enrolToCourse(Course course){
        courses.add(course);
        course.getStudents().add(this);

    }
    public  void unEnrolToCourse(Course course){
        courses.remove(course);
        course.getStudents().remove(this);

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
