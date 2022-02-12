package com.product.service;

import java.util.Optional;

import com.product.persistance.User;
import com.product.persistance.UserDao;
import com.product.persistance.UserDaoImpl;

public class UserServiceImpl implements UserService{

	private UserDao userdao=null;
	public UserServiceImpl() {
		userdao=new UserDaoImpl();
	}

	@Override
	public void addUser(User user) {
		userdao.addUser(user);
		
	}

	@Override
	public Optional<User> getUser(String username, String password) {
		return userdao.getUser(username, password);
	}

}
