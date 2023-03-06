package com.blluniversity;


import com.blluniversity.entities.Faculty;
import com.blluniversity.entities.Student;
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
            FacultyRepository facultyRepository) {
        return args -> {


            for (int i = 0; i < 10; i++) {


            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);

            final var tip = new Faculty(faker.funnyName().name());
            Faculty faculty = facultyRepository.save(tip);

            final var student = new Student(firstName, lastName, email, faker.number().numberBetween(10, 20));
            faculty.addStudent(student);
            facultyRepository.save(faculty);
            }
        };
    }

}
