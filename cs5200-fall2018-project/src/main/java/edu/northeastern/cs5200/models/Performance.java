package edu.northeastern.cs5200.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "performance")
public class Performance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore

	private Actor actor;

	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore

	private Show show;
	

	
	// constructor
	public Performance() {}
	
	

	public Performance(Actor acotr, Show show) {
		super();
		this.actor = acotr;
		this.show = show;
	}



	// setter and getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Actor getActor() {
		return actor;
	}


	public Show getShow() {
		return show;
	}

	public void setShow(Show s) {
		this.show = s;
		if(!s.getPerformances().contains(this)) {
			s.getPerformances().add(this);
		}
	}
	
	public void setActor(Actor a) {
		this.actor = a;
		if (!a.getPerformedPerformances().contains(this)) {
			a.getPerformedPerformances().add(this);
		}
	}

	

}
