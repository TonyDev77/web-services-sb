package com.tony.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tony.webservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
