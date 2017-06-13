package edu.iss.t4laps.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.t4laps.model.PublicHolidays;

public interface PublicHolidayRepository extends  JpaRepository<PublicHolidays, String> {

	@Query("SELECT p FROM PublicHolidays p where p.holiday_date= :holiday_date")
	PublicHolidays findPublicHoliday(@Param("holiday_date") Date holiday_date);
	
	@Query("SELECT p.occasion FROM PublicHolidays p")
	ArrayList<String> findAllPublicHoldiayOcasion();
	
	@Query("SELECT p FROM PublicHolidays p WHERE p.occasion = :occasion")
	PublicHolidays findPublicHoldiayByOcassion(@Param("occasion") String occasion);
}
