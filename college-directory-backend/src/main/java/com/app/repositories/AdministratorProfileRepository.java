package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AdministratorProfile;
import com.app.entities.User;

public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Long>{

	AdministratorProfile findByUser(User user);
	
	AdministratorProfile findByUserUsername(String username);
	
}
