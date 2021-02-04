package com.tony.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.webservice.entities.Category;
import com.tony.webservice.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository catRepository;
	
	public List<Category> findAll() {
		return catRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = catRepository.findById(id);
		return obj.get();
	}
}
