package edu.northeastern.cs5200;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

	
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@Component
@Transactional
public class TheatreDao {
	@Autowired
	PersonRepository personR;
	@Autowired
	ActorRepository actorR;
	@Autowired
	AdminRepository adminR;
	@Autowired
	CustomerRepository cusR;
	@Autowired
	ManagerRepository mgR;
	@Autowired
	StaffRepository staffR;
	@Autowired
	CommentRepository commentR;
	@Autowired
	LocationRepository locaR;
	@Autowired
	PerformanceRepository performanceR;
	@Autowired
	ShowRepository showR;
	@Autowired
	TicketRepository ticketR;
	
	public void truncateDatabase() {
		performanceR.deleteAll();
		commentR.deleteAll();
		showR.deleteAll();
		ticketR.deleteAll();
		locaR.deleteAll();
		personR.deleteAll();
		
	}
	
	public Actor createFaculty(Actor a) {
		return actorR.save(a);		
	}
	
	public void createAdmin(Admin a) {
		adminR.save(a);
		
	}
	
	public void createCustomer(Customer c) {
		cusR.save(c);
	}
	
	public void createManager(Manager m) {
		mgR.save(m);
	}
	
	public void createStaff(Staff s) {
		staffR.save(s);
	}
	
	public void createComment(Comment c) {
		commentR.save(c);
	}
	
	public void createLocation(Location l) {
		locaR.save(l);
	}
	
	public void createPerformance(Performance p) {
		performanceR.save(p);
	}
	
	public void createShow(Show s) {
		showR.save(s);
	}
	
	public Ticket createTicket(Ticket t) {
		return ticketR.save(t);
	}
	
	
	public void setCustomerForComment(Customer customer, Comment comment) {
		comment.setCustomer(customer);
		customer.addComment(comment);
		cusR.save(customer);
		commentR.save(comment);
		
	}
	
	
	public void addCommentToShow(Show show, Comment comment) {
		show.addComment(comment);
		comment.setShow(show);
		showR.save(show);
		commentR.save(comment);
		
	}
	
	public void addTicketToCustomer(Customer c, Ticket t) {
		c.addTicket(t);
		t.setCustomer(c);
		cusR.save(c);
		ticketR.save(t);
	}
	
	public void setStaffToTicket(Staff s, Ticket t) {
		s.addTicket(t);
		t.setStaff(s);
		ticketR.save(t);
		staffR.save(s);
	}
	
	public void addLocationToTicket(Ticket t, Location l) {
		l.addTicket(t);
		t.setLocation(l);
		ticketR.save(t);
		locaR.save(l);
	
	}
	
	
	public void ActorGeneratePerformance(Actor a, Show s) {
		Performance p = new Performance(a, s);
		
		p.setActor(a);
		p.setShow(s);
		a.addPerformances(p);
		s.addPerformance(p);
		
		actorR.save(a);
		performanceR.save(p);
		showR.save(s);
	}
	
	
	
	
	
	
	
	

}
