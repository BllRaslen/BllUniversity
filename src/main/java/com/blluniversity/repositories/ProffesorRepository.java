package com.blluniversity.repositories;

import com.blluniversity.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProffesorRepository extends JpaRepository<Professor, Long > {
}
