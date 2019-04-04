package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Location;

public interface LocationRepository extends CrudRepository<Location, Integer>{

}
