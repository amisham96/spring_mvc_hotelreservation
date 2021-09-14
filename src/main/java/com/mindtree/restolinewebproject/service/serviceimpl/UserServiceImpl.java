package com.mindtree.restolinewebproject.service.serviceimpl;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restolinewebproject.entity.User;
import com.mindtree.restolinewebproject.repository.UserRepository;
import com.mindtree.restolinewebproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public static int userId;

	@Override
	public boolean registerUser(User user) {

		User user2 = userRepository.findByEmail(user.getEmail()).orElse(null);
		if (user2 != null)
			return false;

		userRepository.save(user);
		return true;

	}

	@Override
	public int checkUser(User user) {

		User user2 = userRepository.findByEmail(user.getEmail()).orElse(null);

		if (user2 == null)
			return 0;
		else {
			if (!user2.getPassword().equals(user.getPassword())) {
				return 1;
			}

		}
		userId = user2.getUserId();
		return 2;

	}

	public static int getUserId() {
		return userId;
	}

	@Override
	public Set<User> getAllUsers() {
		return new TreeSet<User>(userRepository.findAll().stream().collect(Collectors.toSet()));

	}

	

	@Override
	public User getUserById() {
		return userRepository.findById(getUserId()).get();
	}


}
