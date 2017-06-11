package edu.iss.t4laps.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leave_history")
public class LeaveHistory {
	
	
	
	public static final String SUBMITTED = "SUBMITTED";
	public static final String APPROVED = "APPROVED";
	public static final String WITHDRAWN = "CANCEL";
	public static final String UPDATED = "UPDATED";
	public static final String REJECTED = "REJECTED";
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	private int employeeId;
	private String leavetype;
	private Date startDate;
	private Date endDate;
	private String reason;
	private String status;
	private int number_of_days;
	public LeaveHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getNumber_of_days() {
		return number_of_days;
	}
	public void setNumber_of_days(int number_of_days) {
		this.number_of_days = number_of_days;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public LeaveHistory(int leaveId, int employeeId, String leavetype, Date startDate, Date endDate, String reason,
			String status) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leavetype = leavetype;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
	}
	public LeaveHistory(int employeeId, String leavetype, Date startDate, Date endDate, String reason,String status) {
		super();
		
		this.employeeId = employeeId;
		this.leavetype = leavetype;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
	}
	public LeaveHistory(int employeeId, String leavetype, Date startDate, Date endDate, String reason, String status,
			int number_of_days) {
		super();
		this.employeeId = employeeId;
		this.leavetype = leavetype;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.number_of_days = number_of_days;
	}
	public LeaveHistory(int employeeId) {
		super();
		this.employeeId = employeeId;
	}
	
	

}
