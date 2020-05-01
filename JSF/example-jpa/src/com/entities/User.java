package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */

@Entity
public class User implements Serializable {

	static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("example-jpa");
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User() {
		super();
	}
	
	public static List<User> getUsers() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT c FROM User c WHERE c.id IS NOT NULL";
		TypedQuery<User> tq = em.createQuery(query,  User.class);
		List<User> users= null;
		try {
			users= tq.getResultList();
			users.forEach( user -> System.out.println("Returning user "+user.getId()) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return users;
	}
   
}
