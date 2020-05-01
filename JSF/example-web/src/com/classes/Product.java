package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int id;
	private float price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	public static List<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setId(1);
		product1.setName("Producto número 1");
		Product product2 = new Product();
		product2.setId(2);
		product2.setName("Producto número 2");
		Product product3 = new Product();
		product3.setId(3);
		product3.setName("Producto número 3");
		Product product4 = new Product();
		product4.setId(4);
		product4.setName("Producto número 4");
		Product product5 = new Product();
		product5.setId(5);
		product5.setName("Producto número 5");
		Product product6 = new Product();
		product6.setId(6);
		product6.setName("Producto número 6");
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		
//		The products should come from the bean
		
		return products;
	}
}
