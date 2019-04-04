package edu.northeastern.cs5200.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

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

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CommentRepository commentRepository;
       
		
	@GetMapping("/api/customer")
	public Iterable<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/api/customer/{custId}")
	public Customer findCustomerById(@PathVariable("custId") int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/api/customer/{custId}/comment")
	public Set<Comment> findCommentByCustomerId(@PathVariable("custId") int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get().getComments();
		}
		return null;
	}
	
	
	@GetMapping("/api/customer/{custId}/ticket")
	public List<Ticket> findTicketByCustomerId(@PathVariable("custId") int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get().getboughtTickets();
		}
		return null;
	}
	
	@PostMapping("/api/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
//		System.out.println(customer.getFirstName());
		return customerRepository.save(customer);
	}
	
	
	
	@PutMapping("/api/customer/{custId}")
	public Customer updateCustomer(@PathVariable("custId") int id, @RequestBody Customer newCustomer) {
		
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			Customer customer = optional.get();
			if(newCustomer.getFirstName() != null) {
				customer.setFirstName(newCustomer.getFirstName());
			}
			if(newCustomer.getLastName() != null) {
				customer.setLastName(newCustomer.getLastName());
			}
			if(newCustomer.getUsername()!= null) {
				customer.setUsername(newCustomer.getUsername());
			}
			if(newCustomer.getPassword() != null) {
				customer.setPassword(newCustomer.getPassword());
			}
	
			return customerRepository.save(customer);
			
		}
		return null;
	}
	
	@DeleteMapping("/api/customer/{custId}")
	public void deleteCustomer(@PathVariable("custId") int id) {
		customerRepository.deleteById(id);
	}
	
	// login sign up as customer only
	// ----------------------------------
	
	
	@PostMapping("/api/customer/register")
	public Customer register(@RequestBody Customer customer,
			HttpSession session) {
		session.setAttribute("currentUser", customer);
		return customerRepository.save(customer);
	}
//	
//	
//	@GetMapping("/api/customer/profile")
//	public Customer profile(HttpSession session) {
//		Customer currentUser = (Customer)session.getAttribute("currentUser");	
//		return currentUser;
//	}
//	
//	@PostMapping("/api/customer/logout")
//	public void logout(HttpSession session) {
//		session.invalidate();
//	}
//	
//	@PostMapping("/api/customer/login")
//	public Customer login(
//			@RequestBody Customer credentials,
//			HttpSession session) {
//	 for (Customer customer : customerRepository.findAll()) {
//		 if( customer.getUsername().equals(credentials.getUsername())
//	   && customer.getPassword().equals(credentials.getPassword())) {
//			 session.setAttribute("currentUser", customer);
//	    return customer;
//	  }
//	 }
//	 return null;
//	}

}
