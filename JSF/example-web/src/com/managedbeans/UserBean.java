package com.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.classes.User;

@ManagedBean
public class UserBean {
	
	private String username;
	private String password;
	private List<User> users;
	
	public UserBean(){
		this.users = User.getUsers();
	}
	
	public List<User> getUsers() {
		return User.getUsers();
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String getUsername() {
		return this.username;
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
	
	public String validateUser() {
		System.out.println("validating user...");
		List<User> users = User.getUsers();
		for (User user : users) {
			if (user.getUsername().equals(getUsername())) {
				if (user.getPassword().equals(getPassword())) {
					return "home";
				}
			}
		}
		return "error";
	}
}
