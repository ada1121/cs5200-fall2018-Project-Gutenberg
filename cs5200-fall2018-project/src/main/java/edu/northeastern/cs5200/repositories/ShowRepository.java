package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Show;

public interface ShowRepository extends CrudRepository<Show, Integer> {

}
