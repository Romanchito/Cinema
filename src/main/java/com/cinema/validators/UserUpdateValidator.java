package com.cinema.validators;

import com.cinema.entities.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserUpdateValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name" ,"Required");
        if(user.getName().length() < 4 || user.getName().length() > 30 ){
            errors.rejectValue("name" , "InValidUsername");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email" ,"Required");
        if(!EmailValidator.getInstance().isValid(user.getEmail())){
            errors.rejectValue("email" , "InValidEmail");
        }
    }
}
