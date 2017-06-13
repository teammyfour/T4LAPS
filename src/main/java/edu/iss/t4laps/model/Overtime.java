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
import javax.validation.Constraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee_overtime_details")
public class Overtime implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="overtime_id")
	@NotNull
	private int overtimeId;
	private int employeeId;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull
	private Date date;
	@Column(name="extra_hours")
	@NotNull
	@Digits(integer=1, fraction=0, message="The value must be numeric and no more than 1 digit")
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
