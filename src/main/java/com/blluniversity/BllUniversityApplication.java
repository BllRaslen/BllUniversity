package com.blluniversity;


import com.blluniversity.entities.*;
import com.blluniversity.repositories.*;
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
            CourseRepository courseRepository,
            ProffesorRepository proffesorRepository) {
        return args -> {
/*

            for (int i = 0; i < 20; i++) {


            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);

            final var tip = new Faculty(faker.funnyName().name());
            Faculty faculty = facultyRepository.save(tip);
          //  faculty.addStudent(new Student(firstName, lastName, email, faker.number().numberBetween(10, 20)));
            //faculty.addStudent(new Student(firstName, lastName, email, faker.number().numberBetween(10, 20)));
            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(10, 20));
            faculty.addStudent(student);

            Address address = new Address(
                    firstName + " Mahallesi. " + lastName + " SK. " + " No : " + faker.number().numberBetween(50, 70)
            );

            Professor professor = new Professor(firstName, lastName, email);

            proffesorRepository.save(professor);

            student.enrolToCourse(new Course("Course : " + firstName + "Bilal"));


            facultyRepository.save(faculty);
            addressRepository.save(address);

            }
            */


            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Faculty fenBilimleri = new Faculty("Fen Bilimleri Fakultesi");
            Faculty muhendislik = new Faculty("Muhendislik Fakultesi");
            Faculty tip = new Faculty("Fen Bilimleri Fakultesi");


            Address addressStudentFenBilimleri = new Address(faker.regexify(faker.address().fullAddress()));
            Course courseMath = new Course("VTYS");
            final var studentFenBilimleri = new Student("hoca : " + firstName,
                    lastName,
                    email,
                    20);
            fenBilimleri.addStudent(studentFenBilimleri);
            studentFenBilimleri.enrolToCourse(courseMath);
            studentFenBilimleri.setAddress(addressStudentFenBilimleri);


            Address addressStudentMuhendislik = new Address(faker.regexify(faker.address().fullAddress()));
            Course courseVTYS = new Course("VTYS");
            final var studentMuhendislik = new Student("Muh : " + firstName,
                    lastName,
                    email,
                    21);
            muhendislik.addStudent(studentMuhendislik);
            studentMuhendislik.enrolToCourse(courseVTYS);
            studentMuhendislik.setAddress(addressStudentMuhendislik);


            Address addressStudentTip = new Address(faker.address().fullAddress());
            Course courseAnatomy = new Course("VTYS");
            final var studentTip = new Student("DR : " + firstName,
                    lastName,
                    email,
                    22);
            tip.addStudent(studentTip);
            studentTip.enrolToCourse(courseAnatomy);
            studentTip.setAddress(addressStudentTip);

            facultyRepository.save(tip);
            facultyRepository.save(muhendislik);
            facultyRepository.save(fenBilimleri);

        };


    }

    ;
}


