package com.app.services;

import java.util.List;

import com.app.dtos.StudentProfileDto;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;

public interface StudentProfileService {
	
	public StudentProfile viewStudentProfileByUsername(String username);
	
	public StudentProfileDto viewAttendanceByUsername(String username);
	
	public StudentProfileDto viewGradeByUsername(String username);
	
	public List<StudentProfile> searchStudents(String name, String department, String year);
	
	List<FacultyProfile> getFacultyAdvisors(String username);

}
