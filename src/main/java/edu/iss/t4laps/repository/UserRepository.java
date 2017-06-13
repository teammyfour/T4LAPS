package edu.iss.t4laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.t4laps.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT DISTINCT e2.emp_name FROM User u, EmployeeDetails e1, EmployeeDetails e2 WHERE u.employeeId = e1.employeeId AND e1.managerId = e2.employeeId AND u.userId=:uid")
	ArrayList<String> findManagerNameByUID(@Param("uid") String uid);
    
	@Query("SELECT u FROM User u WHERE u.name=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	@Query("SELECT u FROM User u WHERE u.employeeId=:uei")
	User findUserByEmployeeId(@Param("uei") int uempId);
	

}

