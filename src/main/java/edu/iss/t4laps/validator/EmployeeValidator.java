package edu.iss.t4laps.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.t4laps.model.EmployeeDetails;



@Component
public class EmployeeValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> arg0) {
		return EmployeeDetails.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		EmployeeDetails employee = (EmployeeDetails) target;
		ValidationUtils.rejectIfEmpty(errors, "employeeId", "error.employee.employeeid.empty", "This field is empty");
		ValidationUtils.rejectIfEmpty(errors, "emp_name", "error.employee.emp_name.empty", "This field is empty");
		ValidationUtils.rejectIfEmpty(errors, "email_address", "error.employee.email_address.empty", "This field is empty");
		boolean result = true;
	    try {
	        InternetAddress emailAddr = new InternetAddress(employee.getEmail_address());
	        emailAddr.validate();
	    } catch (AddressException ex) {
	        result = false;
	    }
	    if(result==false)
	    {
	    	errors.reject("email_address");
			errors.rejectValue("email_address", "error.employee.email_address", "Email Address is invalid");
	    }
	    if(String.valueOf(employee.getMobile_no()).length()!=8)
	    {
	    	errors.reject("mobile_no");
			errors.rejectValue("mobile_no", "error.employee.mobile_no", "Mobile Number is invalid");
	    }	
		System.out.println(employee.toString());
	}

}
