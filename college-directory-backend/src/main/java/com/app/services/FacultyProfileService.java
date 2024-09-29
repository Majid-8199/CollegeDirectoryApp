package com.app.services;

import java.util.List;

import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;

public interface FacultyProfileService {

	public FacultyProfile viewFacultyProfileByUsername(String username);
	
	public List<StudentProfile> getClassList(String username);
	
    public FacultyProfile updateFacultyProfileByUsername(String username, FacultyProfile facultyProfile);
    
}
