package edu.iss.t4laps.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

/**
 * Department class
 *
 * @version $Revision: 1.0
 */

@Entity
@Table(name = "leave_entitlements")
public class LeaveEntitlement {

	@Id
	@Column(name = "designation")
	private String designation;
	@Basic
	@Column(name = "annual_leave")
	@Digits(integer=3, fraction=0, message="The value must be numeric and no more than 3 digits")
	private int annual_leave;
	@Column(name = "medical_leave")
	@Digits(integer=3, fraction=0, message="The value must be numeric and no more than 3 digits")
	private int medical_leave;

	public LeaveEntitlement () {
	    }

	public LeaveEntitlement (String designation) {
	        this.setDesignation (designation);
	    }

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setAnnual_leave(int annual_leave) {
		this.annual_leave = annual_leave;
	}

	public int getAnnual_leave() {
		return annual_leave;
	}
	
	public void setMedical_leave(int medical_leave) {
		this.medical_leave = medical_leave;
	}

	public int getMedical_leave() {
		return medical_leave;
	}

}
