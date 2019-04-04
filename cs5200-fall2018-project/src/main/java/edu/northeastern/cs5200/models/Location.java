package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int capacity = 200;

	
	@OneToMany(mappedBy="location", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Ticket> hadTickets = new ArrayList<Ticket>();
	
	public void addTicket(Ticket t) {
		this.hadTickets.add(t);
		if(!this.getHadTickets().contains(t)) {
			this.getHadTickets().add(t);
		}
	}
	
	//constructor
	public Location() {
	}
	
	public Location(String name) {
		this.name = name;
	}
	public Location(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// setter and getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Ticket> getHadTickets() {
		return hadTickets;
	}

	public void setHadTickets(List<Ticket> hadTickets) {
		this.hadTickets = hadTickets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	

}
