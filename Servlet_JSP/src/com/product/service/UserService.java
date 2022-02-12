package com.product.service;

import java.util.Optional;

import com.product.persistance.User;

public interface UserService {
	public void addUser(User user);
	public Optional<User> getUser(String username, String password);
}
