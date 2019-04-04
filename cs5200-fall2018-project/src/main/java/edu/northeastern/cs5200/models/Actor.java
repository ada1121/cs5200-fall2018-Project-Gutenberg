package edu.northeastern.cs5200.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Actor extends Person {
	
	@OneToMany(mappedBy="actor", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Performance> performedPerformances = new HashSet<Performance>();
	
	public void addPerformances(Performance p) {
		this.performedPerformances.add(p);
		if(!this.getPerformedPerformances().contains(p)) {
			this.getPerformedPerformances().add(p);
		}
	}
	

	// constructor
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(int id, String username, String password, String firstName, String lastName) {
		super(id, username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Actor(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}


	public Set<Performance> getPerformedPerformances() {
		return performedPerformances;
	}


	public void setPerformedPerformances(Set<Performance> performedPerformances) {
		this.performedPerformances = performedPerformances;
	}


	

}
