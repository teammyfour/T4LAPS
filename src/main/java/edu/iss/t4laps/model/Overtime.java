package edu.iss.t4laps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee_overtime_details")
public class Overtime implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="overtime_id")
	private int overtimeId;
	private int employeeId;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date date;
	@Column(name="extra_hours")
	private int extraHours;
	
	
	public int getOvertimeId() {
		return overtimeId;
	}
	public void setOvertimeId(int overtimeId) {
		this.overtimeId = overtimeId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getExtraHours() {
		return extraHours;
	}
	public void setExtraHours(int extraHours) {
		this.extraHours = extraHours;
	}
	
	
}
