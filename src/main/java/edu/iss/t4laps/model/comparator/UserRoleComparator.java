package edu.iss.t4laps.model.comparator;

import java.util.Comparator;

import edu.iss.t4laps.model.UserRole;

public abstract class UserRoleComparator  implements Comparator<UserRole>{

	@Override
	public int compare(UserRole o1, UserRole o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
