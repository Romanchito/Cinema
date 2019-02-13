package com.cinema.validators;

import com.cinema.entities.Discount;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DiscountValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Discount.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Discount discount = (Discount)o;


        if(discount.getPercent() <5 || discount.getPercent()  > 20){
            errors.rejectValue("percent" , "InvalidDiscountPercent");
        }




    }
}
