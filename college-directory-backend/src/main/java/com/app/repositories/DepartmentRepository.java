package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
