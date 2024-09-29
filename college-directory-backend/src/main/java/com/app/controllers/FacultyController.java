package com.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;
import com.app.services.FacultyProfileService;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin("${frontend.url}")
public class FacultyController {

    @Autowired
    private FacultyProfileService facultyProfileService;

    @GetMapping("/{username}")
    public ResponseEntity<FacultyProfile> viewFacultyProfileByUsername(String username) {
        try {
            FacultyProfile facultyProfile = facultyProfileService.viewFacultyProfileByUsername(username);
            return ResponseEntity.ok(facultyProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/class/{username}")
    public ResponseEntity<List<StudentProfile>> getClassList(String username) {
        try {
            List<StudentProfile> studentProfiles = facultyProfileService.getClassList(username);
            return ResponseEntity.ok(studentProfiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("update/{username}")
    public ResponseEntity<FacultyProfile> updateFacultyProfileByUsername(String username, FacultyProfile facultyProfile) {
        try {
            FacultyProfile updatedFacultyProfile = facultyProfileService.updateFacultyProfileByUsername(username, facultyProfile);
            return ResponseEntity.ok(updatedFacultyProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}