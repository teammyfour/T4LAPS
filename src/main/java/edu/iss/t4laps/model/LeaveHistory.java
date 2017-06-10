package edu.iss.t4laps.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import edu.iss.t4laps.model.LeaveHistory;

/**
 * LeaveHistory class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "leave_history")
public class LeaveHistory {

	public static final String SUBMITTED = "SUBMITTED";
	public static final String APPROVED = "APPROVED";
	public static final String WITHDRAWN = "WITHDRAWN";
	public static final String UPDATED = "UPDATED";
	public static final String REJECTED = "REJECTED";

	/** Attributes for LeaveHistory **/
	@Id
	@Column(name = "leaveId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	@Basic
	@Column(name = "employeeId")
	private String employeeId;
	@Column(name = "leavetype")
	private String leaveType;
	@Temporal(TemporalType.TIME)
	@Column(name = "startDate")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss'Z'")
	private Date startDate;
	@Temporal(TemporalType.TIME)
	@Column(name = "endDate")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss'Z'")
	private Date endDate;
	@Basic
	@Column(name = "reason")
	private String reason;
	@Column(name = "status")
	private String status;

	public LeaveHistory() {
	}

	public LeaveHistory(int leaveId) {
		this.leaveId = leaveId;
	}

	public LeaveHistory(int leaveId, String employeeId, String leaveType, Date startDate, Date endDate,
		  String reason, String status) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leaveId;
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
		LeaveHistory other = (LeaveHistory) obj;
		if (leaveId != other.leaveId)
			return false;
		return true;
	}

	
}
