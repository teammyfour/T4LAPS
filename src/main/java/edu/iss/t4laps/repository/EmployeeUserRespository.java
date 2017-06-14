package edu.iss.t4laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.iss.t4laps.model.EmpUserRole;

@Repository
public interface EmployeeUserRespository  extends  JpaRepository<EmpUserRole, String>{

	
	
}
