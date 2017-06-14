package edu.iss.t4laps.service;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Date;

import edu.iss.t4laps.model.PublicHolidays;



public interface PublicHolidayService {
	
	ArrayList<PublicHolidays> findAllHoliday();

	PublicHolidays findPublicHoliday(Date holiday_date);

	PublicHolidays createPublicHoliday(PublicHolidays PublicHoliday);

	PublicHolidays changePublicHoliday(PublicHolidays PublicHoliday);

	void removePublicHoliday(PublicHolidays PublicHoliday);
	
	ArrayList<String> findAllPublicHoldiayOcasion();

	PublicHolidays findPublicHoldiayByOcasion(String ocasion);
	
	
}
