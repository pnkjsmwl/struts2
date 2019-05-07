package com.test.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.model.User;

@Repository
interface UserRepo extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	//public List<User> findByRole(String role);
	public void deleteByUsername(String username);
}
