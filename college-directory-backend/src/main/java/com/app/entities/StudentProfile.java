package com.app.entities;

import com.app.dtos.StudentProfileDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class StudentProfile {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
	@NotBlank
    private User user;

	@NotBlank
    @Lob
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotBlank
    private Department department;

    @NotBlank
    @Size(max = 50)
    private String year;

	public Long getId() {
		return userId;
	}

	public void setId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public StudentProfile(Long userId, User user, byte[] photo, Department department, String year) {
		super();
		this.userId = userId;
		this.user = user;
		this.photo = photo;
		this.department = department;
		this.year = year;
	}
	
	public StudentProfile() {

	}
	
	public StudentProfileDto getDTO() {
		StudentProfileDto studentProfileDto=new StudentProfileDto();
		studentProfileDto.setUserId(userId);
		studentProfileDto.setDepartment(department);
		studentProfileDto.setByteimg(photo);
		studentProfileDto.setUser(user);
		studentProfileDto.setYear(year);
		return studentProfileDto;
	}
	
}