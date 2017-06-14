package edu.iss.t4laps.service;

import java.util.ArrayList;

import edu.iss.t4laps.model.EmployeeDetails;

public interface EmployeeService {
	EmployeeDetails createEmployee(EmployeeDetails employee);
	
	ArrayList<EmployeeDetails> findAllEmployees();
	
	EmployeeDetails findEmployee(int employeeId);
	
	void removeEmployee(EmployeeDetails employee);

	EmployeeDetails changeEmployee(EmployeeDetails employee);
	
	ArrayList<Integer> findAllID();
	
	String EmployeeName(int id);
	
	ArrayList<EmployeeDetails> findSubordinates(int employeeId);
}
