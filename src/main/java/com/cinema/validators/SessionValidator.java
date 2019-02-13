package com.cinema.validators;

import com.cinema.entities.Session;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SessionValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Session.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Session session = (Session)o;


        if(session.getCost() <=100 || session.getCost() > 1000){
            errors.rejectValue("cost" , "InvalidCostOfSession");
        }


    }
}
