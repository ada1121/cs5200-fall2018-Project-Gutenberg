package edu.northeastern.cs5200.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	
	private String name;
	private Date date;
	private String Description;

	@OneToMany(mappedBy="show", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Performance> performances = new HashSet<Performance>();

	@OneToMany(mappedBy="show", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JsonIgnore
	private Set<Comment> comments = new HashSet<Comment>();

	
	public void addPerformance(Performance p) {
		this.performances.add(p);
		if(!this.getPerformances().contains(p)) {
			this.getPerformances().add(p);
		}
	}
	
	public void addComment(Comment c) {
		this.comments.add(c);
		if(!this.getComments().contains(c)) {
			this.getComments().add(c);
		}
	}
	
	// constructor	
	public Show(int id, String name, Set<Performance> performances) {
		super();
		this.id = id;
		this.name = name;
		this.performances = performances;
	}

	public Show(String name) {
		super();
		this.name = name;
	}

	public Show() {
	}

	// setter and getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Performance> getPerformances() {
		return performances;
	}

	public void setPerformances(Set<Performance> performances) {
		this.performances = performances;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	

}
