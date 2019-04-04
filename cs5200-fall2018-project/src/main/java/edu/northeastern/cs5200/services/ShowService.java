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
public class ShowService {
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired 
	TheatreDao dao;
	
	@Autowired
	PerformanceRepository performanceRepository;
	
	
	@GetMapping("/api/show")
	public Iterable<Show> findAllShow() {
		return showRepository.findAll();
	}
	
	@GetMapping("/api/show/{showId}/actor")
	public Iterable<Actor> findActorByShowId(@PathVariable("showId") int showId) {
		Optional<Show> optional = showRepository.findById(showId);
		List <Actor> actors = new ArrayList<Actor>();
		if (optional.isPresent()) {
			for (Performance p: optional.get().getPerformances()) {
				actors.add(p.getActor());
				}
		}
		return actors;
	}
		
	@PostMapping("/api/show")
	public Show createShow(@RequestBody Show show) {
		return showRepository.save(show);
	}
	
	@PostMapping("/api/actor/{actorId}/show")
	public Show createShowByActor(@PathVariable("actorId") int actorId,
			@RequestBody Show show) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		Actor a = optional.get();
		dao.ActorGeneratePerformance(a, show);
				
		return showRepository.save(show);
	}
	

	
	@DeleteMapping("/api/show/{showId}")
	public void deleteShowById(@PathVariable("showId") int id) {
		Optional<Show> optional = showRepository.findById(id);
		Show s = optional.get();
		for (Performance p: s.getPerformances()) {
			//Actor a = p.getActor();
			performanceRepository.deleteById(p.getId());
			//System.out.println("delete performance" + p.getId());
			//a.getPerformedPerformances()
//			//actorRepository.save(a);
//			System.out.println("actorR updated");
//			showRepository.save(s);
//			System.out.println("showR updated");
		}
		
		showRepository.deleteById(id);
	}

}
