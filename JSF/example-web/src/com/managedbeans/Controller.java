package com.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.entities.Product;
import com.entities.User;

@ManagedBean
public class Controller {

	private String username;
	private String password;
	private List<Product> products;
	private List<User> users;
	
	public Controller() {
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

	public String listProducts() {
		System.out.println("list products");
		return "showProducts";
	}
	
	public String listUsers() {
		System.out.println("list users");
		return "showUsers";
	}
	
	public String validateUser() {
		System.out.println("validate users");
		return "home";
	}
	
}
