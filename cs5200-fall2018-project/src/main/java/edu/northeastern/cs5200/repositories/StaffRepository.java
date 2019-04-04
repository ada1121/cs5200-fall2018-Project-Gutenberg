package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

}
