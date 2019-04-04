package edu.northeastern.cs5200.services;

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
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;
	
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
	
	
	
	@GetMapping("/api/manager")
	public Iterable<Manager> findAllManager() {
		return managerRepository.findAll();
	}
	
	@GetMapping("/api/manager/{managerId}")
	public Manager findManagerById(@PathVariable("managerId") int id) {
		Optional<Manager> optional = managerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	@PostMapping("/api/manager")
	public Manager createManager(@RequestBody Manager manager) {
		System.out.println(manager.getFirstName());
		return managerRepository.save(manager);
	}
	
	@PutMapping("/api/manager/{managerId}")
	public Manager updateManager(@PathVariable("managerId") int id, @RequestBody Manager newManager) {
		
		Optional<Manager> optional = managerRepository.findById(id);
		if(optional.isPresent()) {
			Manager manager = optional.get();
			if(newManager.getFirstName() != null) {
				manager.setFirstName(newManager.getFirstName());
			}
			if(newManager.getLastName() != null) {
				manager.setLastName(newManager.getLastName());
			}
			if(newManager.getUsername()!= null) {
				manager.setUsername(newManager.getUsername());
			}
			if(newManager.getPassword() != null) {
				manager.setPassword(newManager.getPassword());
			}
	
			return managerRepository.save(manager);
			
		}
		return null;
	}
	
	
	@DeleteMapping("/api/manager/{managerId}")
	public void deleteManager(@PathVariable("managerId") int id) {
		managerRepository.deleteById(id);
	}


}
