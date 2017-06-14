package edu.iss.t4laps.model;

public class CombinedCommand {

	private EmployeeDetails employee;
	private User user;
	private EmpUserRole userRole;
	
	public CombinedCommand() {
		super();
		// TODO Auto-generated constructor stub
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

	public EmpUserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(EmpUserRole userRole) {
		this.userRole = userRole;
	}

	public CombinedCommand(EmployeeDetails employee, User user, EmpUserRole userRole) {
		super();
		this.employee = employee;
		this.user = user;
		this.userRole = userRole;
	}

	public CombinedCommand(EmployeeDetails employee, EmpUserRole userRole) {
		super();
		this.employee = employee;
		this.userRole = userRole;
	}
	

}
