package com.blluniversity.repositories;

import com.blluniversity.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FacultyRepository extends JpaRepository<Faculty , Long> {
}
