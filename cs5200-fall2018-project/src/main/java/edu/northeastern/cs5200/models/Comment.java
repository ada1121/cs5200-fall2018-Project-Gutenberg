package edu.northeastern.cs5200.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String context;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Show show;

	// constructor
	public Comment() {	}

	public Comment(String context, Customer customer) {
		this.context = context;
		this.customer = customer;
	}

	public Comment(String context) {
		this.context = context;
	}
	
	// setter and getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		if(!customer.getComments().contains(this)) {
			customer.getComments().add(this);
		}
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
		if(!show.getComments().contains(this)) {
			show.getComments().add(this);
		}
	}
	
	
	
	
	
	
	

}
