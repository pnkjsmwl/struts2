package com.test.spring.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.spring.model.User;

@Controller
@RequestMapping("/user")
public class UserServiceImpl{

	@Autowired
	private UserRepo userRepo;

	@Transactional
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Transactional
	@GetMapping("/{username}")
	public User findByUsername(@PathVariable String username) {
		User user = userRepo.findByUsername(username);
		if(user!=null && user.getId()>0) {
			System.out.println("User ID for:"+user.getUsername()+":"+user.getId());
			return user;
		}
		return null;
	}

	@Transactional
	public void deleteByUsername(String username) {
		//userRepo.deleteByUsername(username);
	}

	@Transactional
	@GetMapping("/all")
	public List<User> showAll() {
		return userRepo.findAll();
	}

	/*@Transactional
	public List<User> findByRole(String role) {
		//List<User> findByRole = userRepo.findByRole(role);
		return new ArrayList<User>();
	}*/



}
