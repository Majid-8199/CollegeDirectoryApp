package com.app.servicesImp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.StudentProfileDto;
import com.app.entities.Attendance;
import com.app.entities.FacultyProfile;
import com.app.entities.Grade;
import com.app.entities.StudentProfile;
import com.app.entities.User;
import com.app.repositories.FacultyProfileRepository;
import com.app.repositories.StudentProfileRepository;
import com.app.repositories.AttendanceRepository;
import com.app.repositories.GradeRepository;
import com.app.repositories.UserRepository;
import com.app.services.StudentProfileService;

@Service
public class StudentProfileServiceImp implements StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public StudentProfile viewStudentProfileByUsername(String username) {
        User user = userRepository.findByUsername(username).get();
        return studentProfileRepository.findByUser(user);
    }

    @Override
    public StudentProfileDto viewAttendanceByUsername(String username) {
        StudentProfile studentProfile = viewStudentProfileByUsername(username);
        List<Attendance> attendances = attendanceRepository.findByStudent(studentProfile);
        StudentProfileDto studentProfileDto = studentProfile.getDTO();
        studentProfileDto.setAttendances(attendances);
        return studentProfileDto;
    }

    @Override
    public StudentProfileDto viewGradeByUsername(String username) {
        StudentProfile studentProfile = viewStudentProfileByUsername(username);
        List<Grade> grades = gradeRepository.findByStudent(studentProfile);
        StudentProfileDto studentProfileDto = studentProfile.getDTO();
        studentProfileDto.setGrades(grades);
        return studentProfileDto;
    }

    @Override
    public List<StudentProfile> searchStudents(String name, String department, String year) {
        List<StudentProfile> studentProfiles = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            studentProfiles.addAll(studentProfileRepository.findByUser_Name(name));
        }
        if (department != null && !department.isEmpty()) {
            studentProfiles.addAll(studentProfileRepository.findByDepartment_Name(department));
        }
        if (year != null) {
            studentProfiles.addAll(studentProfileRepository.findByYear(year));
        }
        return studentProfiles;
    }

    @Override
    public List<FacultyProfile> getFacultyAdvisors(String username) {
        StudentProfile studentProfile = viewStudentProfileByUsername(username);
        return facultyProfileRepository.findByDepartment(studentProfile.getDepartment());
    }
}