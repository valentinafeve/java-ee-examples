package com.classes;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static List<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUsername("username1");
		user1.setName("Beatriz Pinzón Solano");
		user1.setPassword("afsdhjl");
		User user2 = new User();
		user2.setUsername("username2");
		user2.setName("Fermina Daza");
		user2.setPassword("afsdhjl");
		User user3 = new User();
		user3.setUsername("username3");
		user3.setPassword("afsdhjloooo");
		user3.setName("Florentino Ariza");
		User user4 = new User();
		user4.setUsername("username4");
		user4.setName("Juvenal Urbino");
		user4.setPassword("contraseniosa");
		User user5 = new User();
		user5.setUsername("username5");
		user5.setName("Constantino Levin");
		user5.setPassword("afsdhjl");
		User user6 = new User();
		user6.setUsername("username6");
		user6.setName("Winston Smith");
		user6.setPassword("shajkshaasj");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		return users;
	}
}
