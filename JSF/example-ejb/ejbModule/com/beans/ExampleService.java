package com.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Product;
import com.entities.User;

/**
 * Session Bean implementation class ExampleService
 */
@Stateless
@LocalBean
public class ExampleService implements ExampleServiceRemote, ExampleServiceLocal {

    /**
     * Default constructor. 
     */
    public ExampleService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Product> getProducts() {
		return Product.getProducts();
	}

	@Override
	public List<User> getUsers() {
		return User.getUsers();
	}

	@Override
	public boolean validateUser(String username, String password) {
		return false;
	}

}
