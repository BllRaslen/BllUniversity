package com.blluniversity;


import com.blluniversity.entities.Address;
import com.blluniversity.entities.Course;
import com.blluniversity.entities.Faculty;
import com.blluniversity.entities.Student;
import com.blluniversity.repositories.AddressRepository;
import com.blluniversity.repositories.CourseRepository;
import com.blluniversity.repositories.FacultyRepository;
import com.blluniversity.repositories.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BllUniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BllUniversityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            FacultyRepository facultyRepository,
            AddressRepository addressRepository,
            CourseRepository courseRepository) {
        return args -> {


            for (int i = 0; i < 20; i++) {

            }
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);

            final var tip = new Faculty(faker.funnyName().name());
            Faculty faculty = facultyRepository.save(tip);
            faculty.addStudent(new Student(firstName, lastName, email, faker.number().numberBetween(10, 20)));
            faculty.addStudent(new Student(firstName, lastName, email, faker.number().numberBetween(10, 20)));
            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(10, 20));
            faculty.addStudent(
                    student);

            Address address = new Address(
                    firstName + " Mahallesi. " + lastName + " SK. " + " No : " + faker.number().numberBetween(50, 70)
            );



            student.enrolToCourse(new Course("Course : " + firstName + "Bilal"));
            student.enrolToCourse(new Course("Course : " + firstName + "Bilal"));
            student.enrolToCourse(new Course("Course : " + firstName + "Bilal"));








            facultyRepository.save(faculty);
            addressRepository.save(address);
        };



        };
    }


