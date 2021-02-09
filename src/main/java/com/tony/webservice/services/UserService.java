package com.tony.webservice.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tony.webservice.entities.User;
import com.tony.webservice.repositories.UserRepository;
import com.tony.webservice.services.exceptions.DatabaseException;
import com.tony.webservice.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User updateData(Long id, User userChanges) {
		try {
			User currentUser = userRepository.getOne(id);
			updateData(currentUser, userChanges);
			return userRepository.save(currentUser);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User currentUser, User userChanges) {
		currentUser.setName(userChanges.getName());		
		currentUser.setEmail(userChanges.getEmail());		
		currentUser.setPhone(userChanges.getPhone());		
	}
}
