package edu.northeastern.cs5200.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date date = Calendar.getInstance().getTime() ;
	private float price = 100;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Location location;
	
	private String showname;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Staff staff;
	
	// constructor
	public Ticket() {
		super();
	}


	public Ticket(Date date, float price) {
		super();
		this.date = date;
		this.price = price;
	}
	
	public Ticket(float price) {
		super();
		this.price = price;
	}
	

	public Ticket(Date date, float price, Location location, String showName) {
		super();
		this.date = date;
		this.price = price;
		this.location = location;
		this.showname = showName;
	}


	// setter and getter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
		if(!location.getHadTickets().contains(this)) {
			location.getHadTickets().add(this);
		}
	}


	public String getShowName() {
		return showname;
	}


	public void setShowName(String showName) {
		this.showname = showName;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
		if(!customer.getboughtTickets().contains(this)) {
			customer.getboughtTickets().add(this);
		}
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
		if(!staff.getSoldtickets().contains(this));
		staff.getSoldtickets().add(this);
	}
	
	


}
