package com.JMThouseWeb.JMThouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.JMThouseWeb.JMThouse.model.User;
import com.JMThouseWeb.JMThouse.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
<<<<<<< HEAD
	
=======

	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}

>>>>>>> feature_login
	@GetMapping("/auth/login_form")
	public String loginForm() {
		return "user/login_form";
	}
<<<<<<< HEAD
	
	@GetMapping("/auth/join_form")
	public String save(User user) {
		return "user/join_form";
	}
	
=======

	@GetMapping("/auth/join_form")
	public String joinForm(User user) {
		return "user/join_form";
	}
	
	@GetMapping("/user/update_form")
	public String updateForm() {
		return "user/update_form";
	}

>>>>>>> feature_login
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
<<<<<<< HEAD
	
=======

>>>>>>> feature_login
	@PostMapping("/auth/joinProc")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
<<<<<<< HEAD

=======
>>>>>>> feature_login
}
