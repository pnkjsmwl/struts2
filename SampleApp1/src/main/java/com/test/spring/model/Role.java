package com.test.spring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Role(String selectedRole) {
		role = selectedRole;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (!(o instanceof Role )) 
			return false;
		return id >0 && id==((Role) o).getId();
	}
	@Override
	public int hashCode() {
		return 31;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}