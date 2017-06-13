package edu.iss.t4laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.UserRole;
import edu.iss.t4laps.repository.UserRoleRepository;
@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Resource
	private UserRoleRepository userRoleRepository;

	@Override
	@Transactional
	public ArrayList<UserRole> findAllRoles() {
		// TODO Auto-generated method stub
		ArrayList<UserRole> ul = (ArrayList<UserRole>) userRoleRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public UserRole findUserRole(String roleId) {
		// TODO Auto-generated method stub
		return userRoleRepository.findOne(roleId);
	}

	@Override
	@Transactional
	public UserRole createUserRole(UserRole role) {
		// TODO Auto-generated method stub
		return userRoleRepository.saveAndFlush(role);
	}

	@Override
	@Transactional
	public UserRole changeUserRole(UserRole role) {
		// TODO Auto-generated method stub
		return userRoleRepository.saveAndFlush(role);
	}

	@Override
	@Transactional
	public void removeUserRole(UserRole role) {
		// TODO Auto-generated method stub
		userRoleRepository.delete(role);
	}

	@Override
	@Transactional	
	public ArrayList<String> findAllUserRolesNames(String userid) {
		// TODO Auto-generated method stub
		return userRoleRepository.findAllRolesNames(userid);
	}

	@Override
	@Transactional
	public ArrayList<UserRole> findUserRoleByName(String name) {
		// TODO Auto-generated method stub
		return userRoleRepository.findRoleByName(name);
	}

}
