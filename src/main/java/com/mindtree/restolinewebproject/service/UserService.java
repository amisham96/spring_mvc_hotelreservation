package com.mindtree.restolinewebproject.service;

import java.util.Set;

import com.mindtree.restolinewebproject.entity.User;

public interface UserService {

	boolean registerUser(User user);

	int checkUser(User user);

	Set<User> getAllUsers();

	User getUserById();

}
