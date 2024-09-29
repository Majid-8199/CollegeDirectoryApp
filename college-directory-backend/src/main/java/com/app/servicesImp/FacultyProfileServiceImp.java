package com.app.servicesImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;
import com.app.entities.User;
import com.app.repositories.FacultyProfileRepository;
import com.app.repositories.StudentProfileRepository;
import com.app.repositories.UserRepository;
import com.app.services.FacultyProfileService;

@Service
public class FacultyProfileServiceImp implements FacultyProfileService {

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public FacultyProfile viewFacultyProfileByUsername(String username) {
        User user = userRepository.findByUsername(username).get();
        return facultyProfileRepository.findByUser(user);
    }

    @Override
    public List<StudentProfile> getClassList(String username) {
        FacultyProfile facultyProfile = facultyProfileRepository.findByUser(userRepository.findByUsername(username).get());
        return studentProfileRepository.findByDepartment(facultyProfile.getDepartment());
    }

    @Override
    public FacultyProfile updateFacultyProfileByUsername(String username, FacultyProfile facultyProfile) {
        FacultyProfile existingFacultyProfile = facultyProfileRepository.findByUser(userRepository.findByUsername(username).get());
        if (existingFacultyProfile != null) {
            existingFacultyProfile.setPhoto(facultyProfile.getPhoto());
            existingFacultyProfile.setDepartment(facultyProfile.getDepartment());
            existingFacultyProfile.setOfficeHours(facultyProfile.getOfficeHours());
            return facultyProfileRepository.save(existingFacultyProfile);
        } else {
            return null;
        }
    }
}