package com.test.spring.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.spring.model.User;

@Component
public class UserServiceImpl{

	@Autowired
	private UserRepo userRepo;

	@Transactional
	public User add(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Transactional
	public User findByUsername(String username) {
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
	public List<User> showAll() {
		List<User> findAll = userRepo.findAll();

		return findAll;
	}

	/*@Transactional
	public List<User> findByRole(String role) {
		//List<User> findByRole = userRepo.findByRole(role);
		return new ArrayList<User>();
	}*/

	

}
