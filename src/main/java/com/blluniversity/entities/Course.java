package com.blluniversity.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Course")
@Table(name = "Course")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
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
            name = "course_name",
            nullable = false,
            length = 255,
            columnDefinition = "TEXT"
    )
    private String courseName;


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @ManyToMany(
            mappedBy = "courses"
    )
    private List<Student> students = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "proffesor_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_professor_id_fk"
            )
    )
    private Professor professor;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public Course(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
