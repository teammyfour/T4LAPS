package edu.iss.t4laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.repository.EmployeeRespository;
import edu.iss.t4laps.repository.OvertimeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Resource
	private EmployeeRespository eRepository;
	
	@Override
	@Transactional //persist the data
	public EmployeeDetails createEmployee(EmployeeDetails employee) {
		return eRepository.saveAndFlush(employee);
	}

	@Override
	@Transactional
	public ArrayList<EmployeeDetails> findAllEmployees() {
		ArrayList<EmployeeDetails> list = (ArrayList<EmployeeDetails>) eRepository.findAll();
		return list;
	}

	@Override
	@Transactional
	public EmployeeDetails findEmployee(int employeeId) {
		return eRepository.findOne(employeeId);
	}

	@Override
	@Transactional 
	public void removeEmployee(EmployeeDetails employee) {
		eRepository.delete(employee);
		
	}

	@Override
	@Transactional
	public EmployeeDetails changeEmployee(EmployeeDetails employee) {
		return eRepository.saveAndFlush(employee);
	}
	
	@Override
	public ArrayList<Integer> findAllID() {
		return eRepository.findAllID();
	}

}

