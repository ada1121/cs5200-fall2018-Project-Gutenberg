package edu.northeastern.cs5200.models;

import javax.persistence.Entity;



@Entity
public class Manager extends Person {

	// constructor
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String username, String password, String firstName, String lastName) {
		super(id, username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Manager(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	
}
