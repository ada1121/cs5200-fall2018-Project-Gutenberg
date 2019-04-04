package edu.northeastern.cs5200.services;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@CrossOrigin(origins="*")
@RestController
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	CustomerRepository customerRepository;
//	
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
	
	
	@PostMapping("/api/person")
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping("/api/person/{personId}")
	public Optional<Person> findPersonById(@PathVariable("personId") int id) {
		return personRepository.findById(id);
	}
	
//	@GetMapping("/api/person")
//	public List<Person> findAllPerson(
//			@RequestParam(name="username", required=false) String username,
//			@RequestParam(name="password", required=false) String password
//			) {
//		if(username != null && password != null) {
//			return (List<Person>) personRepository.findPersonByCredentials(username, password);
//		} 	
//		else if(username != null) {
//			return (List<Person>) personRepository.findPersonByPersonname(username);
//		}
//			System.out.println("in person service");
//			return (List<Person>) personRepository.findAll();
//	}
	
	
	@GetMapping("/api/person")
	public Person findAllPersonByCredentials(
			@RequestParam(name="username", required=false) String username,
			@RequestParam(name="password", required=false) String password
			) {
		if(username != null && password != null) {
			return personRepository.findPersonByCredentials(username, password);
		} 	
		return null;
	}
	
	@GetMapping("/api/persons")
	public Iterable<Person> findAllPerson(){
			return personRepository.findAll();
	}
	
	@GetMapping("/api/profile")
	public Person profile(HttpSession session) {
		Person currentUser = (Person)session.getAttribute("currentUser");	
		return currentUser;
	}
	
	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@PostMapping("/api/login")
	public Person login(
			@RequestBody Person credentials,
			HttpSession session) {
		return personRepository.findPersonByCredentials(credentials.getUsername(), credentials.getPassword());
//	 for (Person p : personRepository.findAll()) {
//		 if( p.getUsername().equals(credentials.getUsername())
//	   && p.getPassword().equals(credentials.getPassword())) {
//			 session.setAttribute("currentUser", p);
//	    return p;
//	  }
//	 }
//	 return null;
	}
	
	
	@PutMapping("/api/person/{personId}")
	public Person updatePerson(@PathVariable("personId") int id, @RequestBody Person newPerson) {
		
		Optional<Person> optional = personRepository.findById(id);
		if(optional.isPresent()) {
			Person person = optional.get();
			if(newPerson.getFirstName() != null) {
				person.setFirstName(newPerson.getFirstName());
			}
			if(newPerson.getLastName() != null) {
				person.setLastName(newPerson.getLastName());
			}
			if(newPerson.getUsername()!= null) {
				person.setUsername(newPerson.getUsername());
			}
			if(newPerson.getPassword() != null) {
				person.setPassword(newPerson.getPassword());
			}
	
			return personRepository.save(person);
			
		}
		return null;
	}
	
	@DeleteMapping("/api/person/{personId}")
	public void deletePerson(@PathVariable("personId") int id) {
		personRepository.deleteById(id);
	}

	
	
	
}
