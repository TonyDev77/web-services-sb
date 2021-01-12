package com.tony.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tony.webservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
