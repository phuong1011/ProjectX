package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User update(User user) {
		User newUser = userRepository.getOne(user.getUserId());
		if(user!=null && newUser!=null) {
			newUser.setDisplayName(user.getDisplayName());
			newUser.setDob(user.getDob());
			newUser.setEmail(user.getEmail());
			newUser.setGender(user.getGender());
			newUser.setProviderId(user.getProviderId());
			newUser.setUserType(user.getUserType());
			userRepository.save(newUser);
		}
		return newUser;
	}

	@Override
	public void delete(String id) {
		User user = userRepository.getOne(id);
		if(user != null) {
			userRepository.delete(user);
		}
	}
	
}
