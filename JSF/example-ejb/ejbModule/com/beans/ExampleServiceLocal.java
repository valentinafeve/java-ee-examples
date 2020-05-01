package com.beans;

import java.util.List;

import javax.ejb.Local;

import com.entities.Product;
import com.entities.User;

@Local
public interface ExampleServiceLocal {

	public List<Product> getProducts();
	public List<User> getUsers();
	public boolean validateUser(String username, String password);
	
}
