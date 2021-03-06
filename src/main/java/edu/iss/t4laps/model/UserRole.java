
package edu.iss.t4laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Course class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "role")
public class UserRole {
	@Id
	@Column(name = "roleId")
	private String roleId;
	@Column(name = "role_name")
	private String name;
	@Column(name = "description")
	private String description;
		public UserRole() {
	}
   // @OneToOne
   // @JoinColumn()
    //private Customer customer;
	public UserRole(String roleId, String name, String description) {

		this.roleId = roleId;
		this.name = name;
		this.description = description;

	}

	public UserRole(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		UserRole other = (UserRole) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

}