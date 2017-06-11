package edu.iss.t4laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Employee class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name="employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //The @GeneratedValue annotation is to configure the way of increment of the specified
    //column(field). For example when using Mysql, you may specify auto_increment in the 
    //definition of table to make it self-incremental, and then use the generatedvalue in 
    //the Java code to denote that you also acknowledged to use this database server side strategy.
    private int employeeId;
    @Column(name="emp_name")
    private String employeeName;
    @Column(name="email_address")
    private String emailAddress;
    private String designation;
    private int managerId;

    public Employee() {
    }
    
    public Employee(int employeeId, String employeeName, String emailAddress, String designation, int managerId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emailAddress = emailAddress;
		this.designation = designation;
		this.managerId = managerId;
	}
    
	public Employee (int employeeId) {
        setEmployeeId(employeeId);
    }

    public void setEmployeeId (int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId () {
        return employeeId;
    }

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", managerId=" + managerId + ", emailAddress=" + emailAddress+", designation="+designation;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
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
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
    
}
