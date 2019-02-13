package com.cinema.validators;

import com.cinema.entities.Place;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class PlaceValidator implements Validator {

    @Autowired
    @Qualifier(value = "placeService")
    private Servicable<Place> placeServicable;

    @Override
    public boolean supports(Class<?> aClass) {
        return Place.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Place place = (Place)o;


        if(place.getNumber() <=0 ){
            errors.rejectValue("number" , "Positive");
        }

        if(place.getNumber() <=0 ){
            errors.rejectValue("row" , "Positive");
        }


        if(place.getNumber() > place.getCinemaHall().getCountOfPlaces() ){
            errors.rejectValue("number" , "InvalidTypeOfNumberPlace");
        }

        if(place.getRow() > place.getCinemaHall().getCountOfRows()){
            errors.rejectValue("row" , "InvalidTypeOfRowPlace");
        }


        if(!chaekPlace(place.getRow() , place.getNumber())){
            errors.rejectValue("number" , "Exist");
        }


    }

    private boolean chaekPlace(int row , int place){

        int el_row , el_place;
        List<Place> places = placeServicable.getAll();
        for (Place elem : places){
            el_row = elem.getRow();
            el_place = elem.getNumber();
            if(el_place == place && place == el_place){
                return  false;
            }
        }

        return true;

    }
}
