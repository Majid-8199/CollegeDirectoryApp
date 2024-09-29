package com.app.entities;

import com.app.dtos.AdministratorProfileDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class AdministratorProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @NotNull
    @Lob
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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

	public AdministratorProfile(Long userId, User user, byte[] photo, Department department) {
		super();
		this.userId = userId;
		this.user = user;
		this.photo = photo;
		this.department = department;
	}
	
	public AdministratorProfile() {

	}	
	
	public AdministratorProfileDto getDTO() {
		AdministratorProfileDto administratorProfileDto=new AdministratorProfileDto();
		administratorProfileDto.setUserId(userId);
		administratorProfileDto.setDepartment(department);
		administratorProfileDto.setByteimg(photo);
		return administratorProfileDto;
	}
	
}