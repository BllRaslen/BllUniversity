package com.blluniversity.repositories;

import com.blluniversity.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {
}
