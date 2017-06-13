package edu.iss.t4laps.service;

import java.util.ArrayList;

import edu.iss.t4laps.model.Overtime;

public interface OvertimeService {
	Overtime createOvertime(Overtime overtime);
	
	ArrayList<Overtime> findAllOvertime();
	
	Overtime findOvertime(int overtimeId);
	
	void removeOvertime(Overtime overtime);

	Overtime changeOvertime(Overtime overtime);
}
