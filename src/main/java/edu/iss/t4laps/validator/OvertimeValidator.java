package edu.iss.t4laps.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.t4laps.model.Overtime;
import edu.iss.t4laps.service.EmployeeService;

@Component
public class OvertimeValidator implements Validator {

	@Autowired
	EmployeeService es;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Overtime.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Overtime ot = (Overtime) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "error.overtime.employeeid.empty", "This field is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "error.overtime.date.empty", "This field is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "extraHours", "error.overtime.extrahours.empty","This field is empty");
		if(es.findEmployee(ot.getEmployeeId())==null)
		{
			errors.reject("employeeId");
			errors.rejectValue("employeeId", "error.overtime.employeeid", "Employee does not exist");
		}
		System.out.println(ot.toString());
		
	}

}
