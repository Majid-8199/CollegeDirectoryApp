package com.app.services;

import java.util.List;

import com.app.entities.AdministratorProfile;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;
import com.app.entities.User;

public interface AdministratorProfileService {

	public AdministratorProfile updateAdministratorByUsername(String Username, AdministratorProfile administratorProfile);
	
	public AdministratorProfile viewAdministratorProfileByUsername(String username);
	
	public StudentProfile addStudent(User user);
	
	public void updateStudentById(Long id, StudentProfile studentProfile);
	
	public void deleteStudent(Long id);
	
	public List<StudentProfile> viewAllStudents();
	
	public FacultyProfile addFaculty(FacultyProfile facultyProfile);
	
	public void updateFacultyById(Long id, FacultyProfile facultyProfile);
	
	public void deleteFaculty(Long id);
	
	public List<FacultyProfile> viewAllFaculties();
	
}
