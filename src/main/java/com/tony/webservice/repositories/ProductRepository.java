package com.tony.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tony.webservice.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
