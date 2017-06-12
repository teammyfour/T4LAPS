package edu.iss.t4laps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.iss.t4laps.model.Overtime;


@Repository
public interface OvertimeRespository extends  JpaRepository<Overtime, Integer> {

	

	

}
