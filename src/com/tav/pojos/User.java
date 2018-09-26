package com.tav.pojos;

public class User {
	public long id;
	private String username;
	private String password;

	public User(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(long id, String username){
		this.id = id;
		this.username = username;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
