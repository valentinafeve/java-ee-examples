package com.managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;

import com.classes.Product;

@ManagedBean
public class Controller {

	private List<Product> products;
	
	public Controller() {
		products = Product.getProducts();
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String listProducts() {
		System.out.println("list products");
		return "showProducts";
	}
	
	public String listUsers() {
		System.out.println("list users");
		return "showUsers";
	}
	
}
