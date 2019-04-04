package edu.northeastern.cs5200.repositories;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query("SELECT customer FROM Customer customer WHERE customer.username=:u")
	public List<Customer> findCustomerByUsername(@Param("u") String username);

}
