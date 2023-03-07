package com.blluniversity.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.ArrayList;
import java.util.List;

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




    @OneToMany(
            mappedBy = "faculty",
            orphanRemoval = true,
            cascade = CascadeType.ALL,

            fetch = FetchType.LAZY
    )
    private List<Student> studentList = new ArrayList<>();



    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public Faculty() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        if (!this.studentList.contains(student)) {
            this.studentList.add(student);
            student.setFaculty(this);
        }
    }


    public void removeStudent(Student student) {
        if (this.studentList.contains(student)) {
            this.studentList.remove(student);
            student.setFaculty(null);
        }
    }





    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
