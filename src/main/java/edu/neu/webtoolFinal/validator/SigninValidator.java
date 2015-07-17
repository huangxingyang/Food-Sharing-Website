package edu.neu.webtoolFinal.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.User;
@Component
public class SigninValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
	
		return User.class.equals(clazz)||Dish.class.equals(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.name", "Name cannot be Empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Password cannot be Empty!");
		
		
	}

}
