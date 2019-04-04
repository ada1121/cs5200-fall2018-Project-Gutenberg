package edu.northeastern.cs5200.services;

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
public class TicketService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	PerformanceRepository performanceRepository;
		
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
//	@Bean
//    public FilterRegistrationBean corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*");
//        config.addAllowedMethod("*");
//        config.addAllowedHeader("*");
//        config.setMaxAge(3600L); 
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//        }
	
	
	@PostMapping("/api/ticket")
	public Ticket createTicket(@RequestBody Ticket t) {
		return ticketRepository.save(t);
	}
	
//	@GetMapping("/api/location")
//	public Iterable<Location> findLocation() {
//		return locationRepository.findAll();
//	}
	
	@PostMapping("/api/customer/{custId}/location/{locationId}/staff/{staffId}/ticket")
	public Ticket createTicketByAllId(@PathVariable("custId") int id, @PathVariable("locationId") int locationId, 
			@PathVariable("staffId")int staffId, @RequestBody Ticket ticket) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer c = optional.get();
		ticket.setCustomer(c);
		c.addTicket(ticket);
		customerRepository.save(c);
	

		Optional<Location> lOptional = locationRepository.findById(locationId);
		Location location = lOptional.get();
		ticket.setLocation(location);
		location.addTicket(ticket);
		locationRepository.save(location);
		
		Optional<Staff> soptional = staffRepository.findById(staffId);
		Staff s = soptional.get();
		ticket.setStaff(s);
		s.addTicket(ticket);
		staffRepository.save(s);
		return ticketRepository.save(ticket);
	}
	
	@GetMapping("/api/ticket")
	public Iterable<Ticket> getTicket() {
		return ticketRepository.findAll();
	}

	@DeleteMapping("/api/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") int id) {
		ticketRepository.deleteById(id);
	}
	

	// insert location
//	Location TD = new Location(1, "TD garden");
//	Location SH = new Location(2, "Symphony Hall");
//	locationRepository.save(TD);
//	locationRepository.save(SH);
	
	
	
	
	
	
	
}
