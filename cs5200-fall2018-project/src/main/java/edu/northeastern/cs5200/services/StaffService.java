package edu.northeastern.cs5200.services;

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

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StaffService {
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
//	
	
	
	@GetMapping("/api/staff")
	public Iterable<Staff> findAllStaff() {
		return staffRepository.findAll();
	}
	
	@GetMapping("/api/staff/{staffId}")
	public Staff findStaffById(@PathVariable("staffId") int id) {
		Optional<Staff> optional = staffRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	@GetMapping("/api/staff/{staffId}/ticket")
	public List<Ticket> findTicketByStaffId(@PathVariable("staffId") int id) {
		Optional<Staff> optional = staffRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get().getSoldtickets();
		}
		return null;
	}
	
	
	@PostMapping("/api/staff")
	public Staff createStaff(@RequestBody Staff staff) {
		System.out.println(staff.getFirstName());
		return staffRepository.save(staff);
	}
	
	@PutMapping("/api/staff/{staffId}")
	public Staff updateStaff(@PathVariable("staffId") int id, @RequestBody Staff newStaff) {
		
		Optional<Staff> optional = staffRepository.findById(id);
		if(optional.isPresent()) {
			Staff staff = optional.get();
			if(newStaff.getFirstName() != null) {
				staff.setFirstName(newStaff.getFirstName());
			}
			if(newStaff.getLastName() != null) {
				staff.setLastName(newStaff.getLastName());
			}
			if(newStaff.getUsername()!= null) {
				staff.setUsername(newStaff.getUsername());
			}
			if(newStaff.getPassword() != null) {
				staff.setPassword(newStaff.getPassword());
			}
			if(newStaff.getwork() != null) {
				staff.setwork(newStaff.getwork());
			}
	
			return staffRepository.save(staff);
			
		}
		return null;
	}
	
	
	@DeleteMapping("/api/staff/{staffId}")
	public void deleteStaff(@PathVariable("staffId") int id) {
		staffRepository.deleteById(id);
	}

}
