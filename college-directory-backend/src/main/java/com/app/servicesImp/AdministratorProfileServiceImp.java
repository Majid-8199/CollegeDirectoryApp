package com.app.servicesImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entities.AdministratorProfile;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;
import com.app.entities.User;
import com.app.repositories.AdministratorProfileRepository;
import com.app.repositories.FacultyProfileRepository;
import com.app.repositories.StudentProfileRepository;
import com.app.repositories.UserRepository;
import com.app.services.AdministratorProfileService;

@Service
public class AdministratorProfileServiceImp implements AdministratorProfileService {

    @Autowired
    private AdministratorProfileRepository administratorProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AdministratorProfile updateAdministratorByUsername(String username,AdministratorProfile administratorProfile) {
        AdministratorProfile existingAdministratorProfile = administratorProfileRepository.findByUserUsername(username);
        if (existingAdministratorProfile != null) {
            existingAdministratorProfile.setDepartment(administratorProfile.getDepartment());
            administratorProfileRepository.save(existingAdministratorProfile);
        }
		return existingAdministratorProfile;
    }

    @Override
    public AdministratorProfile viewAdministratorProfileByUsername(String username) {
        User user = userRepository.findByUsername(username).get();
        return administratorProfileRepository.findByUser(user);
    }

    @Override
    public StudentProfile addStudent(User user) {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setUser(user);
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public void updateStudentById(Long id, StudentProfile studentProfile) {
        StudentProfile existingStudentProfile = studentProfileRepository.findById(id).orElse(null);
        if (existingStudentProfile != null) {
            existingStudentProfile.setPhoto(studentProfile.getPhoto());
            existingStudentProfile.setDepartment(studentProfile.getDepartment());
            existingStudentProfile.setYear(studentProfile.getYear());
            studentProfileRepository.save(existingStudentProfile);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentProfileRepository.deleteById(id);
    }

    @Override
    public List<StudentProfile> viewAllStudents() {
        return studentProfileRepository.findAll();
    }

    @Override
    public FacultyProfile addFaculty(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    @Override
    public void updateFacultyById(Long id, FacultyProfile facultyProfile) {
        FacultyProfile existingFacultyProfile = facultyProfileRepository.findById(id).orElse(null);
        if (existingFacultyProfile != null) {
            existingFacultyProfile.setPhoto(facultyProfile.getPhoto());
            existingFacultyProfile.setDepartment(facultyProfile.getDepartment());
            existingFacultyProfile.setOfficeHours(facultyProfile.getOfficeHours());
            facultyProfileRepository.save(existingFacultyProfile);
        }
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyProfileRepository.deleteById(id);
    }

    @Override
    public List<FacultyProfile> viewAllFaculties() {
        return facultyProfileRepository.findAll();
    }

}