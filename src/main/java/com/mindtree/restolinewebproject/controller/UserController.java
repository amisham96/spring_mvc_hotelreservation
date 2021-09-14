package com.mindtree.restolinewebproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.restolinewebproject.entity.User;
import com.mindtree.restolinewebproject.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// static int userId;

	@RequestMapping(value = "/")
	public String indexpage() {
		return "index";
	}

	@RequestMapping(value = "/register")
	public String userRegistrationPage(Model model) {

		model.addAttribute("users", new User());
		return "user-registration-page";

	}

	@RequestMapping(value = "userregister", method = RequestMethod.POST)
	public String registerNewUser(@ModelAttribute("users") User user) {
		if (!userService.registerUser(user)) {
			return "error-in-register";
		}
		return "register-success-page";
	}

	@RequestMapping(value = "/login")
	public String userLoginPage(Model model) {

		model.addAttribute("users", new User());
		return "user-login-page";

	}
	
	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("users") User user,Model model) {

		int res = userService.checkUser(user);
		if (res == 0)
			return "error-in-login";
		else if (res == 1)
			return "error-in-loginpassword";
		else
			return homepage(model);
	}

	@RequestMapping(value = "/homepage")
	public String homepage(Model model) {
		model.addAttribute("user", userService.getUserById());
		return "home-page";
	}


}
