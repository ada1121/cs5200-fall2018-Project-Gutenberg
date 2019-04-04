package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	// constructor
	public Person() {}
	
	public Person(int id, String username, String password, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
	public Person( String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
	public Person( String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	// setter and getter
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
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	
	
}
