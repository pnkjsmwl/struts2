package com.test.spring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.spring.domain.user.LoginDomain;
import com.test.spring.domain.user.RegisterDomain;
import com.test.spring.model.User;
import com.test.spring.repo.UserServiceImpl;

@Controller("/user")
public class UserController {

	/* Will be injected thru Setter DI */
	private LoginDomain login;
	private RegisterDomain register;

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {

		User userdb = userService.findByUsername(user.getUsername());
		
		if(userdb==null && register.validateRegistration(user)) {
			User register = userService.add(user);
			return new ResponseEntity<>(register, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {

		User userdb = userService.findByUsername(user.getUsername());

		if(userdb!=null && login.validateLogin(user)) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	/* Constructor DI */
	public UserController(LoginDomain login) {
		this.login = login;
	}

	/* Setter DI */
	public void setRegister(RegisterDomain register) {
		this.register = register;
	}
}