package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dtos.StudentProfileDto;
import com.app.entities.FacultyProfile;
import com.app.entities.StudentProfile;
import com.app.services.StudentProfileService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("${frontend.url}")
public class StudentController {

    @Autowired
    private StudentProfileService studentProfileService;

    @GetMapping("/{username}")
    public ResponseEntity<StudentProfile> viewStudentProfileByUsername(@PathVariable String username) {
        try {
            StudentProfile studentProfile = studentProfileService.viewStudentProfileByUsername(username);
            return ResponseEntity.ok(studentProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/attendances/{username}")
    public ResponseEntity<StudentProfileDto> viewAttendanceByUsername(@PathVariable String username) {
        try {
            StudentProfileDto studentProfile = studentProfileService.viewAttendanceByUsername(username);
            return ResponseEntity.ok(studentProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/grades/{username}")
    public ResponseEntity<StudentProfileDto> viewGradeByUsername(@PathVariable String username) {
        try {
            StudentProfileDto studentProfile = studentProfileService.viewGradeByUsername(username);
            return ResponseEntity.ok(studentProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentProfile>> searchStudents(@RequestParam(required = false) String name, @RequestParam(required = false) String department, @RequestParam(required = false) String year) {
        try {
            List<StudentProfile> studentProfiles = studentProfileService.searchStudents(name, department, year);
            return ResponseEntity.ok(studentProfiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/facultyAdvisors/{username}")
    public ResponseEntity<List<FacultyProfile>> getFacultyAdvisors(@PathVariable String username) {
        try {
            List<FacultyProfile> facultyProfiles = studentProfileService.getFacultyAdvisors(username);
            return ResponseEntity.ok(facultyProfiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}