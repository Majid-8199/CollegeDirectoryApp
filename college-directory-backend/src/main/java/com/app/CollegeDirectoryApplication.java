package com.app;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.entities.AdministratorProfile;
import com.app.entities.Department;
import com.app.entities.User;
import com.app.enums.Role;
import com.app.repositories.AdministratorProfileRepository;
import com.app.repositories.UserRepository;


@SpringBootApplication
public class CollegeDirectoryApplication implements CommandLineRunner{

	@Autowired
	AdministratorProfileRepository repository;
	
	@Autowired
    UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CollegeDirectoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    Optional<AdministratorProfile> adminAccount=repository.findById((long) 1);
	    if(!adminAccount.isPresent()) {
	        User user=new User();
	        Department department=new Department();
	        AdministratorProfile admin=new AdministratorProfile();
	        user.setName("ADMIN");
	        user.setEmail("admin@gmail.com");
	        user.setUsername("admin");
	        user.setPhone("9856327458");
	        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
	        user.setRole(Role.ADMINISTRATOR);
	        
	        department.setName("Administration");
	        department.setDescription("Office and Administration");
	        
	        user = userRepository.save(user);
	        
	        byte[] imgBytes = getImageAsBytes("image/profilepicd.png");
	        admin.setPhoto(imgBytes);
	        admin.setDepartment(department);
	        admin.setUser(user);
	        repository.save(admin);
	    }
	}
	
	private byte[] getImageAsBytes(String imagePath) {
	    ClassPathResource imgFile = new ClassPathResource(imagePath);
	    try {
	        return imgFile.getInputStream().readAllBytes();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}

