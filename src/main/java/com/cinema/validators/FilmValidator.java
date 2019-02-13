package com.cinema.validators;

import com.cinema.entities.Film;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FilmValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Film.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Film film = (Film)o;


        if(film.getName().length() <=0 || film.getName().length() > 50){
            errors.rejectValue("name" , "InvalidFilmName");
        }


        if(film.getAge_category() != 0 && film.getAge_category() != 6 &&
           film.getAge_category() != 12 && film.getAge_category() != 16
           && film.getAge_category() != 18){
           errors.rejectValue("age_category" , "InvalidFilmAgeCategory");
        }

        if(film.getDuration() <=0){
            errors.rejectValue("duration" , "Positive");
        }

        if(film.getDuration() >0 && film.getDuration() <60 || film.getDuration() > 400 ){
            errors.rejectValue("duration" , "InvalidFilmDuration");
        }

        if(film.getDescription().length() >150){
            errors.rejectValue("duration" , "InvalidFilmDescription");
        }

    }
}
