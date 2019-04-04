package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
