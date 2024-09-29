package com.app.entities;

import com.app.dtos.FacultyProfileDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class FacultyProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private User user;

    @NotNull
    @Size(max = 255)
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @NotNull
    @Size(max = 255)
    private String officeHours;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public FacultyProfile(Long userId, User user, byte[] photo, Department department, String officeHours) {
		super();
		this.userId = userId;
		this.user = user;
		this.photo = photo;
		this.department = department;
		this.officeHours = officeHours;
	}
	
	public FacultyProfile() {

	}
	
	public FacultyProfileDto getDTO() {
		FacultyProfileDto facultyProfileDto=new FacultyProfileDto();
		facultyProfileDto.setUserId(userId);
		facultyProfileDto.setDepartment(department);
		facultyProfileDto.setByteimg(photo);
		facultyProfileDto.setUser(user);
		facultyProfileDto.setOfficeHours(officeHours);
		return facultyProfileDto;
	}
	
}