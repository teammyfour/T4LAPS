package edu.iss.t4laps.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.model.User;


@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	private String sessionId = null;
	private User user = null;
	private EmployeeDetails employee = null;
	private ArrayList<EmployeeDetails> subordinates = null;
	
	public UserSession() {
		super();
		// TODO Auto-generated constructor stub		
	}

	public UserSession(String sessionId, User user, EmployeeDetails employee, ArrayList<EmployeeDetails> subordinates) {
		super();
		this.sessionId = sessionId;
		this.user = user;
		this.employee = employee;
		this.subordinates = subordinates;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EmployeeDetails getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDetails employee) {
		this.employee = employee;
	}

	public ArrayList<EmployeeDetails> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(ArrayList<EmployeeDetails> subordinates) {
		this.subordinates = subordinates;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result =1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;	
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}
	

}
