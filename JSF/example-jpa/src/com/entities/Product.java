package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
public class Product implements Serializable {

	static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("example-jpa");
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String name;
	private String description;
	private float price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product() {
		super();
	}

	public static List<Product> getProducts() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT c FROM Product c WHERE c.id IS NOT NULL";
		TypedQuery<Product> tq = em.createQuery(query,  Product.class);
		List<Product> products = null;
		try {
			products = tq.getResultList();
			products.forEach( product -> System.out.println("Returning product "+product.getId()) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return products;
	}	
	
}
