package com.tony.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tony.webservice.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
