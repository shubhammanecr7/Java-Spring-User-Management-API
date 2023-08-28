package com.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entity.User;
import com.shubham.exception.ResourceNotFoundException;
import com.shubham.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// GET ALL USERS
	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// GET USER BY ID
	@GetMapping("/{id}")
	public User getUserByID(@PathVariable long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
	}

	// CREATE USER
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// UPDATE USER
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) {
		// first we will fetch the existing user with given user id
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));

		// update the existing user with new details
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());

		return userRepository.save(existingUser);
	}

	// DELETE USER BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable long id) {
		// first we will fetch the existing user with given user id
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));

		userRepository.delete(existingUser);
		return ResponseEntity.ok(existingUser);
	}
}
