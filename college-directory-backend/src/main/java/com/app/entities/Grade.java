package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Grade {
	
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
    private String grade;
    
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
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Grade(Long id, StudentProfile student, Course course, String grade) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
    
    public Grade() {
    	
	}
    
}
