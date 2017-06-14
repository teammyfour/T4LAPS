package edu.iss.t4laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.EmpUserRole;
import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.repository.EmployeeUserRespository;

@Service
public class EmployeeUserRoleServiceImpl implements EmployeeUserRoleService{

	@Resource
	private EmployeeUserRespository eurRepository;
	
	@Override
	@Transactional
	public EmpUserRole createEmpUserRole(EmpUserRole eur) {
		return eurRepository.saveAndFlush(eur);
	}

	@Override
	@Transactional
	public ArrayList<EmpUserRole> findAllEmpUserRoles() {
		ArrayList<EmpUserRole> list = (ArrayList<EmpUserRole>) eurRepository.findAll();
		return list;
	}

	@Override
	@Transactional
	public EmpUserRole findEmployeeUserRole(String userId) {
		return eurRepository.findOne(userId);
	}

	@Override
	@Transactional
	public void removeEmployeeUserRole(EmpUserRole eur) {
		eurRepository.delete(eur);
		
	}

	@Override
	@Transactional
	public EmpUserRole changeEmployeeUserRole(EmpUserRole eur) {
		return eurRepository.saveAndFlush(eur);
	}

	

}
