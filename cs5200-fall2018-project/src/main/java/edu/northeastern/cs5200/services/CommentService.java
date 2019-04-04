package edu.northeastern.cs5200.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import edu.northeastern.cs5200.TheatreDao;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	TheatreDao dao;
	

	
	@PostMapping("/api/comment")
	public Comment createComment(@RequestBody Comment comment) {
		return commentRepository.save(comment);
	}

	@PostMapping("/api/customer/{custId}/show/{showId}/comment")
	public Comment createCommentByCustomerId(@PathVariable("custId") int id, 
			@PathVariable("showId") int showId, @RequestBody Comment comment) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer c = optional.get();
		c.addComment(comment);
		customerRepository.save(c);
		comment.setCustomer(c);
		
		Optional<Show> sOptional = showRepository.findById(showId);
		Show s = sOptional.get();
		s.addComment(comment);
		comment.setShow(s);
		showRepository.save(s);
		return commentRepository.save(comment);
	}
	
	
	
	@GetMapping("/api/comment/{commentId}")
	public Optional<Comment> findCommentById(@PathVariable("commentId") int id) {
		return commentRepository.findById(id);
	}
	
	
	@GetMapping("/api/comment")
	public Iterable<Comment> findAllComment(){
			return commentRepository.findAll();
	}
	
	
	@PutMapping("/api/comment/{commentId}")
	public Comment updateComment(@PathVariable("commentId") int id, @RequestBody Comment newComment) {
		
		Optional<Comment> optional = commentRepository.findById(id);
		if(optional.isPresent()) {
			Comment comment = optional.get();
			if (newComment.getContext()!= null) {
				comment.setContext(newComment.getContext());
			}
			
			if (newComment.getCustomer()!= null) {
				comment.setCustomer(newComment.getCustomer());
			}
			
			if (newComment.getShow() != null) {
				comment.setShow(newComment.getShow());
			}
			return commentRepository.save(comment);
		}
		return null;
	}
	
	@DeleteMapping("/api/comment/{commentId}")
	public void deleteComment(@PathVariable("commentId") int id) {
		commentRepository.deleteById(id);
	}
	
}
