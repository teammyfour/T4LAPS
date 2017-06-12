package edu.iss.t4laps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.t4laps.model.UserRole;

@Component
public class UserRoleValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRole.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserRole r = (UserRole) target;
		ValidationUtils.rejectIfEmpty(errors, "roleId", "error.role.roleid.empty");
		ValidationUtils.rejectIfEmpty(errors, "name", "error.role.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "description", "error.role.description.empty");
		System.out.println(r.toString());
	}

}
