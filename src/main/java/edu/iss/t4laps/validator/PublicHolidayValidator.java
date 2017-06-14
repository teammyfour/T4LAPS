package edu.iss.t4laps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.t4laps.model.PublicHolidays;

@Component
public class PublicHolidayValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PublicHolidays.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		PublicHolidays r = (PublicHolidays) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "holiday_date", "error.occasion.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "occasion", "error.occasion.empty");
		System.out.println(r.toString());

	}

}
