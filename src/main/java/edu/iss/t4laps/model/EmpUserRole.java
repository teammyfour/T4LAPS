package edu.iss.t4laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class EmpUserRole {
		@Id
		@Column(name = "roleId")
		private String roleId;
		@Column(name = "userId")
		private String userID;
			public EmpUserRole() {
		}
			public EmpUserRole(String roleId, String userID) {
				super();
				this.roleId = roleId;
				this.userID = userID;
			}
			public String getRoleId() {
				return roleId;
			}
			public void setRoleId(String roleId) {
				this.roleId = roleId;
			}
			public String getUserID() {
				return userID;
			}
			public void setUserID(String userID) {
				this.userID = userID;
			}

}
