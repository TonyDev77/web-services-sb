package com.tony.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.webservice.entities.Product;
import com.tony.webservice.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prodRepository;

	public List<Product> findAll() {
		return prodRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = prodRepository.findById(id);
		return obj.get();
	}
}
