package com.test.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {

	User(){}

	public User(String name, String username, String password, Set<Role> roles) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String username;
	private String password;


	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Role> roles = new HashSet<Role>();

	@OneToOne(mappedBy="user",cascade=CascadeType.ALL, orphanRemoval=true)
	private Cart cart;

	public void addRole(Role role) {
		roles.add(role);
		role.setUser(this);
	}
	public void removeRole(Role role) {
		roles.remove(role);
		role.setUser(null);
	}

	public void addCart(Cart cart) {
		this.cart = cart;
		cart.setUser(this);
	}
	public void removeCart(Cart cart) {
		this.cart = null;
		cart.setUser(null);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}