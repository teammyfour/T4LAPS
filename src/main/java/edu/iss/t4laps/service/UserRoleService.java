package edu.iss.t4laps.service;

import java.util.ArrayList;

import edu.iss.t4laps.model.UserRole;

public interface UserRoleService {
	
	ArrayList<UserRole> findAllRoles();
	UserRole findUserRole(String roleId);
	UserRole createUserRole(UserRole role);
	UserRole changeUserRole(UserRole role);
	void removeUserRole(UserRole role);
	ArrayList<String> findAllUserRolesNames();
	ArrayList<UserRole> findUserRoleByName(String name);


}
