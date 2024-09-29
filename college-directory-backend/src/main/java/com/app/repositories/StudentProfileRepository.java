package com.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Department;
import com.app.entities.StudentProfile;
import com.app.entities.User;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long>{

	List<StudentProfile> findByUser_Name(String name);
    List<StudentProfile> findByDepartment_Name(String department);
    List<StudentProfile> findByYear(String year);
    List<StudentProfile> findByDepartment(Department department);
    StudentProfile findByUser(User user);
    
}
