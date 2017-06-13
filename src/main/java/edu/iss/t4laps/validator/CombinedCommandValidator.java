package edu.iss.t4laps.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.t4laps.model.CombinedCommand;


@Component
public class CombinedCommandValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> arg0) {
		return CombinedCommand.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CombinedCommand cc = (CombinedCommand) target;
		ValidationUtils.rejectIfEmpty(errors, "employee.emp_name", "error.cc.employee.employeeid.empty", "This field is empty");
		ValidationUtils.rejectIfEmpty(errors, "user.userId", "error.cc.user.userid.empty", "This field is empty");
		ValidationUtils.rejectIfEmpty(errors, "employee.email_address", "error.cc.employee.email_address.empty", "This field is empty");
		boolean result = true;
	    try {
	        InternetAddress emailAddr = new InternetAddress(cc.getEmployee().getEmail_address());
	        emailAddr.validate();
	    } catch (AddressException ex) {
	        result = false;
	    }
	    if(result==false)
	    {
	    	errors.reject("employee.email_address");
			errors.rejectValue("employee.email_address", "error.employee.email_address", "Email Address is invalid");
	    }
	    if(String.valueOf(cc.getEmployee().getMobile_no()).length()!=8)
	    {
	    	errors.reject("employee.mobile_no");
			errors.rejectValue("employee.mobile_no", "error.employee.mobile_no", "Mobile Number is invalid");
	    }	
		ValidationUtils.rejectIfEmpty(errors, "employee.designation", "error.cc.employee.designation.empty", "This field is empty");
		System.out.println(cc.toString());
	}

}