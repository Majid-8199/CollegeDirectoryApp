package com.app.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Attendance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotBlank
    private StudentProfile student;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotBlank
    private Course course;
    
    @NotBlank
    private Date attendanceDate;
    
    @NotBlank
    private String attendanceStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentProfile getStudent() {
		return student;
	}

	public void setStudent(StudentProfile student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public Attendance(Long id, StudentProfile student, Course course, Date attendanceDate, String attendanceStatus) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.attendanceDate = attendanceDate;
		this.attendanceStatus = attendanceStatus;
	}
	
	public Attendance() {

	}
    
}
