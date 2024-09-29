package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Attendance;
import com.app.entities.StudentProfile;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	List<Attendance> findByStudent(StudentProfile student);

}
