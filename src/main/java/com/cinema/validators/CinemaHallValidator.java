package com.cinema.validators;

import com.cinema.entities.CinemaHall;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CinemaHallValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CinemaHall.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CinemaHall cinemaHall = (CinemaHall)o;


        if(cinemaHall.getName().length() <5 || cinemaHall.getName().length() > 20){
            errors.rejectValue("name" , "InvalidHallName");
        }

        if(cinemaHall.getCountOfRows() <= 0){
            errors.rejectValue("countOfRows" , "Positive");
        }

        if(cinemaHall.getCountOfPlaces() <= 0){
            errors.rejectValue("countOfPlaces" , "Positive");
        }





    }
}
