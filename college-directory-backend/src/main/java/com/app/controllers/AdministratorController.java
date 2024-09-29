package com.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entities.AdministratorProfile;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;
import com.app.entities.User;
import com.app.services.AdministratorProfileService;

@RestController
@RequestMapping("/api/administrator")
@CrossOrigin("${frontend.url}")
public class AdministratorController {

    @Autowired
    private AdministratorProfileService administratorService;

    @PutMapping("/updateAdmin/{username}")
    public ResponseEntity<AdministratorProfile> updateAdministrator(String username, AdministratorProfile administratorProfile) {
        try {
            AdministratorProfile updatedAdministratorProfile = administratorService.updateAdministratorByUsername(username, administratorProfile);
            return ResponseEntity.ok(updatedAdministratorProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<AdministratorProfile> viewAdministratorProfileByUsername(String username) {
        try {
            AdministratorProfile administratorProfile = administratorService.viewAdministratorProfileByUsername(username);
            return ResponseEntity.ok(administratorProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentProfile> addStudent(User user) {
        try {
            StudentProfile studentProfile = administratorService.addStudent(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("updateStudent/{username}")
    public ResponseEntity<Void> updateStudentById(Long id, StudentProfile studentProfile) {
        try {
        	administratorService.updateStudentById(id, studentProfile);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(Long id) {
        try {
        	administratorService.deleteStudent(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/students/{username}")
    public ResponseEntity<List<StudentProfile>> viewAllStudents() {
        try {
            List<StudentProfile> studentProfiles = administratorService.viewAllStudents();
            return ResponseEntity.ok(studentProfiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addFaculty")
    public ResponseEntity<FacultyProfile> addFaculty(FacultyProfile facultyProfile) {
        try {
            FacultyProfile addedFacultyProfile = administratorService.addFaculty(facultyProfile);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedFacultyProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("updateFaculty/{username}")
    public ResponseEntity<Void> updateFacultyById(Long id, FacultyProfile facultyProfile) {
        try {
        	administratorService.updateFacultyById(id, facultyProfile);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteFaculty/{id}")
    public ResponseEntity<Void> deleteFaculty(Long id) {
        try {
        	administratorService.deleteFaculty(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/faculties")
    public ResponseEntity<List<FacultyProfile>> viewAllFaculties() {
        try {
            List<FacultyProfile> facultyProfiles = administratorService.viewAllFaculties();
            return ResponseEntity.ok(facultyProfiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}