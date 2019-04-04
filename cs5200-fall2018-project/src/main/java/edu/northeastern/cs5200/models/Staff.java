package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Staff extends Person {
	@Column(name = "work")
	@Enumerated(EnumType.STRING)
	private Work work;
	
	@OneToMany(mappedBy="staff", fetch = FetchType.EAGER)
	@JsonIgnore

	private List<Ticket> soldtickets = new ArrayList<Ticket>();
	
	public void addTicket(Ticket t) {
		this.soldtickets.add(t);
		if(!this.getSoldtickets().contains(t)) {
			this.getSoldtickets().add(t);
		}
		
	}

	// constructor
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int id, String username, String password, String firstName, String lastName) {
		super(id, username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Staff(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	// setter and getter
	public Work getwork() {
		return work;
	}

	public void setwork(Work work) {
		this.work = work;
	}


	public List<Ticket> getSoldtickets() {
		return soldtickets;
	}

	public void setSoldtickets(List<Ticket> soldtickets) {
		this.soldtickets = soldtickets;
	}
	
	
	

}
