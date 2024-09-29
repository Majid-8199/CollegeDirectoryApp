package com.app.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Department;
import com.app.entities.User;

public class AdministratorProfileDto {

	private Long userId;
	private User user;
	private byte[] byteimg;
	private Department department;
	private MultipartFile img;   
	private String imgBase64;
	
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
	
	public byte[] getByteimg() {
		return byteimg;
	}
	
	public void setByteimg(byte[] byteimg) {
		this.byteimg = byteimg;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public MultipartFile getImg() {
		return img;
	}
	
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
	public String getImgBase64() {
		return imgBase64;
	}
	
	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}
	
}
