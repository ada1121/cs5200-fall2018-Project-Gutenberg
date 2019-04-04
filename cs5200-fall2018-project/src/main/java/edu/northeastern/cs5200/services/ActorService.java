package edu.northeastern.cs5200.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
public class ActorService {
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	TheatreDao dao;
	
	@Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setMaxAge(3600L); 
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
        }
	
	
	@GetMapping("/api/actor")
	public Iterable<Actor> findAllActor() {
		return actorRepository.findAll();
	}
	
	@GetMapping("/api/actor/{actorId}")
	public Actor findActorById(@PathVariable("actorId") int id) {
		Optional<Actor> optional = actorRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	@GetMapping("/api/actor/{actorId}/show")
	public List<Show> findShowByActorId(@PathVariable("actorId") int id) {
		Optional<Actor> optional = actorRepository.findById(id);
		if(optional.isPresent()) {
			List<Show> shows = new ArrayList<Show>();
			for (Performance p: optional.get().getPerformedPerformances()) {
				shows.add(p.getShow());
			}
			return shows;
		}
		return null;
	}
	
	@PostMapping("/api/actor")
	public Actor createActor(@RequestBody Actor actor) {
		System.out.println(actor.getFirstName());
		return actorRepository.save(actor);
	}
	
	@PutMapping("/api/actor/{actorId}")
	public Actor updateActor(@PathVariable("actorId") int id, @RequestBody Actor newActor) {
		
		Optional<Actor> optional = actorRepository.findById(id);
		if(optional.isPresent()) {
			Actor actor = optional.get();
			if(newActor.getFirstName() != null) {
				actor.setFirstName(newActor.getFirstName());
			}
			if(newActor.getLastName() != null) {
				actor.setLastName(newActor.getLastName());
			}
			if(newActor.getUsername()!= null) {
				actor.setUsername(newActor.getUsername());
			}
			if(newActor.getPassword() != null) {
				actor.setPassword(newActor.getPassword());
			}
			
	
			return actorRepository.save(actor);
			
		}
		return null;
	}
	
	@PutMapping("/api/actor/{actorId}/show/{showId}")
	public void assignShowToActor(@PathVariable("actorId") int actorId, @PathVariable("showId") int showId) {
		Optional<Actor> aoptional = actorRepository.findById(actorId);
		Optional<Show> soptional = showRepository.findById(showId);
		Show s = soptional.get();
		Actor a = aoptional.get();
		dao.ActorGeneratePerformance(a, s);
	}
	
	
	
	@DeleteMapping("/api/actor/{actorId}")
	public void deleteActor(@PathVariable("actorId") int id) {
		actorRepository.deleteById(id);
	}

}
