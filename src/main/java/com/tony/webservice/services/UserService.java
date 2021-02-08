package com.tony.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.webservice.entities.User;
import com.tony.webservice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateData(Long id, User userChanges) {
		User currentUser = userRepository.getOne(id);
		updateData(currentUser, userChanges);
		return userRepository.save(currentUser);
	}

	private void updateData(User currentUser, User userChanges) {
		currentUser.setName(userChanges.getName());		
		currentUser.setEmail(userChanges.getEmail());		
		currentUser.setPhone(userChanges.getPhone());		
	}
}
