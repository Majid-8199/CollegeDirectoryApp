package com.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Department;
import com.app.entities.FacultyProfile;
import com.app.entities.User;

@Repository
public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long>{

	FacultyProfile findByUser(User user);

	List<FacultyProfile> findByDepartment(Department department);

}
