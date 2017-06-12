package edu.iss.t4laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.t4laps.model.UserRole;

public interface UserRoleRepository extends  JpaRepository<UserRole, String> {
	
	@Query("SELECT r.name FROM UserRole r")
	ArrayList<String> findAllRolesNames();
	
	@Query("SELECT r FROM UserRole r WHERE r.name = :name")
	ArrayList<UserRole> findRoleByName(@Param("name") String name);
}
