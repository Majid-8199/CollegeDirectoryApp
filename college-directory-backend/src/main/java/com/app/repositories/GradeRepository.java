package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Grade;
import com.app.entities.StudentProfile;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{

	List<Grade> findByStudent(StudentProfile studentProfile);

}
