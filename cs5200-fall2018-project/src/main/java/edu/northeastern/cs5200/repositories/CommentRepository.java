package edu.northeastern.cs5200.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Comment;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Show;

public interface CommentRepository extends CrudRepository<Comment, Integer>{
//	
//	@Query(value = "SELECT c.* FROM comment c WHERE c.customer_id := id", nativeQuery = true)
//	List<Comment> findCommentByCustomerId(@Param("id") int id);
	
}
