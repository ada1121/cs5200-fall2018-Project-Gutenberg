package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {

}
