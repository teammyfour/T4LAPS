package edu.iss.t4laps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
    private String emp_name;
    private String email_address;
    private String mobile_no;
    private String designation;
    private int managerId;
	
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDetails(int employeeId, String emp_name, String email_address, String mobile_no, String designation,
			int managerId) {
		super();
		this.employeeId = employeeId;
		this.emp_name = emp_name;
		this.email_address = email_address;
		this.mobile_no = mobile_no;
		this.designation = designation;
		this.managerId = managerId;
	}

	public EmployeeDetails(int employeeId, String emp_name, String email_address, String mobile_no,
			String designation) {
		super();
		this.employeeId = employeeId;
		this.emp_name = emp_name;
		this.email_address = email_address;
		this.mobile_no = mobile_no;
		this.designation = designation;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}
