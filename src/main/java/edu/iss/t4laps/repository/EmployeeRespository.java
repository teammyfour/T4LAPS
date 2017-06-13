package edu.iss.t4laps.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.iss.t4laps.model.EmployeeDetails;


@Repository
public interface EmployeeRespository extends  JpaRepository<EmployeeDetails, Integer> {

	

	

}