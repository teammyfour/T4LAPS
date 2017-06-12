package edu.iss.t4laps.model.comparator;

import java.util.Comparator;

import edu.iss.t4laps.model.UserRole;

public class UserRoleComparator  implements Comparator<UserRole>{

	@Override
	public int compare(UserRole o1, UserRole o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}

