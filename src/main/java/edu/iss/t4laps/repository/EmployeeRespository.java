package edu.iss.t4laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.iss.t4laps.model.EmployeeDetails;


@Repository
public interface EmployeeRespository extends  JpaRepository<EmployeeDetails, Integer> {

	@Query("SELECT DISTINCT e.employeeId FROM EmployeeDetails e")
	ArrayList<Integer> findAllID();

	@Query("Select e.emp_name from EmployeeDetails e WHERE e.employeeId=:Id")
	String EmployeeName(@Param("Id") int Id);
}