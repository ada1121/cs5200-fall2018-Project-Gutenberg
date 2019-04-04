package edu.northeastern.cs5200.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer>{
//	
//	@Query(value="select t from Ticket t where t.customer_id=:id", nativeQuery=true)
//	List<Ticket> findAllTicketByCustomerID(@Param("id") int id);
//	
//
//

}
