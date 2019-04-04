package edu.northeastern.cs5200.models;

import javax.persistence.*;



@Entity
public class Admin extends Person {

	// constructor
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String username, String password, String firstName, String lastName) {
		super(id, username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	

}
