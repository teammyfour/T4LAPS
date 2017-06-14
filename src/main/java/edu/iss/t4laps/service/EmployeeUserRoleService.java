package edu.iss.t4laps.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.iss.t4laps.model.EmpUserRole;
import edu.iss.t4laps.model.EmployeeDetails;

@Service
public interface EmployeeUserRoleService {

	EmpUserRole createEmpUserRole(EmpUserRole eur);
	
	ArrayList<EmpUserRole> findAllEmpUserRoles();
	
	EmpUserRole findEmployeeUserRole(String userId);
	
	void removeEmployeeUserRole(EmpUserRole eur);

	EmpUserRole changeEmployeeUserRole(EmpUserRole eur);
}
