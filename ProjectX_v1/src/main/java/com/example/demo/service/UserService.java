package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;


public interface UserService {
	public List<User> getAll();
	public User save(User user);
	public User findByEmail(String email);
	public User update(User user);
	public void delete(String id);
}
