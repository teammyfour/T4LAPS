package edu.iss.t4laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.t4laps.model.UserRole;

public interface UserRoleRepository extends  JpaRepository<UserRole, String> {
	
	@Query("SELECT ur.name FROM UserRole ur where ur.roleId=(select e.roleId FROM EmpUserRole e where e.userID=:userid)")
	ArrayList<String> findAllRolesNames(@Param("userid") String userid);
	
	@Query("SELECT ur FROM UserRole ur WHERE ur.name = :name")
	ArrayList<UserRole> findRoleByName(@Param("name") String name);
}
