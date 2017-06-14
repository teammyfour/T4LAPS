package edu.iss.t4laps.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.iss.t4laps.model.EmployeeDetails;


@Repository
public interface EmployeeRespository extends  JpaRepository<EmployeeDetails, Integer> {
	
	//-----------new code------------//
	@Query("SELECT DISTINCT e.employeeId FROM EmployeeDetails e")
	ArrayList<Integer> findAllID();

	@Query("Select e.emp_name from EmployeeDetails e WHERE e.employeeId=:Id")
	String EmployeeName(@Param("Id") int Id);
	@Query("SELECT DISTINCT e2 FROM EmployeeDetails e1, EmployeeDetails e2 WHERE e1.employeeId = e2.managerId AND e1.employeeId = :eid")
	ArrayList<EmployeeDetails> findSubordinates(@Param("eid") int eid);	

}