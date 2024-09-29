package com.app.dtos;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.app.entities.Attendance;
import com.app.entities.Department;
import com.app.entities.Grade;
import com.app.entities.User;

public class StudentProfileDto {

	private Long userId;
	private User user;
	private byte[] byteimg;
	private Department department;
	private String year;
	private MultipartFile img;   
	private String imgBase64;
	private List<Attendance> attendances;
    private List<Grade> grades;
	
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
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
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

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
}
