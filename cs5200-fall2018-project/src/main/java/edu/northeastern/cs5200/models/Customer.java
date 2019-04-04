package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer extends Person {
	
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Ticket> boughtTickets = new ArrayList<Ticket>();
	
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JsonIgnore
	private Set<Comment> comments = new HashSet<Comment>();
	
	public void addTicket(Ticket t) {
		this.boughtTickets.add(t);
		if(!this.getboughtTickets().contains(t)) {
			this.getboughtTickets().add(t);
		}
	}
	
	public void addComment(Comment c) {
		this.comments.add(c);
		if(!this.getComments().contains(c)) {
			this.getComments().add(c);
		}
	}
	// constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String username, String password, String firstName, String lastName) {
		super(id, username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	
	// setter and getter
	public List<Ticket> getboughtTickets() {
		return boughtTickets;
	}

	public void setboughtTickets(List<Ticket> boughtTickets) {
		this.boughtTickets = boughtTickets;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	

}
