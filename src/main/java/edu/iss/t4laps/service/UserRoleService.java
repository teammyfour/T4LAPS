package edu.iss.t4laps.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.iss.t4laps.model.UserRole;

@Service
public interface UserRoleService {
	
	ArrayList<UserRole> findAllRoles();
	UserRole findUserRole(String roleId);
	UserRole createUserRole(UserRole role);
	UserRole changeUserRole(UserRole role);
	void removeUserRole(UserRole role);
	ArrayList<String> findAllUserRolesNames(String userid);
	ArrayList<UserRole> findUserRoleByName(String name);
	ArrayList<String> findAllRoleId ();
	

}
