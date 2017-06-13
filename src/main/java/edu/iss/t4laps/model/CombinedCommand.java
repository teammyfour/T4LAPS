package edu.iss.t4laps.model;

public class CombinedCommand {

	private EmployeeDetails employee;
	private User user;
	
	public CombinedCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CombinedCommand(EmployeeDetails employee, User user) {
		super();
		this.employee = employee;
		this.user = user;
	}
	
	public EmployeeDetails getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDetails employee) {
		this.employee = employee;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
