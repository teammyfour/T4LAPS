package edu.iss.t4laps.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department class
 *
 * @version $Revision: 1.0
 */

@Entity
@Table(name = "leave_entitlement")
public class LeaveEntitlement {

	@Id
	@Column(name = "designation")
	private String designation;
	@Basic
	@Column(name = "annual_leave")
	private int annual_leave;
	@Column(name = "medical_leave")
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
