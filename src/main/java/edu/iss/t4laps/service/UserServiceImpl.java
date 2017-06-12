package edu.iss.t4laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.User;
import edu.iss.t4laps.model.UserRole;
import edu.iss.t4laps.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
    @Resource
    private UserRepository userRepository;

	@Override
	@Transactional
	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findOne(userId);
	}

	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User changeUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	@Transactional
	public ArrayList<UserRole> findRolesForUser(String userId) {
		// TODO Auto-generated method stub
		return (ArrayList<UserRole>)userRepository.findOne(userId).getRoleSet();
	}

	@Override
	@Transactional
	public ArrayList<String> findRoleNamesForUser(String userId) {
		// TODO Auto-generated method stub
		ArrayList<UserRole> rset =  (ArrayList<UserRole>) userRepository.findOne(userId).getRoleSet();
		ArrayList<String> rnames = new ArrayList<String>();
		for (UserRole role : rset) {
			rnames.add(role.getName());
		}
		return rnames;
	}

	@Override
	@Transactional
	public ArrayList<String> findManagerNameByUID(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findManagerNameByUID(userId);
	}

	@Override
	@Transactional
	public User authenticate(String uname, String pwd) {
		// TODO Auto-generated method stub
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}

}
