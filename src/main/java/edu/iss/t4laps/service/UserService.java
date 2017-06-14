package edu.iss.t4laps.service;

import java.util.ArrayList;

import edu.iss.t4laps.model.UserRole;
import edu.iss.t4laps.model.User;

public interface UserService {
	
	User findUser(String userId);
	ArrayList<User> findAllUsers();
	User createUser(User user);
	User changeUser(User user);
	void removeUser(User user);
	ArrayList<UserRole> findRolesForUser(String userId);
	ArrayList<String> findRoleNamesForUser(String userId);
	ArrayList<String> findManagerNameByUID(String userId);	
	User authenticate(String uname, String pwd);
	User findUserByEmployeeId(int id);
	int validateUser(String userId, String password);

}

