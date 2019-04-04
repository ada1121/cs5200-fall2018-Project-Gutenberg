package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	@Query("SELECT person FROM Person person WHERE person.username=:u")
	public Iterable<Person> findPersonByUsername(@Param("u") String username);
	
	@Query("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password")
	public Person findPersonByCredentials(
			@Param("username") String username, 
			@Param("password") String password);

}
